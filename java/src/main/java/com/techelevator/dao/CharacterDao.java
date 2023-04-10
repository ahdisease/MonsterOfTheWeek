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
    //TODO throw an exception for not found

//    Create Character
//    url: "/characters/"
//    http method: post
//    status: 201 created
    Character createCharacter (Character character);

}
