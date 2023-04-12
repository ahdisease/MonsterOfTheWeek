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
        Party party = new Party();
        party.setCharacterOne(1);
        party.setCharacterTwo(2);
        party.setCharacterThree(3);
        party.setCharacterFour(4);
        //act
        Party newParty = jdbcPartyDao.createParty(party,USER_1.getUsername());

        //assert
        Assert.assertEquals(1,newParty.getId());
    }

    @Test
    public void getPartyByUsername_returns_correct_party() {
        //arrange
        Party party = new Party();
        party.setCharacterOne(1);
        party.setCharacterTwo(2);
        party.setCharacterThree(3);
        party.setCharacterFour(4);
        //act
        Party newParty = jdbcPartyDao.retrievePartyByUsername(USER_1.getUsername(), LocalDate.parse("2020-01-02"));

        //assert
        Assert.assertEquals(1,newParty.getId());
    }



}
