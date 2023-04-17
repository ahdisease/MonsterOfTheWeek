package com.techelevator.dao;

import com.techelevator.model.CharacterImage;

import java.util.List;

public interface CharacterImageDao {
    public CharacterImage addImage(String imageUrl);

    public CharacterImage getImageById(int id);

    public List<CharacterImage> getUnapprovedImages();

    public boolean approveImage(int id);

}
