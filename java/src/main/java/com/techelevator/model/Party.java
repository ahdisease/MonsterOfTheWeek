package com.techelevator.model;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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

    public List<Integer> retrieveCharacterIdOrdered(){
        List<Integer> allCharIds = new ArrayList<>();
        allCharIds.add(characterOne);
        allCharIds.add(characterTwo);
        allCharIds.add(characterThree);
        allCharIds.add(characterFour);

        Collections.sort(allCharIds);

        return allCharIds;
    }
}
