CREATE TYPE UserRole AS ENUM ('MANAGER', 'USER');
CREATE TABLE users (
                       id BIGINT SERIAL PRIMARY KEY,
                       username VARCHAR(255) NOT NULL UNIQUE,
                       password VARCHAR(255) NOT NULL,
                       last_name VARCHAR(255),
                       first_name VARCHAR(255),
                       email VARCHAR(255) NOT NULL UNIQUE,
                       role UserType NOT NULL
);