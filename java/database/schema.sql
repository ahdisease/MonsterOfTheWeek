BEGIN TRANSACTION;

DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS character;

CREATE TABLE users (
	user_id SERIAL,
	username varchar(50) NOT NULL UNIQUE,
	password_hash varchar(200) NOT NULL,
	role varchar(50) NOT NULL,
	CONSTRAINT PK_user PRIMARY KEY (user_id)
);


CREATE TABLE character(
id serial,
name varchar(50) not null,
race varchar(50) not null,
description varchar(10000) not null,
char_class varchar(50) not null,


constraint pk_character primary key (id)

);

COMMIT TRANSACTION;
