package com.techelevator.dao;

import com.techelevator.model.Character;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;

public class JdbcCharacterDaoTests extends BaseDaoTests{

    private JdbcCharacterDao jdbcCharacterDao;

    @Before
    public void setup(){
    JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
    jdbcCharacterDao = new JdbcCharacterDao(jdbcTemplate);
    }

    @Test
    public void retrieve_character_list (){

        Assert.assertEquals(1, jdbcCharacterDao.getAllCharacters().size());
    }


}
