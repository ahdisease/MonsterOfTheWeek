package com.techelevator.dao;


import com.techelevator.model.Monster;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.time.LocalDate;

public class JdbcMonsterDaoTest extends BaseDaoTests{

    private JdbcMonsterDao jdbcMonsterDao;


    @Before
    public void setup(){

        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        jdbcMonsterDao = new JdbcMonsterDao(jdbcTemplate);
    }

    @Test
    public void get_monster_by_date(){

        Monster monster = jdbcMonsterDao.getMonsterByDate(LocalDate.parse("2020-01-01"));

        Monster monsterId1 = new Monster();
        monsterId1.setId(1);
        monsterId1.setNameIndex("a");
        monsterId1.setStartDate(LocalDate.parse("2020-01-01"));
        monsterId1.setEndDate(LocalDate.parse("2020-01-07"));


        monster_details_should_match(monster, monsterId1);

    }

    @Test
    public void add_monster(){
        Monster monster = new Monster();
        monster.setId(-1);
        monster.setNameIndex("z");
        monster.setStartDate(LocalDate.parse("2022-01-01"));
        monster.setEndDate(LocalDate.parse("2022-01-08"));

        Monster newMonster = jdbcMonsterDao.addMonster(monster);
        monster_details_should_match(monster, newMonster);

        Assert.assertNotEquals(-1, monster.getId());
        Assert.assertNotEquals(-1, newMonster.getId());

    }

    private void monster_details_should_match(Monster expected, Monster actualMonster){

        Assert.assertEquals(expected.getNameIndex(), actualMonster.getNameIndex());
        Assert.assertTrue(expected.getStartDate().equals(actualMonster.getStartDate()));
        Assert.assertTrue(expected.getEndDate().equals(actualMonster.getEndDate()));

    }

}
