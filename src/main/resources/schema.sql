CREATE TABLE products(
    id INTEGER PRIMARY KEY,
    upc14 BIGINT NOT NULL,
    upc12 BIGINT NOT NULL,
    brand VARCHAR(100) NOT NULL,
    name VARCHAR(1000) NOT NULL
);