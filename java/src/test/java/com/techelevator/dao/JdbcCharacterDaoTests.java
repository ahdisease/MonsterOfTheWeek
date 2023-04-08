package com.techelevator.dao;

import com.techelevator.model.Character;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;

public class JdbcCharacterDaoTests extends BaseDaoTests{

    private JdbcCharacterDao jdbcCharacterDao;

    @Before
    public void setup(){
    JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
    jdbcCharacterDao = new JdbcCharacterDao(jdbcTemplate);
    }

    @Test
    public void retrieve_character_list (){

        Assert.assertEquals(2, jdbcCharacterDao.getAllCharacters().size());
    }

    @Test
    public void create_character() {
        Character character = new Character();
        character.setId(-1);
        character.setName("name");
        character.setRace("race");
        character.setDescription("description");
        character.setCharClass("Rogue");
        character.setStrength(1);
        character.setDexterity(1);
        character.setConstitution(1);
        character.setIntelligence(1);
        character.setWisdom(1);
        character.setCharisma(30);
        character.setMonsterId(1);
        character.setUserId(1);

        Character newCharacter = jdbcCharacterDao.createCharacter(character);

        Assert.assertNotNull(newCharacter);

        int newId = newCharacter.getId();

        Assert.assertEquals(newId, character.getId());
    }

}
