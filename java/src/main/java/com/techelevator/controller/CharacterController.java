package com.techelevator.controller;

import com.techelevator.dao.CharacterDao;
import com.techelevator.dao.MonsterDao;
import com.techelevator.dao.PartyDao;
import com.techelevator.dao.UserDao;
import com.techelevator.model.Character;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.support.CustomSQLErrorCodesTranslation;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.print.attribute.standard.PrinterName;
import javax.validation.Valid;
import java.security.Principal;
import java.time.LocalDate;
import java.util.List;

@CrossOrigin
@RestController
@PreAuthorize("hasAnyRole('ADMIN', 'MOD', 'USER')")
public class CharacterController {

    @Autowired
    private CharacterDao dao;
    @Autowired
    private UserDao userDao;



    @RequestMapping(path = "/characters",method = RequestMethod.GET)
    public List<Character> getAllCharacters(@RequestParam(value = "username", required = false) String username,
                                            @RequestParam(value = "date", required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) {

        if(date == null) {
            date = LocalDate.now();
        }
        return dao.getAllCharacters(username, date);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(path = "/characters", method = RequestMethod.POST)
    public Character createNewCharacter(@Valid @RequestBody Character character, Principal user) {
        if(user == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        } else {
            List<Character> checkCharacter = dao.getAllCharacters(user.getName(), LocalDate.now());
            if (checkCharacter.size() == 0){
                character.setUserId(userDao.findIdByUsername(user.getName()));
            }
            else {
                throw new ResponseStatusException(HttpStatus.FORBIDDEN);
            }

        }

        Character character1 = dao.createCharacter(character);

        if(character1 == null){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        } else {
            return character1;
        }
    }

    @PreAuthorize("permitAll()")
    @RequestMapping(path = "/characters/{id}", method = RequestMethod.GET)
    public Character getCharacterById(@PathVariable int id){
        Character character = dao.getCharacterById(id);

        if(character == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        } else {
            return character;
        }
    }

    @RequestMapping(path = "/flag/characters/{id}", method = RequestMethod.PUT)
    public boolean flagCharacterById(@PathVariable int id) {
        //todo find a way to indicate if content already flagged?
        return dao.flagCharacterInappropriate(id);
    }

//    @ResponseStatus(HttpStatus.NO_CONTENT)
//    @RequestMapping(path = "/characters/{id}", method = RequestMethod.DELETE)
//    public void deleteCharacterById(@PathVariable int id, Principal user) {
//
//        //get character by id and confirm character is owned by user
//        if(dao.getCharacterById(id).getUserId() != userDao.findIdByUsername(user.getName())) {
//            //response 403 forbidden if they do not match
//            throw new ResponseStatusException(HttpStatus.FORBIDDEN);
//        }
//
//        //delete character
//        if(!dao.deleteCharacterById(id)) {
//            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
//        }
//    }


}

