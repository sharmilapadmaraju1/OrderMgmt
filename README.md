http://localhost:9099/swagger-ui.html#!/


Note: logged in user can be validated using doFilterInternal method of OncePerRequestFilter
As of now Dummy credentials are given for DB connection




List of API's

1) Adding a Item

http://localhost:9099/add/item

Sample RequestBody:

[
  {
    "itemCost": 0,
    "itemName": "string",
    "itemQuantity": 0
  }
]


2) Item Details based on ItemId

http://localhost:9099/item/12345

Sample ResponseBody

{
  "itemCost": 0,
  "itemID": 0,
  "itemName": "string",
  "itemStock": 0
}


3) Updating Item Details based on ItemId

http://localhost:9099/update/item/12345

Sample RequestBody

{
  "itemCost": 0,
  "itemName": "string",
  "itemQuantity": 0
}


4) Deleting Item based on ItemId

http://localhost:9099/delete/item/12345



5) Listing all Items

http://localhost:9099/all/items

Sample ResponseBody

[
  {
    "itemCost": 0,
    "itemID": 0,
    "itemName": "string",
    "itemStock": 0
  }
]



6) Get All Orders


[
  {
    "address": {
      "addressId": 0,
      "addressLine1": "string",
      "addressLine2": "string",
      "mobileNumber": "string",
      "pincode": "string",
      "userId": "string"
    },
    "noOfItems": 0,
    "orderCost": 0,
    "orderId": 0,
    "orderedDate": "2020-05-01T12:09:55.659Z",
    "userId": "string"
  }
]




7) Single and bulk orderig

http://localhost:9099/get/ordering

Sample RequestBody

[
  {
    "emailId": "string",
    "itemsList": [
      {
        "itemName": "string",
        "quantity": 0
      }
    ]
  }
]