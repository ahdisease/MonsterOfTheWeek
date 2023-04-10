package com.techelevator.dao;

import com.techelevator.model.Party;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintViolationException;
import java.security.Principal;

@Component
public class JdbcPartyDao implements PartyDao {

    private JdbcTemplate jdbcTemplate;


    public JdbcPartyDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public Party createParty(Party partyCharacters, String username) {
        //don't allow anonymous users to create parties
        if (username == null) {
            //todo throw error
            return null;
        }

        //attempt to create party in db
        String createPartySQL = "INSERT INTO party (character_1, character_2, character_3, character_4) VALUES (?,?,?,?) RETURNING id;";
        Integer id =null;
        try {
            id = jdbcTemplate.queryForObject(createPartySQL, Integer.class,
                    partyCharacters.getCharacterOne(),partyCharacters.getCharacterTwo(), partyCharacters.getCharacterThree(), partyCharacters.getCharacterFour());

            partyCharacters.setId(id);
        } catch (DuplicateKeyException e) {
            System.out.println(e.getMessage());
        }
        //if party exists, get id that matches existing party

        //create or update user_party
//        String updateUserSql = "UPDATE users SET party_id = ? WHERE username = ?";
//
//        jdbcTemplate.update(updateUserSql,id,username);

        return partyCharacters;
    }

    @Override
    public Party getPartyByUsername(String username) {


        return null;
    }

}
