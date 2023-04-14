BEGIN TRANSACTION;

DROP TABLE IF EXISTS users_party;
DROP TABLE IF EXISTS party;
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
	flagged_inappropriate varchar(15) DEFAULT 'not_flagged' NOT NULL,
    active boolean DEFAULT true NOT NULL,

	constraint pk_character primary key (id),
	constraint fk_character_monster foreign key (monster_id) references monster (id),
	constraint fk_character_users foreign key (user_id) references users (user_id)
);

CREATE TABLE party (
	id serial,
	character_1 int NOT NULL,
	character_2 int NOT NULL,
	character_3 int NOT NULL,
	character_4 int NOT NULL,

	CHECK (character_1 != character_2),
	CHECK (character_1 != character_3),
	CHECK (character_1 != character_4),
	CHECK (character_2 != character_3),
	CHECK (character_2 != character_4),
	CHECK (character_3 != character_4),

	constraint fk_party_character_1 foreign key (character_1) references character (id),
	constraint fk_party_character_2 foreign key (character_2) references character (id),
	constraint fk_party_character_3 foreign key (character_3) references character (id),
	constraint fk_party_character_4 foreign key (character_4) references character (id),

	PRIMARY KEY (id)
);

CREATE TABLE users_party (
	user_id int NOT NULL,
	party_id int NOT NULL,

    PRIMARY KEY (user_id, party_id),
	constraint fk_users_party_user foreign key (user_id) references users (user_id),
	constraint fk_users_party_party foreign key (party_id) references party (id)
);

CREATE UNIQUE INDEX ON party (
	greatest(character_1,character_2,character_3,character_4),
	least(character_4,character_3,character_2,character_1)
);


INSERT INTO monster (name_index, start_date, end_date) VALUES ('a', '2020-01-01', '2020-01-07'); --id = 1
INSERT INTO monster (name_index, start_date, end_date) VALUES ('b', '2020-01-08', '2020-01-14'); --id = 2

INSERT INTO users (username,password_hash,role) VALUES ('user1','user1','ROLE_USER');--id = 1
INSERT INTO users (username,password_hash,role) VALUES ('user2','user2','ROLE_USER');--id = 2
INSERT INTO users (username,password_hash,role) VALUES ('user3','user3','ROLE_USER');--id = 3
INSERT INTO users (username,password_hash,role) VALUES ('user4','user4','ROLE_USER');--id = 4
INSERT INTO users (username,password_hash,role) VALUES ('user5','user5','ROLE_USER');--id = 5
INSERT INTO users (username,password_hash,role) VALUES ('user6','user6','ROLE_USER');--id = 6
INSERT INTO users (username,password_hash,role) VALUES ('user7','user7','ROLE_USER');--id = 7
INSERT INTO users (username,password_hash,role) VALUES ('user8','user8','ROLE_USER');--id = 8

--insert four characters for monster a
INSERT INTO character (name, race, description, char_class, strength, dexterity, constitution,
 intelligence, wisdom, charisma, monster_id, user_id) VALUES ('a', 'a', 'a', 'a', 1, 1, 1, 1, 1, 1, 1, 1);--id = 1
INSERT INTO character (name, race, description, char_class, strength, dexterity, constitution,
 intelligence, wisdom, charisma, monster_id, user_id) VALUES ('b', 'b', 'b', 'b', 1, 1, 1, 1, 1, 1, 1, 2);--id = 2
INSERT INTO character (name, race, description, char_class, strength, dexterity, constitution,
 intelligence, wisdom, charisma, monster_id, user_id) VALUES ('c', 'c', 'c', 'c', 1, 1, 1, 1, 1, 1, 1, 3);--id = 3
INSERT INTO character (name, race, description, char_class, strength, dexterity, constitution,
 intelligence, wisdom, charisma, monster_id, user_id) VALUES ('d', 'd', 'd', 'd', 1, 1, 1, 1, 1, 1, 1, 4);--id = 4
INSERT INTO character (name, race, description, char_class, strength, dexterity, constitution,
  intelligence, wisdom, charisma, monster_id, user_id) VALUES ('e', 'e', 'e', 'e', 1, 1, 1, 1, 1, 1, 1, 5);--id = 5
INSERT INTO character (name, race, description, char_class, strength, dexterity, constitution,
   intelligence, wisdom, charisma, monster_id, user_id) VALUES ('f', 'f', 'f', 'f', 1, 1, 1, 1, 1, 1, 1, 6);--id = 6
INSERT INTO character (name, race, description, char_class, strength, dexterity, constitution,
  intelligence, wisdom, charisma, monster_id, user_id) VALUES ('g', 'g', 'g', 'g', 1, 1, 1, 1, 1, 1, 1, 7);--id = 7
INSERT INTO character (name, race, description, char_class, strength, dexterity, constitution,
   intelligence, wisdom, charisma, monster_id, user_id) VALUES ('h', 'h', 'h', 'h', 1, 1, 1, 1, 1, 1, 1, 8);--id = 8

INSERT INTO character (name, race, description, char_class, strength, dexterity, constitution,
 intelligence, wisdom, charisma, monster_id, user_id) VALUES ('i', 'i', 'i', 'i', 1, 1, 1, 1, 1, 1, 2, 1);--id = 9
INSERT INTO character (name, race, description, char_class, strength, dexterity, constitution,
 intelligence, wisdom, charisma, monster_id, user_id) VALUES ('j', 'j', 'j', 'j', 1, 1, 1, 1, 1, 1, 2, 2);--id = 10
INSERT INTO character (name, race, description, char_class, strength, dexterity, constitution,
 intelligence, wisdom, charisma, monster_id, user_id) VALUES ('k', 'k', 'k', 'k', 1, 1, 1, 1, 1, 1, 2, 3);--id = 11
INSERT INTO character (name, race, description, char_class, strength, dexterity, constitution,
 intelligence, wisdom, charisma, monster_id, user_id) VALUES ('l', 'l', 'l', 'l', 1, 1, 1, 1, 1, 1, 2, 4);--id = 12

INSERT INTO party (character_1, character_2, character_3, character_4) VALUES (1,2,3,4); --id = 1
INSERT INTO party (character_1, character_2, character_3, character_4) VALUES (9,10,11,12); --id = 2
INSERT INTO party (character_1, character_2, character_3, character_4) VALUES (1,2,3,5); --id = 3
INSERT INTO party (character_1, character_2, character_3, character_4) VALUES (1,2,5,7); --id = 4

INSERT INTO users_party (user_id, party_id) VALUES (1,1); --monster 1
INSERT INTO users_party (user_id, party_id) VALUES (1,2); --monster 2
INSERT INTO users_party (user_id, party_id) VALUES (2,2); --monster 2
INSERT INTO users_party (user_id, party_id) VALUES (3,1); --monster 1
INSERT INTO users_party (user_id, party_id) VALUES (4,3); --monster 1
INSERT INTO users_party (user_id, party_id) VALUES (5,4); --monster 1
INSERT INTO users_party (user_id, party_id) VALUES (6,1); --monster 1
INSERT INTO users_party (user_id, party_id) VALUES (7,1); --monster 1
INSERT INTO users_party (user_id, party_id) VALUES (8,4); --monster 1


COMMIT TRANSACTION;


