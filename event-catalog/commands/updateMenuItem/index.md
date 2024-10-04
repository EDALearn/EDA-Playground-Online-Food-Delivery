---
id: updateMenuItem
version: 0.0.1
name: updateMenuItem
summary: updateMenuItem
schemaPath: request-body.json
badges:
  - content: PUT
    textColor: blue
    backgroundColor: blue
  - content: 'tag:RestaurantBackOffice'
    textColor: blue
    backgroundColor: blue
---
## Architecture
<NodeGraph />



## PUT `(/restaurants/{restaurantId}/menuItems/{name})`

### Parameters
- **restaurantId** (path) (required)
- **name** (path) (required)



### Request Body
<SchemaViewer file="request-body.json" maxHeight="500" id="request-body" />


### Responses
**200 Response**
<SchemaViewer file="response-200.json" maxHeight="500" id="response-200" />
