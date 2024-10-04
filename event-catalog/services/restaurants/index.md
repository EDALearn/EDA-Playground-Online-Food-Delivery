---
id: restaurants
version: 0.0.1
name: ZenWave Online Food Delivery - Restaurants Module
summary: ZenWave Online Food Delivery - Restaurants Module
schemaPath: openapi.yml
specifications:
  openapiPath: openapi.yml
  asyncapiPath: asyncapi.yml
badges:
  - content: Default
    textColor: blue
    backgroundColor: blue
  - content: RestaurantBackOffice
    textColor: blue
    backgroundColor: blue
  - content: RestaurantOrders
    textColor: blue
    backgroundColor: blue
sends:
  - id: restauranteventmessage
    version: 0.0.1
  - id: kitchenorderstatusupdatedmessage
    version: 0.0.1
receives:
  - id: createRestaurant
    version: 0.0.1
  - id: listRestaurants
    version: 0.0.1
  - id: getRestaurant
    version: 0.0.1
  - id: createMenuItem
    version: 0.0.1
  - id: listMenuItems
    version: 0.0.1
  - id: updateMenuItem
    version: 0.0.1
  - id: updateKitchenOrderStatus
    version: 0.0.1
  - id: searchKitchenOrders
    version: 0.0.1
---
## Architecture diagram
<NodeGraph />
