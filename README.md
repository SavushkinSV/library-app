# Тестовое задание

Текст задания находится в файле [TASK.md](TASK.md).

Перед запуском приложения необходимо запустить докер контейнер с СУБД **PostgreSQL**. Настройки для запуска контейнера расположены в файле [.env](.env). \
Контейнер запускается с помощью команды `docker-compose up -d --build --force-recreate`. Остановка контейнера выполняется с помощью команды `docker-compose down`.

Необходимые настройки приложения для соединения с **PostgreSQL** находятся в файле [application.properties](src/main/resources/application.properties).

Приложение работает по адресам:

- http://localhost:8080/people
- http://localhost:8080/books