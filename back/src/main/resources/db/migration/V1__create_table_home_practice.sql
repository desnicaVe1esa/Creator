create table if not exists home_practice (
   id serial primary key,
   publication_date date not null,
   info text not null
);

insert into home_practice (publication_date, info)
values (
    '2024-05-18', 'Команда развертывания Postgres в Docker:\ndocker run --name <name> -p <external_port>:<interior_port> -e POSTGRES_PASSWORD=<password> -e POSTGRES_USER=<name> -e POSTGRES_DB=<db_name> -d postgres'
);