DROP TABLE IF EXISTS person CASCADE;
DROP TABLE IF EXISTS book CASCADE;

CREATE TABLE IF NOT EXISTS person
(
    id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    full_name VARCHAR (255) NOT NULL,
    year_of_birth BIGINT
);

CREATE TABLE IF NOT EXISTS book
(
    id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    person_id BIGINT,
    title VARCHAR (255),
    author VARCHAR (255),
    age BIGINT
);

INSERT INTO person (full_name, year_of_birth)
VALUES ('Иванов Иван Иванович', 1970),
       ('Петров Петр Петрович', 1960),
       ('Алексеев Алексей Алексеевич', 1989),
       ('Test', 1900);

INSERT INTO book (title, author, age)
VALUES ('Над пропастью во ржи', 'Джером Сэлинджер', 1951),
       ('День опричника', 'Владимир Сорокин', 2006),
       ('Тайные виды на гору Фудзи', 'Владимир Пелевин', 2018),
       ('Философия Java', 'Брюс Эккель', 2018),
       ('Бытие и время', 'Мартин Хайдеггер', 1927);
