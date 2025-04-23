DROP TABLE IF EXISTS person CASCADE;

CREATE TABLE IF NOT EXISTS person
(
    id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    full_name VARCHAR (255) NOT NULL,
    year_of_birth BIGINT
);

INSERT INTO person (full_name, year_of_birth)
VALUES ('Иванов Иван Иванович', 1970),
       ('Петров Петр Петрович', 1960),
       ('Алексеев Алексей Алексеевич', 1989),
       ('Test', 1900);
