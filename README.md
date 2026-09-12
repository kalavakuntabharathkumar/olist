# Olist E-Commerce Order Management System

Spring Boot microservices demonstrating order management, catalog APIs, JWT authentication, PostgreSQL, Docker Compose, JPA optimization, and automated tests.

## Services
- `orders-service` — order history, order lookup, customer orders, protected write endpoints.
- `catalog-service` — product/category catalog endpoints.
- PostgreSQL — normalized persistence shared by the demo services.

## Run
Requirements: Java 17, Maven 3.9+, Docker Desktop.

```bash
docker compose up --build
```

Then:
- Orders: http://localhost:8081
- Catalog: http://localhost:8082
- PostgreSQL: localhost:5432

Default demo credentials:
- admin / admin123
- analyst / analyst123

The project includes a small generated seed set for local development. The public Olist dataset is not redistributed in this repository; place your legally obtained CSV under `data/` and run the import command described in `docs/olist-import.md`.

## Test
```bash
mvn test
```

## Notes
This is a portfolio implementation. Benchmark figures in a resume should only be claimed after reproducing the benchmark with the included load-test procedure and your own Olist data.
