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
    private static final Character CHAR_1 = new Character();

    @Before
    public void setup(){
    JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
    jdbcCharacterDao = new JdbcCharacterDao(jdbcTemplate);
        CHAR_1.setId(1);
        CHAR_1.setName("b");
        CHAR_1.setRace("c");
        CHAR_1.setDescription("d");
        CHAR_1.setCharClass("e");
        CHAR_1.setStrength(1);
        CHAR_1.setDexterity(1);
        CHAR_1.setConstitution(1);
        CHAR_1.setIntelligence(1);
        CHAR_1.setWisdom(1);
        CHAR_1.setCharisma(1);
        CHAR_1.setMonsterId(1);
        CHAR_1.setUserId(1);

    }

    @Test
    public void retrieve_character_list (){

        Assert.assertEquals(1, jdbcCharacterDao.getAllCharacters(USER_1.getUsername(), LocalDate.parse("2020-01-02")).size());
        Assert.assertEquals(4, jdbcCharacterDao.getAllCharacters(null, LocalDate.parse("2020-01-02")).size());
    }

    @Test
    public void get_character_by_id() {

        character_details_should_match(CHAR_1, jdbcCharacterDao.getCharacterById(1));


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

    private void character_details_should_match(Character expected, Character actualCharacter) {

        Assert.assertEquals(expected.getId(), actualCharacter.getId());
        Assert.assertEquals(expected.getName(), actualCharacter.getName());
        Assert.assertEquals(expected.getCharClass(), actualCharacter.getCharClass());
        Assert.assertEquals(expected.getRace(), actualCharacter.getRace());
        Assert.assertEquals(expected.getDescription(), actualCharacter.getDescription());
        Assert.assertEquals(expected.getStrength(), actualCharacter.getStrength());
        Assert.assertEquals(expected.getDexterity(), actualCharacter.getDexterity());
        Assert.assertEquals(expected.getConstitution(), actualCharacter.getConstitution());
        Assert.assertEquals(expected.getIntelligence(), actualCharacter.getIntelligence());
        Assert.assertEquals(expected.getWisdom(), actualCharacter.getWisdom());
        Assert.assertEquals(expected.getCharisma(), actualCharacter.getCharisma());
        Assert.assertEquals(expected.getMonsterId(), actualCharacter.getMonsterId());
        Assert.assertEquals(expected.getUserId(), actualCharacter.getUserId());


    }
}
