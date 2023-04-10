package com.techelevator.dao;

import com.techelevator.model.Party;

public interface PartyDao {

    Party createParty(Character character);

    Party getPartyByUsername(String username);

    Party updateParty();


}
