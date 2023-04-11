package com.techelevator.controller;

import com.techelevator.dao.MonsterDao;
import com.techelevator.model.Monster;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.time.LocalDate;

@CrossOrigin
@RestController
public class MonsterController {

    @Autowired
    private MonsterDao monsterDao;



    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(path = "/monsters", method = RequestMethod.POST)
    public Monster addMonster(@Valid @RequestBody Monster monster){
        return monsterDao.addMonster(monster);
    }


    @RequestMapping(path = "/monsters", method = RequestMethod.GET)
    public Monster retrieveMonsterByDate(@RequestParam(value = "date", required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) {

        if(date == null) {
            date = LocalDate.now();
        }
        Monster monster = monsterDao.getMonsterByDate(date);

        if(monster == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return monster;



    }


}
