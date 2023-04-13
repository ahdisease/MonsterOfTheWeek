package com.techelevator.dao;

import com.techelevator.model.Character;

import java.security.Principal;
import java.time.LocalDate;
import java.util.List;

public interface CharacterDao {

//    Get List of Characters
//    url: "/characters/?date"
//    http method: get
//    status: 200 ok
//            [],

    List<Character> getAllCharacters(String username, LocalDate date);

//    Get Character Details
//    url: "/characters/{id}"
//    http method: get
//    status: 200 ok
//	404 not found

    Character getCharacterById (int id);


//    Create Character
//    url: "/characters/"
//    http method: post
//    status: 201 created
    Character createCharacter (Character character);

    boolean deleteCharacterById(int id);

//    Flag inappropriate content
//    url: "/flag/characters/{id}"
//    http method: put
//    status 200 OK
//	    403 Forbidden
//	    404 Not Found
    boolean flagCharacterInappropriate (int id);

}
