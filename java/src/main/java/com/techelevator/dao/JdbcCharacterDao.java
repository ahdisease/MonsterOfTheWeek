package com.techelevator.dao;

import com.techelevator.model.Character;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.security.Principal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcCharacterDao implements CharacterDao{

    private JdbcTemplate jdbcTemplate;

    public JdbcCharacterDao (JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate =  jdbcTemplate;
    }


    @Override
    public List<Character> getAllCharacters(String username, LocalDate date) {
        List<Character> characters = new ArrayList<>();
        String sql = "SELECT character.id, character.name, character.race, character.description, character.char_class, " +
                "character.strength, character.dexterity, character.constitution, character.intelligence, character.wisdom, " +
                "character.charisma, character.monster_id, character.user_id, character.flagged_inappropriate FROM character WHERE ";

        if(username != null){
            sql += "character.user_id = (SELECT user_id FROM users WHERE username = ?) AND " +
                    "character.monster_id = (SELECT id FROM monster WHERE ? BETWEEN start_date AND end_date)";
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, username, date);
            while (results.next()){
                characters.add(mapRowToCharacter(results));
            }
        } else {
            sql += "character.monster_id = (SELECT id FROM monster WHERE ? BETWEEN start_date AND end_date)";
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, date);
            while (results.next()) {
                characters.add(mapRowToCharacter(results));
            }
        }
        return characters;
    }

    @Override
    public Character getCharacterById(int id) {
        Character character = null;

        String sql = "SELECT character.id, character.name, character.race, character.description, character.char_class, " +
                "character.strength, character.dexterity, character.constitution, character.intelligence, character.wisdom, " +
                "character.charisma, character.monster_id, character.user_id, character.flagged_inappropriate FROM character WHERE character.id = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, id);

        if(results.next()){
            character = mapRowToCharacter(results);
        }
        return character;
    }

    @Override
    public Character createCharacter(Character character) {
        int[] stats = diceRollStats();
        String sql = "INSERT INTO character (name, race, description, char_class, strength, dexterity," +
                " constitution, intelligence, wisdom," +
                " charisma, monster_id, user_id) Values (?,?,?,?,?,?,?,?,?,?,?,?) RETURNING id;";

        Integer id = jdbcTemplate.queryForObject(sql, Integer.class, character.getName(), character.getRace(), character.getDescription(),
                character.getCharClass(), stats[0], stats[1], stats[2], stats[3], stats[4], stats[5], character.getMonsterId(),
                character.getUserId()
        );

        character.setId(id);

        return character;
    }

    @Override
    public boolean deleteCharacterById(int id) {
        String sql = "UPDATE character SET active = false WHERE id = ?";

        try {
            jdbcTemplate.update(sql,id);
        } catch (Exception e) {
            return false;
        }

        return true;
    }

    @Override
    public boolean flagCharacterInappropriate(int id) {
        String sql = "UPDATE character SET flagged_inappropriate = 'flagged' WHERE id = ? AND flagged_inappropriate = 'not_flagged';";

        try {
            jdbcTemplate.update(sql,id);
        } catch (Exception e) {
            return false;
        }



        return true;
    }

    private int[] diceRollStats() {
        int[] stats = new int[6];

        for(int i = 0; i < stats.length; i++) {
            int dice1=(int)(Math.random()*6+1);
            int dice2=(int)(Math.random()*6+1);
            int dice3=(int)(Math.random()*6+1);
            stats[i]= dice1 + dice2 + dice3;
        }

        return stats;
    }


    private Character mapRowToCharacter(SqlRowSet result){
        Character character = new Character();
        //check if character is inactive
        //boolean active =



        character.setId(result.getInt("id"));
        character.setName(result.getString("name"));
        character.setRace(result.getString("race"));
        character.setDescription(result.getString("description"));
        character.setCharClass(result.getString("char_class"));
        character.setStrength(result.getInt("strength"));
        character.setDexterity(result.getInt("dexterity"));
        character.setConstitution(result.getInt("constitution"));
        character.setIntelligence(result.getInt("intelligence"));
        character.setWisdom(result.getInt("wisdom"));
        character.setCharisma(result.getInt("charisma"));
        character.setMonsterId(result.getInt("monster_id"));
        character.setUserId(result.getInt("user_id"));
        character.setFlaggedInappropriate(result.getString("flagged_inappropriate"));
        return character;

    }





}
