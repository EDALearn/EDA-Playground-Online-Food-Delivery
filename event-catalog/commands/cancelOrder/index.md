---
id: cancelOrder
version: 0.0.1
name: cancelOrder
summary: cancelOrder
schemaPath: request-body.json
badges:
  - content: PUT
    textColor: blue
    backgroundColor: blue
  - content: 'tag:Orders'
    textColor: blue
    backgroundColor: blue
---
## Architecture
<NodeGraph />



## PUT `(/orders/{orderId}/cancel)`

### Parameters
- **orderId** (path) (required)



### Request Body
<SchemaViewer file="request-body.json" maxHeight="500" id="request-body" />


### Responses
**200 Response**
<SchemaViewer file="response-200.json" maxHeight="500" id="response-200" />
