create table if not exists home_practice (
   id serial primary key,
   info varchar
);

insert into home_practice values (
    1, 'Команда развертывания Postgres в Docker: docker run --name <name> -p <external_port>:<interior_port> -e POSTGRES_PASSWORD=<password> -e POSTGRES_USER=<name> -e POSTGRES_DB=<db_name> -d postgres'
);