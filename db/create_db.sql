-- Connect to the "chathub_database" database-
-- \c chathub_database;

-- Create the "users" table if it doesn't exist
CREATE TABLE IF NOT EXISTS users (
    id SERIAL PRIMARY KEY,
    login VARCHAR(50) NOT NULL,
    name VARCHAR(50) NOT NULL,
    surname VARCHAR(50) NOT NULL,
    age INT NOT NULL
);

-- Create the "chats" table if it doesn't exist
CREATE TABLE IF NOT EXISTS chats (
    id SERIAL PRIMARY KEY,
    user1Id INT REFERENCES users(id),
    user2Id INT REFERENCES users(id)
);

-- Create the "messages" table if it doesn't exist
CREATE TABLE IF NOT EXISTS messages (
    id SERIAL PRIMARY KEY,
    chatId INT REFERENCES chats(id),
    userId INT REFERENCES users(id),
    content TEXT NOT NULL,
    timestamp TIMESTAMPTZ DEFAULT CURRENT_TIMESTAMP
);