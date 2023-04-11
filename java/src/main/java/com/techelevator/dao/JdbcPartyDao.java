package com.techelevator.dao;

import com.techelevator.model.Party;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

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

        List<Integer> orderedCharacters = partyCharacters.retrieveCharacterIdOrdered();

        if (username == null) {
            return null;
        }

        //attempt to create party in db
        Integer id = getPartyId(orderedCharacters);
        partyCharacters.setId(id);

        String selectPartySql = "SELECT party_id FROM users_party " +
                "JOIN party ON users_party.party_id = party.id " +
                "JOIN character On party.character_1 = character.id " +
                "WHERE users_party.user_id = (SELECT users.user_id FROM users WHERE username = ?) " +
                "AND character.monster_id = (SELECT character.monster_id FROM character WHERE id = ?)";
        SqlRowSet result = jdbcTemplate.queryForRowSet(selectPartySql, username, id);

        //if user already submitted a party, they dont create another one
        //else it is submitted

        if(result.next()) {
            return partyCharacters;
        } else {
            String insertUserSql = "INSERT INTO users_party(user_id, party_id) Values (?, ?)";
            jdbcTemplate.queryForRowSet(insertUserSql,username,id);

        }
        return partyCharacters;

    }

    private Integer getPartyId(List<Integer> orderedCharacters) {
        String createPartySQL = "INSERT INTO party (character_1, character_2, character_3, character_4) VALUES (?,?,?,?) RETURNING id;";
        Integer id =null;
        try {
            id = jdbcTemplate.queryForObject(createPartySQL, Integer.class,
                    orderedCharacters.get(0), orderedCharacters.get(1), orderedCharacters.get(2), orderedCharacters.get(3));

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
    public Party getPartyById(int id) {
        Party party = null;
        String sql = "SELECT character_1, character_2, character_3, character_4 " +
                "FROM party WHERE id = ?";
        SqlRowSet result = jdbcTemplate.queryForRowSet(sql, id);

        if(result.next()){
            party = new Party();
            party.setCharacterOne(result.getInt("character_1"));
            party.setCharacterTwo(result.getInt("character_2"));
            party.setCharacterThree(result.getInt("character_3"));
            party.setCharacterFour(result.getInt("character_4"));
            party.setId(id);
        }


        return party;
    }

}
