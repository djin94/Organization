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
INSERT INTO positions (title) VALUES ('junior developer');
INSERT INTO positions (title) VALUES ('middle developer');
INSERT INTO positions (title) VALUES ('senior developer');

INSERT INTO groups (title) VALUES ('group a');
INSERT INTO groups (title) VALUES ('group b');
INSERT INTO groups (title) VALUES ('group c');

INSERT INTO languages (title) VALUES ('java');
INSERT INTO languages (title) VALUES ('c#');
INSERT INTO languages (title) VALUES ('php');

INSERT INTO users (username, position_id, group_id) VALUES ('user 1', 1, 1);
INSERT INTO users (username, position_id, group_id) VALUES ('user 2', 2, 2);
INSERT INTO users (username, position_id, group_id) VALUES ('user 3', 3, 3);
INSERT INTO users (username, position_id, group_id) VALUES ('user 4', 2, 2);
INSERT INTO users (username, position_id, group_id) VALUES ('user 5', 3, 3);

INSERT INTO language_user (user_id, language_id) VALUES (1,1);
INSERT INTO language_user (user_id, language_id) VALUES (2,1);
INSERT INTO language_user (user_id, language_id) VALUES (3,1);
INSERT INTO language_user (user_id, language_id) VALUES (3,3);
INSERT INTO language_user (user_id, language_id) VALUES (4,2);
INSERT INTO language_user (user_id, language_id) VALUES (5,2);
INSERT INTO language_user (user_id, language_id) VALUES (4,1);
INSERT INTO language_user (user_id, language_id) VALUES (5,3);