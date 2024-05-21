create table if not exists work (
   id serial primary key,
   publication_date date not null,
   info text not null
);

insert into work (publication_date, info)
values
    ('2024-05-20', 'Если при клонировании репозитория возникает "...SSL authentication failed...":\ngit config --global http.sslVerify false'),
    ('2024-05-20', 'SQL. Rollback - откатывает текущую транзакцию.\nИспользовать при ошибке: "Current transaction is aborted, commands ignored until end of transaction block"'),
    ('2024-05-20', 'React. forwardRef() - служебная функция в React. Предоставляет дочерний компонент DOM родительскому с помощью ссылки. Актуально при работе с входными данными или, когда компоненты должны реагировать на действия пользователей'),
    ('2024-05-20', 'React. useImperativeHandle - перехватчик React, который позволяет родительскому компоненту получить доступ к функциям и атрибутам экземпляра дочернего компонента.\nПример использования:\n-запуск анимации;\n-сброс состояния'),
    ('2024-05-20', 'ctrl + shift + u - привести строку к нижнему регистру'),
    ('2024-05-20', 'Spring. Чтобы запустить проект через "run" с внешним application.properties, нужно зайти в "Edit configuration..." и добавить в "VM options":\n-Dspring.config.location=<PATH>/application.properties (Для Windows использовать "\\")');