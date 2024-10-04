---
id: searchKitchenOrders
version: 0.0.1
name: searchKitchenOrders
summary: searchKitchenOrders
schemaPath: request-body.json
badges:
  - content: POST
    textColor: blue
    backgroundColor: blue
  - content: 'tag:RestaurantOrders'
    textColor: blue
    backgroundColor: blue
---
## Architecture
<NodeGraph />



## POST `(/restaurants-orders)`

### Parameters
- **page** (query): The number of results page
- **limit** (query): The number of results in a single page
- **sort** (query): The number of results page



### Request Body
<SchemaViewer file="request-body.json" maxHeight="500" id="request-body" />


### Responses
**201 Response**
<SchemaViewer file="response-201.json" maxHeight="500" id="response-201" />
