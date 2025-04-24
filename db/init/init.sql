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
    age BIGINT,
    CONSTRAINT fk_person FOREIGN KEY (person_id) REFERENCES person (id)
);

INSERT INTO person (full_name, year_of_birth)
VALUES ('Иванов Иван Иванович', 1970),
       ('Петров Петр Петрович', 1960),
       ('Алексеев Алексей Алексеевич', 1989),
       ('Познер Владимир Владимирович', 1944),
       ('Федоров Мирон Янович', 1985);

INSERT INTO book (person_id, title, author, age)
VALUES (2, 'Над пропастью во ржи', 'Джером Сэлинджер', 1951),
       (5, 'День опричника', 'Владимир Сорокин', 2006),
       (5, 'Тайные виды на гору Фудзи', 'Владимир Пелевин', 2018),
       (null, 'Философия Java', 'Брюс Эккель', 2018),
       (null, 'Психопатология обыденной жизни', 'Фрейд Зигмунд', 1904),
       (null, 'Игра в бисер', 'Герман Гессе', 1943),
       (null, 'Бытие и время', 'Мартин Хайдеггер', 1927);
