select c1.name, c2.name, c3.name, c4.name from party
	join character as c1 on character_1 = c1.id
	join character as c2 on character_2 = c2.id
	join character as c3 on character_3 = c3.id
	join character as c4 on character_4 = c4.id
;
select * from character;
select * from party;
select * from users_party;


--counts party id with the highest votes for all parties ever
select party_id, count(user_id) as votes 
from users_party 
group by party_id 
order by votes desc 
limit 1;

-- returns party id with highest votes for a given monster
select party_id, count(users_party.user_id) as votes 
from users_party 
join party on users_party.party_id = party.id
join character on character_1 = character.id
where character.monster_id = 3	--replace with ? 
group by party_id 
order by votes desc 
limit 1;

-- returns number of votes for a given monster
select count(users_party.user_id) as votes 
from users_party 
join party on users_party.party_id = party.id
join character on character_1 = character.id
where character.monster_id = 3	--replace with ? 
