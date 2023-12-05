-- Connect to the "chathub_database" database
--\c chathub_database;

-- Delete all records from the "users" table
DELETE FROM users;

-- Insert data into the "users" table
INSERT INTO users (login, name, surname, age)
VALUES ('kkluczyn', 'Krzysztof', 'Kluczynski', 21);

INSERT INTO users (login, name, surname, age)
VALUES ('jfilipec', 'Jan', 'Filipecki', 21);

INSERT INTO users (login, name, surname, age)
VALUES ('kmurygin', 'Kacper', 'Murygin', 21);

INSERT INTO users (login, name, surname, age)
VALUES ('sjankow1', 'Szymon', 'Jankowski', 21);

