## Сервис для подготовки решения задачи с сайта https://www.codewars.com/
Создает папку с названем задачи,папки с названиями ЯП на которых будет решаться задача, заготовки для классов и тестов
- Release 1.2. Появился класс, который делает скриншот веб-страницы
- Release 1.3. Добавлен функционал считывания текста с картинки
- Release 1.4. Финальная версия
- Release 1.4.1. Считывание текста со скриншота заменено на считывание текста с DOM, т.к. cо скриншота текст читался не всегда корректно
- Release 1.4.2. Перевел сервис на Spring Boot
- Release 1.4.3. Разделил Creator на back и front. Изменен алгоритм запуска
- Release 1.4.4. Отработка сервиса происходит из фронта после ввода ID-задачи в input-поле и нажатия 'Enter'
- Release 1.4.5. Добавлена возможность выбирать языки программирования для решения из доступных
<br />
<br />
<img src="https://raw.githubusercontent.com/bcurran3/ChocolateyPackages/master/mylogos/deprecated.png" width="300" height="40" alt="Deprecated" />

```diff 
# 20.02.2024
# Для запуска клонировать репозиторий в свою среду разработки. Запуск происходит в классе 
#
# 07.04.2024
# Для запуска: {
#   1.Клонировать репозиторий в свою среду разработки;
#   2.mvn install
#   3.mvn spring-boot:run
#}
```
<br />
<br />
Для запуска: {
<br />
&nbsp;&nbsp;&nbsp;&nbsp;
1.Клонировать репозиторий в свою среду разработки;
<br />
&nbsp;&nbsp;&nbsp;&nbsp;
2.Папка "back": {
<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
2.1.mvn install
<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
2.2.mvn spring-boot:run
<br />
&nbsp;&nbsp;&nbsp;&nbsp;
}
<br />
}
<br />
&nbsp;&nbsp;&nbsp;&nbsp;
3.Папка "front": {
<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
3.1.npm install
<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
3.2.npm run start
<br />
&nbsp;&nbsp;&nbsp;&nbsp;
}
<br />
}
<br />
<br />
Все нюансы по использованию сервиса указаны в комментариях в коде<br />
Некоторые тесты и фрагменты заготовок(тестов, классов) нужно слегка подредактировать для использования(может нарисоваться лишняя цифра вконце строки кода - элемент DOM'a, либо закрытие кода - '}' попасть под комментарий)

