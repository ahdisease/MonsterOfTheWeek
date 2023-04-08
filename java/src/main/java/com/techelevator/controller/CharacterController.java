package com.techelevator.controller;

import com.techelevator.dao.CharacterDao;
import com.techelevator.model.Character;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//todo add preauthorize tag
@CrossOrigin
@RestController
public class CharacterController {

    @Autowired
    private CharacterDao dao;


    @RequestMapping(path = "/characters",method = RequestMethod.GET)
    public List<Character> getAllCharacters() {

        return dao.getAllCharacters();
    }

}

