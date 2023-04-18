package com.techelevator.dao;

import com.techelevator.model.Character;
import com.techelevator.model.CharacterImage;
import com.techelevator.model.User;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;

import java.time.LocalDate;
import java.util.List;

public class JdbcCharacterDaoTests extends BaseDaoTests {

    private JdbcCharacterDao jdbcCharacterDao;
    protected static final User USER_1 = new User(1, "user1", "user1", "ROLE_USER");
    protected static final User USER_2 = new User(2, "user2", "user2", "ROLE_USER");
    private static final User USER_3 = new User(3, "user3", "user3", "ROLE_USER");

    private final Character CHAR_1 = generateCharacter(1, "a", "a", "a", "a", 1, 1, 0);
    private final Character CHAR_2 = generateCharacter(2, "b", "b", "b", "b", 1, 2, 0);
    private final Character CHAR_3 = generateCharacter(3, "c", "c", "c", "c", 1, 3, 0);
    private final Character CHAR_4 = generateCharacter(4, "d", "d", "d", "d", 1, 4, 0);

    private final Character CHAR_9 = generateCharacter(9, "i", "i", "i", "i", 2, 1, 0);
    private final Character CHAR_10 = generateCharacter(10, "j", "j", "j", "j", 2, 2, 0);
    private final Character CHAR_11 = generateCharacter(11, "k", "k", "k", "k", 2, 3, 0);
    private final Character CHAR_12 = generateCharacter(12, "l", "l", "l", "l", 2, 4, 0);

    @Before
    public void setup() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        jdbcCharacterDao = new JdbcCharacterDao(jdbcTemplate);


    }


    @Test
    public void retrieve_character_list_returns_correct_number_of_characters_for_date_and_username() {

        Assert.assertEquals(1, jdbcCharacterDao.getAllCharacters(USER_1.getUsername(), LocalDate.parse("2020-01-02")).size());
        Assert.assertEquals(1, jdbcCharacterDao.getAllCharacters(USER_2.getUsername(), LocalDate.parse("2020-01-02")).size());
        Assert.assertEquals(0, jdbcCharacterDao.getAllCharacters(null, LocalDate.parse("2019-12-31")).size());
        Assert.assertEquals(8, jdbcCharacterDao.getAllCharacters(null, LocalDate.parse("2020-01-01")).size());
        Assert.assertEquals(8, jdbcCharacterDao.getAllCharacters(null, LocalDate.parse("2020-01-07")).size());
        Assert.assertEquals(4, jdbcCharacterDao.getAllCharacters(null, LocalDate.parse("2020-01-08")).size());
    }

    @Test
    public void retrieve_character_list_returns_correct_characters_for_date() {

        List<Character> characterList = jdbcCharacterDao.getAllCharacters(null, LocalDate.parse("2020-01-08"));
        character_details_should_match(CHAR_9, characterList.get(0));
        character_details_should_match(CHAR_10, characterList.get(1));
        character_details_should_match(CHAR_11, characterList.get(2));
        character_details_should_match(CHAR_12, characterList.get(3));
    }


    @Test
    public void get_character_by_id() {

        character_details_should_match(CHAR_1, jdbcCharacterDao.getCharacterById(1));
        character_details_should_match(CHAR_2, jdbcCharacterDao.getCharacterById(2));
        character_details_should_match(CHAR_3, jdbcCharacterDao.getCharacterById(3));
        character_details_should_match(CHAR_4, jdbcCharacterDao.getCharacterById(4));


    }

    @Test
    public void create_character() {
        //arrange
        Character character = generateCharacter(-1, "name", "race", "description", "Rogue", 2, 5, 0);
        Character character2 = generateCharacter(-1, "name", "race", "description", "Rogue", 2, 5, 0);
        CharacterImage image = new CharacterImage();
        image.setUrl("fakeurl1");
        character2.setImage(image);

        //act
        Character newCharacter = jdbcCharacterDao.createCharacter(character);
        Character newCharacter2 = jdbcCharacterDao.createCharacter(character2);

        Assert.assertNotNull(newCharacter);
        Assert.assertNotNull(newCharacter2);

        int newId = newCharacter.getId();
        int newId2 = newCharacter2.getId();

        character_details_should_match(character, newCharacter);
        Assert.assertNotNull("default image should be assigned",newCharacter.getImage());
        Assert.assertEquals("default image should have id 1",1,newCharacter.getImage().getId());
        character_details_should_match(character2, newCharacter2);
        Assert.assertEquals(character2.getImage().getId(),newCharacter2.getImage().getId());
    }
    //todo test flag function

    private void character_details_should_match(Character expected, Character actualCharacter) {
        Assert.assertEquals("Characters should match: id",expected.getId(), actualCharacter.getId());
        Assert.assertEquals("Characters should match: name",expected.getName(), actualCharacter.getName());
        Assert.assertEquals("Characters should match: class",expected.getCharClass(), actualCharacter.getCharClass());
        Assert.assertEquals("Characters should match: race",expected.getRace(), actualCharacter.getRace());
        Assert.assertEquals("Characters should match: description",expected.getDescription(), actualCharacter.getDescription());
        Assert.assertEquals("Characters should match: strength",expected.getStrength(), actualCharacter.getStrength());
        Assert.assertEquals("Characters should match: dexterity",expected.getDexterity(), actualCharacter.getDexterity());
        Assert.assertEquals("Characters should match: constitution",expected.getConstitution(), actualCharacter.getConstitution());
        Assert.assertEquals("Characters should match: intelligence",expected.getIntelligence(), actualCharacter.getIntelligence());
        Assert.assertEquals("Characters should match: wisdom",expected.getWisdom(), actualCharacter.getWisdom());
        Assert.assertEquals("Characters should match: charisma",expected.getCharisma(), actualCharacter.getCharisma());
        Assert.assertEquals("Characters should match: monster id",expected.getMonsterId(), actualCharacter.getMonsterId());
        Assert.assertEquals("Characters should match: user id",expected.getUserId(), actualCharacter.getUserId());

    }

    private Character generateCharacter(int id, String name, String race, String description, String characterClass, int monsterId, int userId, int imageId) {
        Character character = new Character();
        character.setId(id);
        character.setName(name);
        character.setRace(race);
        character.setDescription(description);
        character.setCharClass(characterClass);
        character.setStrength(1);
        character.setDexterity(1);
        character.setConstitution(1);
        character.setIntelligence(1);
        character.setWisdom(1);
        character.setCharisma(1);
        character.setMonsterId(monsterId);
        character.setUserId(userId);

        if (imageId == 0) {
            character.setImage(null);
        } else {
            CharacterImage image = new CharacterImage();
            image.setId(imageId);
            character.setImage(image);
        }



        return character;
    }
}
