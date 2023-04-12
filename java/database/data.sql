BEGIN TRANSACTION;

INSERT INTO users (username,password_hash,role) VALUES ('user','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('admin','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN');

INSERT INTO monster (name_index, start_date, end_date) VALUES ('monster','2020-01-01','2020-01-07');
INSERT INTO monster (name_index, start_date, end_date) VALUES ('monstar','2020-01-08','2020-01-14');
INSERT INTO monster (name_index, start_date, end_date) VALUES ('aboleth','2023-04-09','2023-04-15');

INSERT INTO character (name, char_class, race, description, strength, dexterity, constitution, intelligence, wisdom, charisma, monster_id, user_id)
	VALUES ('Jet', 'Fighter', 'Elf', 'Swims and fights', 10,10,10,10,10,10, 1,1);
INSERT INTO character (name, char_class, race, description, strength, dexterity, constitution, intelligence, wisdom, charisma, monster_id, user_id)
	VALUES ('Ba', 'Wizard', 'Dwarf', 'Tamed a basalisk once', 10,10,10,10,10,10, 1,2);
INSERT INTO character (name, char_class, race, description, strength, dexterity, constitution, intelligence, wisdom, charisma, monster_id, user_id)
	VALUES ('Lyfet', 'Rouge', 'Elf', 'Do not trust him', 10,10,10,10,10,10, 1,1);
INSERT INTO character (name, char_class, race, description, strength, dexterity, constitution, intelligence, wisdom, charisma, monster_id, user_id)
	VALUES ('Keen', 'Fighter', 'Dragon Born', 'Friendly but scary', 10,10,10,10,10,10, 1,2);
INSERT INTO character (name, char_class, race, description, strength, dexterity, constitution, intelligence, wisdom, charisma, monster_id, user_id)
	VALUES ('Teg', 'Fighter', 'Elf', 'Floats', 10,10,10,10,10,10, 1,2);
INSERT INTO character (name, char_class, race, description, strength, dexterity, constitution, intelligence, wisdom, charisma, monster_id, user_id)
	VALUES ('Zic', 'Fighter', 'Dwarf', 'Unicorn Blood', 10,10,10,10,10,10, 1,1);
INSERT INTO character (name, char_class, race, description, strength, dexterity, constitution, intelligence, wisdom, charisma, monster_id, user_id)
	VALUES ('Fig', 'Fighter', 'Elf', 'Loves eating', 10,10,10,10,10,10, 1,2);
	
INSERT INTO character (name, char_class, race, description, strength, dexterity, constitution, intelligence, wisdom, charisma, monster_id, user_id)
	VALUES ('Toblerone', 'Rogue', 'Dwarf', 'Builds machines to fight for him', 10,10,10,10,10,10, 2,1);
INSERT INTO character (name, char_class, race, description, strength, dexterity, constitution, intelligence, wisdom, charisma, monster_id, user_id)
	VALUES ('Reinhardt', 'Monk', 'Elf', 'He stuns people.', 10,10,10,10,10,10, 2,2);
	
INSERT INTO party (character_1, character_2, character_3, character_4) VALUES (1,2,3,4);



COMMIT TRANSACTION;
