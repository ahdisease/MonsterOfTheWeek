package com.techelevator.controller;

import com.techelevator.dao.PartyDao;
import com.techelevator.model.Party;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;

@CrossOrigin
@RestController
public class PartyController {

    @Autowired
    private PartyDao partyDao;


//TODO FIX IF STATEMENT


    @RequestMapping(path = "/party/", method = RequestMethod.POST)
    public Party createParty(@Valid @RequestBody Party party, Principal user){
        if(user == null) {
            return partyDao.createParty(party, "user");
        }
        return partyDao.createParty(party, user.getName());
    }


    @RequestMapping(path = "/party/{id}", method = RequestMethod.GET)
    public Party getPartyById(@PathVariable int id){
        return partyDao.getPartyById(id);

    }


}
