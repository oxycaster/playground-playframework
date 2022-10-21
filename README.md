# Playground Play Framework

## Require Environment Variables

```bash
JDBC_DATABASE_USERNAME=root
JDBC_DATABASE_PASSWORD=example
JDBC_DATABASE_URL=jdbc:mysql://localhost:3306/app?user=root&password=example
```

## Database

```bash
docker-compose -f docker-compose.yml up -d database
```

## Database Migration

```bash
sbt flyway/flywayMigrate
```

## Schema Code Generate

```bash
sbt slick/slickCodegen
```

## Start

```bash
sbt run
```