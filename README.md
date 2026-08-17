# Family Cash Card API

A RESTful API built with **Java and Spring Boot** for managing family cash cards.

This project follows the Spring Academy course **Building a REST API with Spring Boot** and demonstrates REST API development, persistence, security, and testing with Spring Boot.

## Tech Stack

- Java
- Spring Boot
- Spring Web
- Spring Data JPA
- Spring Security
- H2 Database
- JUnit
- MockMvc
- Maven

## Features

- Create, retrieve, update, and delete cash cards
- Authenticate users with Spring Security
- Restrict users to accessing only their own cash cards
- Persist data using Spring Data JPA
- Support pagination and sorting
- Test API behaviour with JUnit and MockMvc

## API Endpoints

| Method   | Endpoint          | Description                       |
| -------- | ----------------- | --------------------------------- |
| `GET`    | `/cashcards/{id}` | Get a cash card                   |
| `GET`    | `/cashcards`      | Get the current user's cash cards |
| `POST`   | `/cashcards`      | Create a cash card                |
| `PUT`    | `/cashcards/{id}` | Update a cash card                |
| `DELETE` | `/cashcards/{id}` | Delete a cash card                |

## Running the Project

Clone the repository:

```bash
git clone <repository-url>
cd cash-card
```

Run the application:

```bash
./mvnw spring-boot:run
```

The API will be available at:

```text
http://localhost:8080
```

## Running Tests

```bash
./mvnw test
```

## Authentication

The API uses HTTP Basic Authentication.

Example:

```bash
curl -u username:password http://localhost:8080/cashcards
```

Authenticated users can only access cash cards that belong to them.

## Key Concepts

This project demonstrates:

- RESTful API design
- CRUD operations
- Spring MVC controllers
- Dependency injection
- Spring Data repositories
- Authentication and authorization
- Pagination and sorting
- Test-driven development
- Integration testing with MockMvc

## Future Improvements

- PostgreSQL instead of H2
- DTOs for request and response models
- Bean Validation
- Global exception handling
- JWT/OAuth 2.0 authentication
- OpenAPI/Swagger documentation
- Docker support
- Database migrations with Flyway
- Pagination for large datasets
- Structured application logging
- Monitoring and observability
- CI/CD pipeline
- Production configuration profiles

## Course

Based on the Spring Academy course:

**Building a REST API with Spring Boot**

<https://spring.academy/courses/building-a-rest-api-with-spring-boot>
