package com.techelevator.dao;

import com.techelevator.model.Party;

import java.security.Principal;
import java.util.List;

public interface PartyDao {

    Party createParty(Party partyCharacters, String username);

    Party getPartyById(int id);



}
