---
id: orders
version: 0.0.1
name: ZenWave Online Food Delivery - Orders Module
summary: ZenWave Online Food Delivery - Orders Module
schemaPath: openapi.yml
specifications:
  openapiPath: openapi.yml
  asyncapiPath: asyncapi.yml
badges:
  - content: Default
    textColor: blue
    backgroundColor: blue
  - content: Orders
    textColor: blue
    backgroundColor: blue
sends:
  - id: ordereventmessage
    version: 0.0.1
  - id: orderstatusupdatedmessage
    version: 0.0.1
receives:
  - id: cancelorderinputmessage
    version: 0.0.1
  - id: getCustomerOrder
    version: 0.0.1
  - id: updateOrder
    version: 0.0.1
  - id: createOrder
    version: 0.0.1
  - id: cancelOrder
    version: 0.0.1
  - id: searchOrders
    version: 0.0.1
---
## Architecture diagram
<NodeGraph />
