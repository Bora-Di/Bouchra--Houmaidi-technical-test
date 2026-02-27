
# FX Deal Data Warehouse

A Spring Boot application that accepts FX deal details, validates them, and persists them into a relational database.  
This project was developed as part of the **Java Developer Technical Assignment** for ProgressSoft Corporation.

---

## 📌 Problem Statement

The system is designed to import FX deals with the following requirements:

- Accept FX deal details through a REST API
- Validate request structure and data types
- Prevent duplicate deal imports
- Persist all valid deals without rollback
- Provide proper error handling, logging, testing, and documentation
- Run using a real database and Docker Compose

---

## 🧱 Tech Stack

- **Java** 21  
- **Spring Boot** 3.3.5  
- **Spring Data JPA**
- **PostgreSQL**
- **MapStruct** 1.5.5.Final
- **Bean Validation (Jakarta Validation)**
- **Springdoc OpenAPI** 2.6.0 (Swagger UI)
- **JUnit 5 & Mockito**
- **JaCoCo** 0.8.11 (code coverage)
- **Docker & Docker Compose**
- **Maven**

---

## 📥 API Specification

### Endpoint
```

POST /api/v1/deals

````

### Request Fields

| Field | Description |
|-----|------------|
| dealUniqueId | Unique identifier for the deal |
| fromCurrency | Ordering currency (ISO code) |
| toCurrency | Target currency (ISO code) |
| dealTimestamp | Deal timestamp |
| dealAmount | Deal amount in ordering currency |

### Sample Request

```json
{
  "dealUniqueId": "FX-10001",
  "fromCurrency": "USD",
  "toCurrency": "EUR",
  "dealTimestamp": "2024-01-01T10:15:30",
  "dealAmount": 1500.75
}
````

### Sample Success Response (201 CREATED)

```json
{
  "dealUniqueId": "FX-10001",
  "fromCurrency": "USD",
  "toCurrency": "EUR",
  "dealTimestamp": "2024-01-01T10:15:30",
  "dealAmount": 1500.75
}
```

---

## ✅ Validation Rules

* All required fields must be present
* Currency codes must be valid ISO codes
* Deal amount must be positive
* Deal timestamp must be valid
* Duplicate `dealUniqueId` values are rejected

---

## 🔒 Duplicate Handling

* The system ensures **idempotency**
* A deal with the same `dealUniqueId` **cannot be saved twice**
* Duplicate requests result in a controlled error response
* Already saved records are **never rolled back**

---

## ⚠️ Error Handling

A centralized exception handling mechanism returns structured error responses:

```json
{
  "code": 400,
  "timestamp": "2024-01-01T12:00:00",
  "message": "Validation failed",
  "description": "Invalid request payload",
  "errors": {
    "fromCurrency": "must not be blank"
  }
}
```

---

## 📊 Logging

* Application-level logging is enabled
* Important operations such as deal persistence and validation failures are logged
* Errors are logged with proper severity levels

---

## 🧪 Testing & Coverage

* Unit tests cover service and validation logic
* JaCoCo is configured to generate coverage reports
* Mapper classes are excluded from coverage
* Tests are executed using:

```bash
mvn test
```

Coverage reports are generated under:

```
target/site/jacoco-report
```

---

## 🐳 Running the Application (Docker)

### Prerequisites

* Docker
* Docker Compose

### Start the application

```bash
docker-compose up --build
```

### Services

* Application: `http://localhost:8081`
* PostgreSQL: `localhost:5433`

---

## 📘 API Documentation (Swagger)

Swagger UI is available at:

```
http://localhost:8081/swagger-ui.html
```

---

## 📂 Project Structure

```
src/
 ├── controller
 ├── service
 ├── repository
 ├── entity
 ├── dto
 ├── mapper
 ├── exception
```

---

## 📄 Deliverables Checklist

* ✅ Spring Boot application
* ✅ PostgreSQL database
* ✅ Docker Compose setup
* ✅ Validation & idempotency
* ✅ Proper error handling
* ✅ Logging
* ✅ Unit tests with coverage
* ✅ Swagger documentation
* ✅ Maven project
* ✅ README documentation

---

## 👩‍💻 Author

**Bouchra Houmaidi**
Java Developer 

```


