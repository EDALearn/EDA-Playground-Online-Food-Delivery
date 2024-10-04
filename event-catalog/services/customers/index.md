---
id: customers
version: 0.0.1
name: ZenWave Online Food Delivery - Customers Module
summary: ZenWave Online Food Delivery - Customers Module
schemaPath: openapi.yml
specifications:
  openapiPath: openapi.yml
  asyncapiPath: asyncapi.yml
badges:
  - content: Default
    textColor: blue
    backgroundColor: blue
  - content: Customer
    textColor: blue
    backgroundColor: blue
sends:
  - id: customereventmessage
    version: 0.0.1
  - id: customeraddressupdatedmessage
    version: 0.0.1
receives:
  - id: createCustomer
    version: 0.0.1
  - id: listCustomers
    version: 0.0.1
  - id: updateCustomer
    version: 0.0.1
  - id: deleteCustomer
    version: 0.0.1
  - id: getCustomer
    version: 0.0.1
  - id: updateCustomerAddress
    version: 0.0.1
---
## Architecture diagram
<NodeGraph />
