---
id: delivery
version: 0.0.1
name: ZenWave Online Food Delivery - Delivery Module
summary: ZenWave Online Food Delivery - Delivery Module
schemaPath: openapi.yml
specifications:
  openapiPath: openapi.yml
  asyncapiPath: asyncapi.yml
badges:
  - content: Default
    textColor: blue
    backgroundColor: blue
  - content: Delivery
    textColor: blue
    backgroundColor: blue
sends:
  - id: deliverystatusupdatedmessage
    version: 0.0.1
receives:
  - id: updateDeliveryStatus
    version: 0.0.1
  - id: listDeliveries
    version: 0.0.1
---
## Architecture diagram
<NodeGraph />
