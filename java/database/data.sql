BEGIN TRANSACTION;

INSERT INTO users (username,password_hash,role) VALUES ('user','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER'); --id 1
INSERT INTO users (username,password_hash,role) VALUES ('admin','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN'); --id 2
INSERT INTO users (username,password_hash,role) VALUES ('mod','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_MOD'); --id 3
INSERT INTO users (username,password_hash,role) VALUES ('a','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER'); --id 4
INSERT INTO users (username,password_hash,role) VALUES ('b','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER'); --id 5
INSERT INTO users (username,password_hash,role) VALUES ('c','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER'); --id 6
INSERT INTO users (username,password_hash,role) VALUES ('d','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER'); --id 7
INSERT INTO users (username,password_hash,role) VALUES ('e','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER'); --id 8
INSERT INTO users (username,password_hash,role) VALUES ('f','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER'); --id 9

INSERT INTO monster (name_index, start_date, end_date) VALUES ('monster','2020-01-01','2020-01-07'); --id 1
INSERT INTO monster (name_index, start_date, end_date) VALUES ('monstar','2020-01-08','2020-01-14'); --id 2
INSERT INTO monster (name_index, start_date, end_date) VALUES ('aboleth','2023-04-09','2023-04-15'); --id 3
INSERT INTO monster (name_index, start_date, end_date) VALUES ('adult-black-dragon','2023-04-16','2023-04-22'); --id 4
INSERT INTO monster (name_index, start_date, end_date) VALUES ('adult-black-dragon','2023-04-02','2023-04-08'); --id 5


INSERT INTO character (name, char_class, race, description, strength, dexterity, constitution, intelligence, wisdom, charisma, monster_id, user_id)
	VALUES ('Jet', 'Fighter', 'Elf', 'Swims and fights', 18,17,15,12,13,14, 3,1); --id 1
INSERT INTO character (name, char_class, race, description, strength, dexterity, constitution, intelligence, wisdom, charisma, monster_id, user_id)
	VALUES ('Ba', 'Wizard', 'Dwarf', 'Tamed a basalisk once', 14,18,16,15,12,13, 3,2); --id 2
INSERT INTO character (name, char_class, race, description, strength, dexterity, constitution, intelligence, wisdom, charisma, monster_id, user_id)
	VALUES ('Lyfet', 'Rouge', 'Elf', 'Do not trust him', 13,14,18,16,15,12, 3,3); --id 3
INSERT INTO character (name, char_class, race, description, strength, dexterity, constitution, intelligence, wisdom, charisma, monster_id, user_id)
	VALUES ('Keen', 'Fighter', 'Dragon Born', 'Friendly but scary', 12,13,14,18,16,15, 3,4); --id 4
INSERT INTO character (name, char_class, race, description, strength, dexterity, constitution, intelligence, wisdom, charisma, monster_id, user_id)
	VALUES ('Teg', 'Fighter', 'Elf', 'Floats', 15,12,13,14,18,16, 3,5); --id 5
INSERT INTO character (name, char_class, race, description, strength, dexterity, constitution, intelligence, wisdom, charisma, monster_id, user_id)
	VALUES ('Zic', 'Fighter', 'Dwarf', 'Unicorn Blood', 16,15,12,13,14,18, 3,6); --id 6
INSERT INTO character (name, char_class, race, description, strength, dexterity, constitution, intelligence, wisdom, charisma, monster_id, user_id)
	VALUES ('Fig', 'Fighter', 'Elf', 'Loves eating', 10,10,10,10,10,10, 3,7); --id 7
INSERT INTO character (name, char_class, race, description, strength, dexterity, constitution, intelligence, wisdom, charisma, monster_id, user_id)
	VALUES ('Toblerone', 'Rogue', 'Dwarf', 'Builds machines to fight for him', 10,10,10,10,10,10, 3,8); --id 8
INSERT INTO character (name, char_class, race, description, strength, dexterity, constitution, intelligence, wisdom, charisma, monster_id, user_id)
	VALUES ('Reinhardt', 'Monk', 'Elf', 'He stuns people.', 10,10,10,10,10,10, 3,9); --id 9
	INSERT INTO character (name, char_class, race, description, strength, dexterity, constitution, intelligence, wisdom, charisma, monster_id, user_id)
	VALUES ('Kay', 'Monk', 'Human', 'She punches people.', 10,10,10,10,10,10, 5,9); --id 10
	INSERT INTO character (name, char_class, race, description, strength, dexterity, constitution, intelligence, wisdom, charisma, monster_id, user_id)
	VALUES ('Mil', 'Barbarian', 'Elf', 'He yells at people.', 10,10,10,10,10,10, 5,5); --id 11
	INSERT INTO character (name, char_class, race, description, strength, dexterity, constitution, intelligence, wisdom, charisma, monster_id, user_id)
	VALUES ('Bee', 'Fighter', 'Dwarf', 'He stabs people.', 10,10,10,10,10,10, 5,3); --id 12
	INSERT INTO character (name, char_class, race, description, strength, dexterity, constitution, intelligence, wisdom, charisma, monster_id, user_id)
	VALUES ('Al', 'Wizard', 'Dragon Born', 'He curses people.', 10,10,10,10,10,10, 5,2); --id 13
	INSERT INTO character (name, char_class, race, description, strength, dexterity, constitution, intelligence, wisdom, charisma, monster_id, user_id, flagged_inappropriate, active)
	VALUES ('Tim', 'Wizard', 'Human', 'He does magic against people.', 10,10,10,10,10,10, 3,7, 'not_flagged', true); --id 14
	INSERT INTO character (name, char_class, race, description, strength, dexterity, constitution, intelligence, wisdom, charisma, monster_id, user_id, flagged_inappropriate, active)
	VALUES ('George', 'Bard', 'Halfling', 'His music is awful.', 10,10,10,10,10,10, 3,6, 'flagged', false); --id 15
	
	
	
INSERT INTO party (character_1, character_2, character_3, character_4) VALUES (1,2,3,4); --id 1 monster 3
INSERT INTO party (character_1, character_2, character_3, character_4) VALUES (2,4,5,7); --id 2 monster 3
INSERT INTO party (character_1, character_2, character_3, character_4) VALUES (3,4,5,7); --id 3 monster 3
INSERT INTO party (character_1, character_2, character_3, character_4) VALUES (10,11,12,13); --id 4 monster 5



INSERT INTO users_party (user_id,party_id) VALUES (4,1); --monster 3
INSERT INTO users_party (user_id,party_id) VALUES (5,2); --monster 3
INSERT INTO users_party (user_id,party_id) VALUES (6,1); --monster 3
INSERT INTO users_party (user_id,party_id) VALUES (7,3); --monster 3
INSERT INTO users_party (user_id,party_id) VALUES (8,3); --monster 3
INSERT INTO users_party (user_id,party_id) VALUES (9,1); --monster 3
INSERT INTO users_party (user_id,party_id) VALUES (1,4); --monster 5


COMMIT TRANSACTION;
