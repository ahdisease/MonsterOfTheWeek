package com.techelevator.controller;

import com.techelevator.dao.CharacterDao;
import com.techelevator.dao.PartyDao;
import com.techelevator.model.Character;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.support.CustomSQLErrorCodesTranslation;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;

import javax.print.attribute.standard.PrinterName;
import java.security.Principal;
import java.time.LocalDate;
import java.util.List;

//todo add preauthorize tag
@CrossOrigin
@RestController
public class CharacterController {

    @Autowired
    private CharacterDao dao;
    @Autowired
    private PartyDao partyDao;



    @RequestMapping(path = "/characters",method = RequestMethod.GET)
    public List<Character> getAllCharacters(@RequestParam(value = "username", required = false) String username,
                                            @RequestParam(value = "date", required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) {

        if(date == null) {
            date = LocalDate.now();
        }

        //TODO CHECK LOCAL DATE WORKS

        return dao.getAllCharacters(username, date);
    }

}

