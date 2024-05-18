insert into home_practice (publication_date, info)
values (
    now(), 'Возвращение кода из предыдущего коммита:' ||
           '1. git log - список коммитов;' ||
           '2. git reset --hard <SHA-хэш> - вернёт состояние, которое было в этом коммите (процесс необратим)'
);