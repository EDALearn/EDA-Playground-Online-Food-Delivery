const chalk = require('chalk')
const { Kafka, logLevel } = require('kafkajs')

const kafka = new Kafka({
  logLevel: logLevel.WARN,
  brokers: [`localhost:9092`],
  clientId: 'logger-consumer',
  ssl: false,
  sasl: false
})

const consumer = kafka.consumer({ groupId: 'logger-group' })

const topics = {
    "customer.events": {
        server: "Customers",
        color: "green"
    },
    "customer.address-events": {
        server: "Customers",
        color: "green"
    },
    "orders.cancel_orders": {
        server: "Orders",
        color: "red"
    },
    "orders.orders": {
        server: "Orders",
        color: "red"
    },
    "orders.order_updates": {
        server: "Orders",
        color: "red"
    },
    "restaurants.kitchen_order_status": {
        server: "Restaurants",
        color: "yellow"
    },
    "delivery.delivery_status": {
        server: "Delivery",
        color: "blue"
    }
}

const run = async () => {
  await consumer.connect()
  for (const topic in topics) {
    await consumer.subscribe({ topic, fromBeginning: true })
  }
  await consumer.run({
    // eachBatch: async ({ batch }) => {
    //   console.log(batch)
    // },
    eachMessage: async ({ topic, partition, message }) => {
      const prefix = `[${new Date(parseInt(message.timestamp)).toISOString()}] ${topics[topic].server.toUpperCase()}`;
      const color = topics[topic].color;
      console.log(chalk[color](`${prefix} [${topic}]`));
      console.log(chalk[color](`${JSON.stringify(JSON.parse(message.value.toString()), null, 2)}`));
    },
  })
}

run().catch(e => console.error(`[example/consumer] ${e.message}`, e))

const errorTypes = ['unhandledRejection', 'uncaughtException']
const signalTraps = ['SIGTERM', 'SIGINT', 'SIGUSR2']

errorTypes.forEach(type => {
  process.on(type, async e => {
    try {
      console.log(`process.on ${type}`)
      console.error(e)
      await consumer.disconnect()
      process.exit(0)
    } catch (_) {
      process.exit(1)
    }
  })
})

signalTraps.forEach(type => {
  process.once(type, async () => {
    try {
      await consumer.disconnect()
    } finally {
      process.kill(process.pid, type)
    }
  })
})
