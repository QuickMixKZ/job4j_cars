CREATE TABLE IF NOT EXISTS engine(
    id SERIAL PRIMARY KEY,
    name TEXT
);

CREATE TABLE IF NOT EXISTS car(
    id SERIAL PRIMARY KEY,
    name TEXT,
    engine_id INT NOT NULL REFERENCES engine(id)
);

CREATE TABLE IF NOT EXISTS driver(
    id SERIAL PRIMARY KEY,
    name TEXT
);

CREATE TABLE IF NOT EXISTS history_owner(
    id SERIAL PRIMARY KEY,
    driver_id INT NOT NULL REFERENCES driver(id),
    car_id INT NOT NULL REFERENCES car(id)
);

CREATE TABLE IF NOT EXISTS account (
    id SERIAL PRIMARY KEY,
    login TEXT,
    name TEXT,
    password TEXT
);

create table advert (
    id SERIAL PRIMARY KEY ,
    bodyType TEXT,
    brand TEXT,
    description TEXT,
    photo bytea,
    sold BOOLEAN not null,
    author_id INT NOT NULL REFERENCES account(id)
);