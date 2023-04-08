package com.techelevator.dao;

import com.techelevator.model.Character;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcCharacterDao implements CharacterDao{

    private JdbcTemplate jdbcTemplate;

    public JdbcCharacterDao (JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate =  jdbcTemplate;
    }
    //TODO character table needs a monster foreign key

    @Override
    public List<Character> getAllCharacters() {
        List<Character> characters = new ArrayList<>();
        String sql = "SELECT character.id, character.name, character.race, character.description, character.char_class" +
                " FROM character";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while (results.next()){
            characters.add(mapRowToCharacter(results));
        }

        return characters;
    }

    @Override
    public Character getCharacterById(int id) {
        return null;
    }

    @Override
    public Character createCharacter(Character character) {
        String sql = "INSERT INTO character (name, race, description, char_class) Values (?,?,?,?) RETURNING id;";


        return null;
    }


    private Character mapRowToCharacter(SqlRowSet result){
        Character character = new Character();
        character.setId(result.getInt("id"));
        character.setName(result.getString("name"));
        character.setRace(result.getString("race"));
        character.setDesc(result.getString("description"));
        character.setCharClass(result.getString("char_class"));
        return character;

    }





}
