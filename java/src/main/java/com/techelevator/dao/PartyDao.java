package com.techelevator.dao;

import com.techelevator.model.Party;

import java.security.Principal;
import java.time.LocalDate;
import java.util.List;

public interface PartyDao {

    Party createParty(Party partyCharacters, String username);

    Party retrievePartyById(int id);

    Party retrievePartyByUsername(String username, LocalDate date);

    Party retrieveWinningPartyForDate(LocalDate date);

}
