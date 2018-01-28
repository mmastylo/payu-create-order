# PayU Order Create

This project enables order creation in PayU system.

## Getting Started


### Installing

Install [Maven](https://maven.apache.org/) and [Lombok](https://projectlombok.org/) first.

### PayU API

Check [PayU API](http://developers.payu.com/pl/restapi.html)

### Project API

There is API endpoint POST /order/create. It needs Authorization HTTP header from PayU and order parameters in request body.


## Validation

All input parameters validation requirement is provided by Lombok based on PayU API.


## Running & Tests

### Running

Project is a Spring Boot Application so it can be run with following command:

```
mvn spring-boot:run
```

### Tests

Tests can be run with following command:

```
mvn test
```


## Used libraries

* Spring Boot
* Spring Cloud
* Hystrix
* Feign
* Lombok
* JUnit
* WireMock