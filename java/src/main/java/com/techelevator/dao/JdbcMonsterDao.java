package com.techelevator.dao;

import com.techelevator.model.Monster;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.security.access.prepost.PreAuthorize;
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
        Monster monster = null;
        String sql = "SELECT id, name_index, start_date, end_date FROM monster WHERE ? BETWEEN start_date AND end_date;";
        SqlRowSet result = jdbcTemplate.queryForRowSet(sql, date);

        if(result.next()){
            monster = new Monster();
            monster.setId(result.getInt("id"));
            monster.setNameIndex(result.getString("name_index"));
            monster.setStartDate(result.getDate("start_date").toLocalDate());
            monster.setEndDate(result.getDate("end_date").toLocalDate());
        }

        return monster;
    }

    @Override
    public Monster addMonster(Monster monster) {

        String sql = "INSERT INTO monster (name_index, start_date, end_date) VALUES (?,?,?) RETURNING id;";

        Integer result = jdbcTemplate.queryForObject(sql, Integer.class, monster.getNameIndex(), monster.getStartDate(), monster.getEndDate());

        if(result != null){
            monster.setId(result);
        }

        return monster;
    }


}
