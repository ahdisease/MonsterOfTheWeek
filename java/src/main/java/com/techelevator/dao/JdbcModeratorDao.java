package com.techelevator.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class JdbcModeratorDao implements ModeratorDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcModeratorDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }



    
    @Override
    public int banUser(int id) {
        String sql = "UPDATE users SET role = 'ROLE_BAN' WHERE user_id = ?;";
        return jdbcTemplate.update(sql, id);
    }
}
