package com.techelevator.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

@Component
public class JdbcModeratorDao implements ModeratorDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcModeratorDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public boolean deleteCharacterById(int id) {
        String sql = "UPDATE character SET active = false WHERE id = ?";

        try {
            jdbcTemplate.update(sql,id);
        } catch (Exception e) {
            return false;
        }

        return true;
    }


    @Override
    public boolean banUser(int id) {
        String sql = "UPDATE users SET role = 'ROLE_BAN' WHERE user_id = ?;";
        try {
            jdbcTemplate.update(sql, id);
        } catch (Exception x) {
            return false;
        }

        try {
            String selectSql = "SELECT id FROM character WHERE user_id = ?;";

            SqlRowSet result = jdbcTemplate.queryForRowSet(selectSql, id);

            while(result.next()){
                deleteCharacterById(result.getInt("id"));
            }
        } catch (Exception ex) {
            return false;
        }
        return true;
    }


}
