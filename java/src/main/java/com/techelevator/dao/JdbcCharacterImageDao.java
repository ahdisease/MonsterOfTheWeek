package com.techelevator.dao;

import com.techelevator.model.CharacterImage;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcCharacterImageDao implements CharacterImageDao{

    private JdbcTemplate jdbcTemplate;

    public JdbcCharacterImageDao (JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate =  jdbcTemplate;
    }




    @Override
    public CharacterImage addImage(String imageUrl) {
        CharacterImage image =  null;
        String sql = "INSERT INTO image (url) VALUES (?) returning id";

        Integer id = jdbcTemplate.queryForObject(sql,Integer.class,imageUrl);

        if (id != null) {
            image = new CharacterImage();
            image.setId(id);
            image.setUrl(imageUrl);
            image.setApproved(false);
        }

        return image;
    }

    @Override
    public CharacterImage getImageById(int id) {
        CharacterImage image = null;

        String sql = "SELECT id, url, approved FROM image WHERE id = ?";
        SqlRowSet result = jdbcTemplate.queryForRowSet(sql,id);

        if(result.next()) {
            image = mapRowToCharacterImage(result);
        }

        return image;
    }

    @Override
    public List<CharacterImage> getUnapprovedImages() {
        List<CharacterImage> images = new ArrayList<>();

        String sql = "SELECT id, url, approved FROM image where approved = false;";
        SqlRowSet result = jdbcTemplate.queryForRowSet(sql);

        while(result.next()) {
            images.add(mapRowToCharacterImage(result));
        }

        return images;
    }

    @Override
    public boolean approveImage(int id) {

        if (getImageById(id) == null) {
            return false;
        }

        String sql = "UPDATE image SET approved = 'true' WHERE id = ?";

        jdbcTemplate.update(sql,id);

        return true;
    }

    private CharacterImage mapRowToCharacterImage(SqlRowSet result) {
        CharacterImage image = new CharacterImage();

        image.setId(result.getInt("id"));
        image.setUrl(result.getString("url"));
        image.setApproved(result.getBoolean("approved"));

        return image;
    }
}
