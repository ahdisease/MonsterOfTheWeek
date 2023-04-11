package com.techelevator.dao;

import com.techelevator.model.Monster;

import java.time.LocalDate;

public interface MonsterDao {

    Monster getMonsterByDate(LocalDate date);

    Monster addMonster(Monster monster);


}
