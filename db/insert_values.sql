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

INSERT INTO chats (user1_id, user2_id) VALUES
    (5, 6),
    (6, 7),
    (7, 8),
    (5, 8),
    (6, 8),
    (5, 7);


-- Insert sample messages
INSERT INTO messages (chat_id, user_id, content, timestamp) VALUES
    (19, 5, 'Hello, how are you?', '2023-01-01 12:00:00'),
    (19, 6, 'Hi there! I am doing well.', '2023-01-01 12:05:00'),
    (20, 6, 'Hey, can you help me with something?', '2023-01-02 15:30:00'),
    (20, 7, 'Sure, what do you need help with?', '2023-01-02 15:45:00'),
    (20, 6, 'I have a question too. Can we meet and discuss?', '2023-01-03 10:00:00');
