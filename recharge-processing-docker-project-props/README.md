# Recharge + Processing Microservices (Docker)

This project includes:

- Config Server
- Eureka Server
- API Gateway
- Recharge Service
- Processing Service
- PostgreSQL
- RabbitMQ

Public endpoints through the gateway:

1. `POST /api/recharges`
2. `GET /api/recharges/{id}`
3. `GET /api/processings`

Internal sync endpoint used only between services:

- `GET /internal/processor-check`

## Tech stack

- Java 17
- Spring Boot 3.5.11
- Spring Cloud 2025.0.0
- PostgreSQL 17
- RabbitMQ 4 management image
- Docker Compose

## Run order

Build jars first:

```bash
cd config-server && mvn clean package -DskipTests
cd ../eureka-server && mvn clean package -DskipTests
cd ../api-gateway && mvn clean package -DskipTests
cd ../recharge-service && mvn clean package -DskipTests
cd ../processing-service && mvn clean package -DskipTests
cd ..
```

Start all containers:

```bash
docker compose up --build
```

## Access

- Config Server: `http://localhost:8888`
- Eureka Dashboard: `http://localhost:8761`
- API Gateway: `http://localhost:9090`
- RabbitMQ Dashboard: `http://localhost:15672`  
  username: `guest`  
  password: `guest`

## Test APIs

### 1) Create recharge

```bash
curl -X POST http://localhost:9090/api/recharges   -H "Content-Type: application/json"   -d '{"mobileNumber":"9876543210","amount":199.0}'
```

### 2) Get recharge by id

```bash
curl http://localhost:9090/api/recharges/1
```

### 3) Get processing records

```bash
curl http://localhost:9090/api/processings
```
