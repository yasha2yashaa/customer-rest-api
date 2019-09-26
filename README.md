# Customer Rest API

Customer Rest API built with Spring Boot 2

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
- There is also findAll functionality included which you can use by sending GET request to http://localhost:8080/api/customers