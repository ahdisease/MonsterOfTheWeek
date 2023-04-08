DROP TABLE IF EXISTS character;
CREATE TABLE character(
id serial,
name varchar(50) not null,
race varchar(50) not null,
description varchar(10000) not null,
char_class varchar(50) not null,


constraint pk_character primary key (id)

);

INSERT INTO character (name, race, description, char_class) VALUES ('b', 'c', 'd', 'e');
SELECT * FROM character;

SELECT character.id, character.name, character.race, character.description
FROM character
