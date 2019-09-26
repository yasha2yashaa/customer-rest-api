# Customer Rest Api

Customer Rest Api built with spring boot

### How to use

- To post new customer send POST request to http://localhost:8080/api/customers with json body like in example below:

```
{
    "name": "yourNewCustomerName",
    "address": {
        "city": "yourNewCustomerCityName",
        "street": "yourNewCustomerStreetName",
        "zipCode": "YourNewCustomerZipCode"
    }
}
```

- To get customer, send request to http://localhost:8080/api/customers/id where "id" is id of the customer you want to get
- There is also included findAll functionality which you can use by sending GET request to http://localhost:8080/api/customers