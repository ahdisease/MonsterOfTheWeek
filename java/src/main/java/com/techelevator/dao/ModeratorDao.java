package com.techelevator.dao;

public interface ModeratorDao {

    boolean banUser(int id);

    boolean deleteCharacterById(int id);
}
