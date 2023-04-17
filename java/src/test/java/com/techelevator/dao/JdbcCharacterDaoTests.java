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
    public void retrieve_character_list_returns_correct_number_of_characters_for_date() {

        Assert.assertEquals(1, jdbcCharacterDao.getAllCharacters(USER_1.getUsername(), LocalDate.parse("2020-01-02")).size());
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
        Character character = generateCharacter(-1, "name", "race", "description", "Rogue", 2, 5, 0);

        Character newCharacter = jdbcCharacterDao.createCharacter(character);

        Assert.assertNotNull(newCharacter);

        int newId = newCharacter.getId();

        Assert.assertEquals(newId, character.getId());
    }
    //todo test flag function

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
