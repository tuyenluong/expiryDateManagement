```shell
docker pull postgres:14.17-bookworm
```

```shell
docker run --name postgres-db --env-file .env -p 5432:5432 -d postgres:14.17-bookworm
```

```shell
docker exec -it postgres-db psql -U postgres -c "CREATE DATABASE expiry_db;"
```

```shell
docker exec -it postgres-db psql -U postgres
```

```shell
\c expiry_db
```

| Command        | What it does                         |
|----------------|--------------------------------------|
| `\l`           | List all databases                   |
| `\c dbname`    | Connect to a database                |
| `\dt`          | List all tables in the current DB    |
| `\d table_name`| Describe a table                     |
| `\q`           | Quit psql                            |
