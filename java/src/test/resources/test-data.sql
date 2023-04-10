BEGIN TRANSACTION;

DROP TABLE IF EXISTS character;
DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS monster;

CREATE TABLE users (
	user_id SERIAL,
	username varchar(50) NOT NULL UNIQUE,
	password_hash varchar(200) NOT NULL,
	role varchar(50) NOT NULL,
	CONSTRAINT PK_user PRIMARY KEY (user_id)
);

CREATE TABLE monster (
	id SERIAL,
	name_index varchar(200) NOT NULL,
	start_date date NOT NULL,
	end_date date NOT NULL,

	CONSTRAINT PK_monster PRIMARY KEY (id)
);


CREATE TABLE character(
	id serial,
	name varchar(50) not null,
	char_class varchar(50) not null,
	race varchar(50) not null,
	description varchar(10000) not null,

	strength int,
	dexterity int,
	constitution int,
	intelligence int,
	wisdom int,
	charisma int,

	monster_id int not null,
	user_id int not null,

	constraint pk_character primary key (id),
	constraint fk_character_monster foreign key (monster_id) references monster (id),
	constraint fk_character_users foreign key (user_id) references users (user_id)
);

INSERT INTO monster (name_index, start_date, end_date) VALUES ('a', '2020-01-01', '2020-01-07');
INSERT INTO monster (name_index, start_date, end_date) VALUES ('b', '2020-01-08', '2020-01-14');

INSERT INTO users (username,password_hash,role) VALUES ('user1','user1','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('user2','user2','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('user3','user3','ROLE_USER');

INSERT INTO character (name, race, description, char_class, strength, dexterity, constitution,
 intelligence, wisdom, charisma, monster_id, user_id) VALUES ('b', 'c', 'd', 'e', 1, 1, 1, 1, 1, 1, 1, 1);
INSERT INTO character (name, race, description, char_class, strength, dexterity, constitution,
 intelligence, wisdom, charisma, monster_id, user_id) VALUES ('b', 'c', 'd', 'e', 1, 1, 1, 1, 1, 1, 2, 1);
INSERT INTO character (name, race, description, char_class, strength, dexterity, constitution,
  intelligence, wisdom, charisma, monster_id, user_id) VALUES ('b', 'c', 'd', 'e', 1, 1, 1, 1, 1, 1, 1, 2);
INSERT INTO character (name, race, description, char_class, strength, dexterity, constitution,
   intelligence, wisdom, charisma, monster_id, user_id) VALUES ('b', 'c', 'd', 'e', 1, 1, 1, 1, 1, 1, 2, 2);

COMMIT TRANSACTION;


