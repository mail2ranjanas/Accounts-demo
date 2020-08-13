# Accounts Services

Spring Boot Java Backend REST service to simulate Banking accounts.

This application demonstrates REST service to load bank accounts and respective transaction history.

Technology Stack

Component Service  | Technology
------------- | -------------
API Service  | SpringBoot 2.3.2.RELEASE
Java  | Java 11 (compatible above 8)
REST Documentation   | Swagger UI
Database  | H2 In-memory database
Persistence  | JPA
Build  | Maven
Unit Test  | JUnit, Mockito
Java  | Java 11 (compatible above 8)


├── src
│   ├── main
│   │   ├── java
│   │   │   └── com
│   │   │       └── account
│   │   │           ├── AccountApplication.java
│   │   │           ├── api
│   │   │           │   └── AccountController.java
│   │   │           ├── exception
│   │   │           │   ├── AccountExceptionHandler.java
│   │   │           │   ├── AccountNotFoundException.java
│   │   │           │   ├── ExceptionResponse.java
│   │   │           │   └── TransactionNotFoundException.java
│   │   │           ├── model
│   │   │           │   ├── Account.java
│   │   │           │   ├── Transactions.java
│   │   │           │   └── User.java
│   │   │           ├── repo
│   │   │           │   ├── AccountRepo.java
│   │   │           │   └── TransactionRepo.java
│   │   │           ├── response
│   │   │           │   ├── AccountResponse.java
│   │   │           │   ├── PageResponse.java
│   │   │           │   └── TransactionResponse.java
│   │   │           └── swagger
│   │   │               └── SwaggerConfig.java
│   │   └── resources
│   │       ├── application.properties
│   │       ├── data.sql
│   │       ├── schema.sql
│   │       ├── static
│   │       └── templates
│   └── test
│       └── java
│           └── com
│               └── account
│                   ├── AccountApplicationTests.java
│                   └── AccountsControllerUnitTests.java

