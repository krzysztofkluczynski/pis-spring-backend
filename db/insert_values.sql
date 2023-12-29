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


-- Insert sample messages
INSERT INTO messages (sender_id, recipient_id, content, timestamp) VALUES
    (25, 27, 'Hello, how are you?', '2023-01-01 12:00:00'),
    (27, 28, 'Hi there! I am doing well.', '2023-01-01 12:05:00'),
    (28, 27, 'Hey, can you help me with something?', '2023-01-02 15:30:00'),
    (27, 28, 'Sure, what do you need help with?', '2023-01-02 15:45:00'),
    (25, 28, 'I have a question too. Can we meet and discuss?', '2023-01-03 10:00:00');
