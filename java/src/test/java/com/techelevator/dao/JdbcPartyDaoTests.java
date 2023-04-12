package com.techelevator.dao;

import com.techelevator.model.Party;
import com.techelevator.model.User;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;

import java.time.LocalDate;

public class JdbcPartyDaoTests extends BaseDaoTests {

    private JdbcPartyDao jdbcPartyDao;
    protected static final User USER_1 = new User(1, "user1", "user1", "ROLE_USER");
    protected static final User USER_2 = new User(2, "user2", "user2", "ROLE_USER");
    private static final User USER_3 = new User(3, "user3", "user3", "ROLE_USER");

    @Before
    public void setup(){
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        jdbcPartyDao = new JdbcPartyDao(jdbcTemplate);
    }

    @Test
    public void createParty_creates_new_unique_party() {
        //arrange
        Party party = new Party();
        party.setCharacterOne(5);
        party.setCharacterTwo(6);
        party.setCharacterThree(7);
        party.setCharacterFour(8);
        //act
        Party newParty = jdbcPartyDao.createParty(party,USER_1.getUsername());

        //assert
        Assert.assertEquals(2,newParty.getId());
    }

    @Test
    public void createParty_assigns_id_of_previously_created_party_if_duplicate() {
        //arrange
        Party party = fakeConstructorParty(1,2,3,4);
        //act
        Party newParty = jdbcPartyDao.createParty(party,USER_1.getUsername());

        //assert
        Assert.assertEquals(1,newParty.getId());
    }

    @Test
    public void getPartyByUsername_returns_correct_party() {
        //arrange
        Party partyOne = fakeConstructorParty(1,2,3,4);
        Party partyTwo = fakeConstructorParty(5,6,7,8);

        //act
        Party retrievedPartyOne = jdbcPartyDao.retrievePartyByUsername(USER_1.getUsername(), LocalDate.parse("2020-01-02"));
        Party retrievedPartyTwo = jdbcPartyDao.retrievePartyByUsername(USER_1.getUsername(), LocalDate.parse("2020-01-08"));
        Party retrievedPartyTwoUserTwo = jdbcPartyDao.retrievePartyByUsername(USER_2.getUsername(), LocalDate.parse("2020-01-08"));

        //assert
        Assert.assertEquals(1,retrievedPartyOne.getId());
        Assert.assertEquals(2,retrievedPartyTwo.getId());
        Assert.assertEquals(2,retrievedPartyTwoUserTwo.getId());

    }

    private Party fakeConstructorParty(int char_one,int char_two,int char_three,int char_four) {
        Party party = new Party();
        party.setCharacterOne(char_one);
        party.setCharacterTwo(char_two);
        party.setCharacterThree(char_three);
        party.setCharacterFour(char_four);

        return party;
    }

}
