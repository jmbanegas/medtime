CREATE TABLE IF NOT EXISTS customer(
    id SERIAL,
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    phone VARCHAR(255),
    address VARCHAR(255),
    age VARCHAR(25),
    PRIMARY KEY(id)
);