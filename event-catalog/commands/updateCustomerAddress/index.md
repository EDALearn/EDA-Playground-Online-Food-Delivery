---
id: updateCustomerAddress
version: 0.0.1
name: updateCustomerAddress
summary: Updates a the customer address identified by address.identifier
schemaPath: request-body.json
badges:
  - content: PUT
    textColor: blue
    backgroundColor: blue
  - content: 'tag:Customer'
    textColor: blue
    backgroundColor: blue
---
## Architecture
<NodeGraph />



## PUT `(/customers/{customerId}/address/{identifier})`

### Parameters
- **customerId** (path) (required)
- **identifier** (path) (required)



### Request Body
<SchemaViewer file="request-body.json" maxHeight="500" id="request-body" />


### Responses
**200 Response**
<SchemaViewer file="response-200.json" maxHeight="500" id="response-200" />
