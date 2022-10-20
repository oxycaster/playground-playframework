# Playground Play Framework

## Database

```bash
docker-compose -f docker-compose.yml up -d database
```

## Database Migration

```bash
sbt flyway/flywayMigrate
```

## Start

```bash
sbt run
```