create table if not exists work (
   id serial primary key,
   publication_date date not null,
   info text not null
);

insert into work (publication_date, info)
values
    (now(), 'Если при клонировании репозитория возникает "...SSL authentication failed...":\ngit config --global http.sslVerify false'),
    (now(), 'SQL. Rollback - откатывает текущую транзакцию. Использовать при ошибке: "Current transaction is aborted, commands ignored until end of transaction block"'),
    (now(), 'React. forwardRef() - служебная функция в React. Предоставляет дочерний компонент DOM родительскому с помощью ссылки. Актуально при работе с входными данными или, когда компоненты должны реагировать на действия пользователей'),
    (now(), 'React. useImperativeHandle - перехватчик React, который позволяет родительскому компоненту получить доступ к функциям и атрибутам экземпляра дочернего компонента. Пример использования:\n-запуск анимации;\n-сброс состояния'),
    (now(), 'ctrl + shift + u - привести строку к нижнему регистру');