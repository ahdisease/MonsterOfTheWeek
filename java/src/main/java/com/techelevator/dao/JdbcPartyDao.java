package com.techelevator.dao;

import com.techelevator.model.Party;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class JdbcPartyDao implements PartyDao{

    private JdbcTemplate jdbcTemplate;

    public JdbcPartyDao (JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate =  jdbcTemplate;
    }



    @Override
    public Party createParty(Character character) {



        return null;
    }

    @Override
    public Party getPartyByUsername(String username) {




        return null;
    }

    @Override
    public Party updateParty() {



        return null;
    }
}
