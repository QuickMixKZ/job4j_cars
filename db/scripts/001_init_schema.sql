CREATE TABLE IF NOT EXISTS engine(
    id SERIAL PRIMARY KEY,
    name TEXT
);

CREATE TABLE IF NOT EXISTS car_body_type (
    id SERIAL PRIMARY KEY,
    name TEXT
);

CREATE TABLE IF NOT EXISTS car_brand (
    id SERIAL PRIMARY KEY,
    name TEXT
);

CREATE TABLE IF NOT EXISTS car(
    id SERIAL PRIMARY KEY,
    name TEXT,
    engine_id INT NOT NULL REFERENCES engine(id),
    body_type_id INT NOT NULL REFERENCES car_body_type(id),
    brand_id INT NOT NULL REFERENCES car_brand(id)
);

CREATE TABLE IF NOT EXISTS person(
    id SERIAL PRIMARY KEY,
    login VARCHAR UNIQUE,
    name TEXT,
    password TEXT
);

CREATE TABLE IF NOT EXISTS history_owner(
    id SERIAL PRIMARY KEY,
    driver_id INT NOT NULL REFERENCES person(id),
    car_id INT NOT NULL REFERENCES car(id)
);

create table advert (
    id SERIAL PRIMARY KEY ,
    description TEXT,
    photo bytea,
    sold BOOLEAN not null,
    author_id INT NOT NULL REFERENCES person(id),
    car_id INT REFERENCES car(id)
);