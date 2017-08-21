create table users (
	id serial primary key,
	username VARCHAR(255),
    position_id INT,
    group_id INT
);
CREATE TABLE positions (
    id serial primary key,
    title VARCHAR(255)
);

CREATE TABLE groups (
    id serial primary key,
    title VARCHAR(255)
);

CREATE TABLE languages (
    id serial primary key,
    title VARCHAR(255)
);

CREATE TABLE language_user (
    user_id INT,
    language_id INT
);