FX Deals Management System ⚡

Author: Bouchra Houmaidi

A modern, high-performance system to manage and persist Foreign Exchange (FX) deals with robust validation, error handling, and duplicate prevention. This project ensures FX deal data integrity while providing a clean, scalable API for importing and querying deals.










📌 Table of Contents

Project Overview

Features

Tech Stack

Setup & Installation

API Guide

Project Structure

Project Overview

This FX Deals Management System allows teams to securely import and persist FX deals. Each deal goes through a strict validation pipeline to ensure:

Unique ID enforcement

Correct currency codes

Proper timestamps

Positive amounts

Duplicate deals are automatically rejected, and the system logs every operation for traceability.

Features

✅ Unique deal validation

✅ Currency and timestamp checks

✅ Positive amount enforcement

🚫 Duplicate deal detection & rejection

💾 Persistent storage with no rollback policy

📝 Detailed logging for auditing purposes

🔄 Comprehensive error responses for API clients

Tech Stack
Core

Java 21 – modern language features & performance

Spring Boot 3.3.5– dependency injection & REST APIs

PostgreSQL 16 – reliable relational database

Development

Maven – project build & dependency management

JUnit 5 – unit testing

Mockito & AssertJ – mocking & fluent assertions

SLF4J & Logback – logging

Deployment

Docker & Docker Compose – containerized application for easy setup

Setup & Installation
Prerequisites

Java 21 JDK

Maven 3.8+

Docker & Docker Compose

Steps

Clone the repository

git clone https://github.com/Bora-Di/Bouchra--Houmaidi-technical-test.git
cd progres-soft-technical-test

Start the application with Docker

make up

Stop containers

make down

Run tests

make test

Clean project artifacts

make clean
API Guide
Import a Deal

Endpoint:

POST /api/v1/deals
Content-Type: application/json

Request Example:

{
  "id": "DR123456",
  "fromCurrency": "USD",
  "toCurrency": "EUR",
  "timestamp": "2024-01-01T10:00:00Z",
  "amount": 1000000.00
}

Response Example:

{
  "id": "DR123456",
  "fromCurrency": "USD",
  "toCurrency": "EUR",
  "timestamp": "2024-01-01T10:00:00Z",
  "amount": 1000000.00
}

Error Response Example (Duplicate ID):

{
  "code": 409,
  "timestamp": "2026-02-27T12:00:00",
  "message": "DuplicateDealIdException",
  "description": "uri=/api/v1/deals",
  "errors": "Deal ID already exists"
}
Project Structure
technicalTest/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/progressoft/technicaltest/
│   │   │       ├── dto/          # Request & Response DTOs
│   │   │       ├── entity/       # JPA entities
│   │   │       ├── repository/   # Spring Data JPA repos
│   │   │       ├── service/      # Business logic layer
│   │   │       ├── mapper/       # MapStruct mappers
│   │   │       └── web/          # Controllers & exception handlers
│   │   └── resources/            # application.properties & configs
│   └── test/                      # Unit & integration tests
├── Dockerfile
├── docker-compose.yml
└── Makefile
Author

Bouchra Houmaidi – Full-stack Developer
Passionate about building clean, scalable, and well-tested backend systems.