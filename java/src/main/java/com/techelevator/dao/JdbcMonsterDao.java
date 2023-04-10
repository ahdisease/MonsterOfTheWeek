package com.techelevator.dao;

import com.techelevator.model.Monster;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class JdbcMonsterDao implements MonsterDao{

    private JdbcTemplate jdbcTemplate;

    public JdbcMonsterDao (JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate =  jdbcTemplate;
    }



    @Override
    public Monster getMonsterByDate(LocalDate date) {


        return null;
    }

    @Override
    public Monster addMonster() {


        return null;
    }


}
