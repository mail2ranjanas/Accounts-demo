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


# Build Backend (SpringBoot Java)
Maven Build : Navigate to the root folder where pom.xml is present 
mvn clean install


# Start the API service
java -jar ./target/app-1.0.0.jar


# Accessing Service

Component Service  | URL
------------- | -------------
API Service (GET Accounts)  | http://localhost:8080/accounts/user01/
API Service (GET Transaction History) | http://localhost:8080/accountHistory/1112111 | Where account can be any valid account
Swagger UI   | http://localhost:8080/swagger-ui.html#/Accounts
Database  | http://localhost:8080/h2-console/login.do | user name=sa and no password
API Doc  | http://localhost:8080/v2/api-docs

# Unit Testing

Run AccountsControllerUnitTests as a test  

# TODO

Define spring security for Authantication/Authorisation
Define dedicated service layer - In the current design, Repository (DAO)s are injected to controller (API)
Define Frontend

.
├── HELP.md
├── README.md
├── mvnw
├── mvnw.cmd
├── pom.xml
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
│   │       └── schema.sql
│   └── test
│       └── java
│           └── com
│               └── account
│                   ├── AccountApplicationTests.java
│                   └── AccountsControllerUnitTests.java
