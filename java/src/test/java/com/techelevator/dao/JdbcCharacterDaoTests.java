package com.techelevator.dao;

import com.techelevator.model.Character;
import com.techelevator.model.User;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;

import java.time.LocalDate;

public class JdbcCharacterDaoTests extends BaseDaoTests{

    private JdbcCharacterDao jdbcCharacterDao;
    protected static final User USER_1 = new User(1, "user1", "user1", "ROLE_USER");
    protected static final User USER_2 = new User(2, "user2", "user2", "ROLE_USER");
    private static final User USER_3 = new User(3, "user3", "user3", "ROLE_USER");

    @Before
    public void setup(){
    JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
    jdbcCharacterDao = new JdbcCharacterDao(jdbcTemplate);
    }

    @Test
    public void retrieve_character_list (){

        Assert.assertEquals(1, jdbcCharacterDao.getAllCharacters(USER_1.getUsername(), LocalDate.parse("2020-01-02")).size());
        Assert.assertEquals(4, jdbcCharacterDao.getAllCharacters(null, LocalDate.parse("2020-01-02")).size());
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
