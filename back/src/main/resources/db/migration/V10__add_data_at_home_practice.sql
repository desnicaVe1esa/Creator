insert into home_practice (publication_date, info)
values ('2024-05-28',
        'JavaScript. Установка библиотеки chai для тестирования js:\nnpm install mocha chai --save-dev'),
       ('2024-05-28', 'Git. Отключить автоматическое преобразование символов новой строки (CRLF):\n' ||
                      'git config --global core.autocrlf false\n' ||
                      'При установке значения "false", Git не будет автоматически изменять символы новой строки при коммитах ' ||
                      'и проверках кода. Это может быть полезно, если работа идёт на разных операционных системах, где используются различные ' ||
                      'символы новой строки\n' ||
                      'Пример использования при ошибке:\n' ||
                      'warning: in the working copy of "bla-bla-bla", LF will be replaced by CRLF the next time Git touches it')