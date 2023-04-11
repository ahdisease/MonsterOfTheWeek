package com.techelevator.dao;

import com.techelevator.model.Party;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintViolationException;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcPartyDao implements PartyDao {

    private JdbcTemplate jdbcTemplate;


    public JdbcPartyDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public Party createParty(Party partyCharacters, String username) {
        //don't allow anonymous users to create parties

        List<Integer> orderedCharacters = partyCharacters.getCharacterIdOrdered();

        if (username == null) {
            return null;
        }

        //attempt to create party in db
        Integer id = getPartyId(partyCharacters, orderedCharacters);


        String selectPartySql = "SELECT party_id FROM users_party JOIN users ON users.user_id WHERE username = (SELECT users.user_id FROM users WHERE username = ? AND )";
        //create or update user_party
        String insertUserSql = "INSERT INTO users_party(user_id, party_id) Values (?, ?)";
        jdbcTemplate.queryForRowSet(insertUserSql,id,username);

        String updateUserSql = "UPDATE users_party SET user_party.user_id = ?, party_id = ? WHERE username = (SELECT users.user_id FROM users WHERE username = ?)";
        jdbcTemplate.queryForRowSet(updateUserSql,id, username);


        return partyCharacters;
    }

    private Integer getPartyId(Party partyCharacters, List<Integer> orderedCharacters) {
        String createPartySQL = "INSERT INTO party (character_1, character_2, character_3, character_4) VALUES (?,?,?,?) RETURNING id;";
        Integer id =null;
        try {
            id = jdbcTemplate.queryForObject(createPartySQL, Integer.class,
                    orderedCharacters.get(0), orderedCharacters.get(1), orderedCharacters.get(2), orderedCharacters.get(3));

            partyCharacters.setId(id);
        } catch (DuplicateKeyException e) {
            //if party exists, get id that matches existing party
            String sql = "SELECT id FROM party WHERE character_1 = ? AND character_2 = ? AND character_3 = ? AND character_4 = ?";
            SqlRowSet result = jdbcTemplate.queryForRowSet(sql, orderedCharacters.get(0), orderedCharacters.get(1), orderedCharacters.get(2), orderedCharacters.get(3));

            if(result.next()){
                id = result.getInt("id");
            }
        }
        return id;
    }

    @Override
    public Party getPartyByUsername(String username) {


        return null;
    }

}
