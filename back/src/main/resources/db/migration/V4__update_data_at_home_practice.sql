update home_practice
set info = 'Docker. Команда развертывания Postgres в Docker:\ndocker run --name <name> -p <external_port>:<interior_port> -e POSTGRES_PASSWORD=<password> -e POSTGRES_USER=<name> -e POSTGRES_DB=<db_name> -d postgres'
where id = 1;

update home_practice
set info = 'Git. Возвращение кода из предыдущего коммита:\n1. git log - список коммитов;\n2. git reset --hard <SHA-хэш> - вернёт состояние, которое было в этом коммите (процесс необратим)'
where id = 2;