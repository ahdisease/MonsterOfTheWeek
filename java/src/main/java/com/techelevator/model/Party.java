package com.techelevator.model;

import org.springframework.security.web.PortResolverImpl;

import javax.validation.constraints.NotNull;

public class Party {

    @NotNull
    private int id;
    @NotNull
    private int characterOne;
    @NotNull
    private int characterTwo;
    @NotNull
    private int characterThree;
    @NotNull
    private int characterFour;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCharacterOne() {
        return characterOne;
    }

    public void setCharacterOne(int characterOne) {
        this.characterOne = characterOne;
    }

    public int getCharacterTwo() {
        return characterTwo;
    }

    public void setCharacterTwo(int characterTwo) {
        this.characterTwo = characterTwo;
    }

    public int getCharacterThree() {
        return characterThree;
    }

    public void setCharacterThree(int characterThree) {
        this.characterThree = characterThree;
    }

    public int getCharacterFour() {
        return characterFour;
    }

    public void setCharacterFour(int characterFour) {
        this.characterFour = characterFour;
    }
}
