package com.techelevator.dao;

import com.techelevator.model.Character;
import com.techelevator.model.CharacterImage;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.server.ResponseStatusException;

import java.security.Principal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;




@Component
public class JdbcCharacterDao implements CharacterDao{

    private JdbcTemplate jdbcTemplate;
    private CharacterImageDao imageDao;

    private final int DEFALUT_IMAGE_ID = 1;
    private final String DEFAULT_IMAGE_URL = "https://res.cloudinary.com/c19-lima-monster-of-the-week/image/upload/v1681825649/Default_mypuwg.jpg";

    public JdbcCharacterDao (JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate =  jdbcTemplate;
        imageDao = new JdbcCharacterImageDao(jdbcTemplate);
    }


    @Override
    public List<Character> getAllCharacters(String username, LocalDate date) {
        List<Character> characters = new ArrayList<>();
        String sql = "SELECT character.id, character.name, character.race, character.description, character.char_class, " +
                "character.strength, character.dexterity, character.constitution, character.intelligence, character.wisdom, " +
                "character.charisma, character.monster_id, character.user_id, character.flagged_inappropriate, character.active, character.image_id FROM character WHERE ";

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
                "character.charisma, character.monster_id, character.user_id, character.flagged_inappropriate, character.active, character.image_id FROM character WHERE character.id = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, id);

        if(results.next()){
            character = mapRowToCharacter(results);
        }
        return character;
    }

    @Override
    public Character createCharacter(Character character) {
        //calculate character stats randomly between 3 and 18
        int[] stats = diceRollStats();

        //prepare sql insertion for character
        String sql = "INSERT INTO character (name, race, description, char_class, strength, dexterity," +
                " constitution, intelligence, wisdom," +
                " charisma, monster_id, user_id, image_id) Values (?,?,?,?,?,?,?,?,?,?,?,?,?) RETURNING id;";

        if(character.getImage() != null) {
            //Add default if url is blank
            if (character.getImage().getUrl().equals("")) {
                character.getImage().setUrl(DEFAULT_IMAGE_URL);
            }

            //add image to database
            CharacterImage savedImage = imageDao.addImage(character.getImage().getUrl());

            //add character to database
            Integer id = jdbcTemplate.queryForObject(sql, Integer.class, character.getName(), character.getRace(), character.getDescription(),
                    character.getCharClass(), stats[0], stats[1], stats[2], stats[3], stats[4], stats[5], character.getMonsterId(),
                    character.getUserId(), savedImage.getId()
            );
            character.setId(id);
        } else {
            //add default image to character
            CharacterImage defaultImage = imageDao.getImageById(DEFALUT_IMAGE_ID);
            character.setImage(defaultImage);

            //add character to database
            Integer id = jdbcTemplate.queryForObject(sql, Integer.class, character.getName(), character.getRace(), character.getDescription(),
                    character.getCharClass(), stats[0], stats[1], stats[2], stats[3], stats[4], stats[5], character.getMonsterId(),
                    character.getUserId(), DEFALUT_IMAGE_ID
            );
            character.setId(id);
        }

        return character;
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
        boolean active = result.getBoolean("active");
        if (!active) {
            character.setId(result.getInt("id"));
            character.setName("Inactive Character");
            character.setActive(false);
            return character;
        }

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
        character.setActive(true);
        Integer imageId = result.getInt("image_id");
        if (imageId != null) {
            character.setImage(imageDao.getImageById(imageId));
        }

        return character;

    }





}
