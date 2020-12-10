CREATE DATABASE transtech_db;
\connect transtech_db;
CREATE SCHEMA transtech;
CREATE TABLE transtech.TRUCKS (
    id SERIAL PRIMARY KEY,
    name TEXT,
    price BIGINT,
    comment TEXT
);
COMMENT ON TABLE transtech.TRUCKS IS
'TRUCKS table created.';