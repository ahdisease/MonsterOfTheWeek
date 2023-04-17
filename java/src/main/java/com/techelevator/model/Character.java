package com.techelevator.model;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class Character implements Comparable<Character> {

    @NotNull
    private int id;
    @NotBlank
    private String race;
    @NotBlank
    private String name;
    @NotBlank
    private String description;
    @NotBlank
    private String charClass;
    @Min(1) @Max(30)
    private int strength;
    @Min(1) @Max(30)
    private int dexterity;
    @Min(1) @Max(30)
    private int constitution;
    @Min(1) @Max(30)
    private int intelligence;
    @Min(1) @Max(30)
    private int wisdom;
    @Min(1) @Max(30)
    private int charisma;
    @NotNull
    private int monsterId;
    @NotNull
    private int userId;
    @NotBlank
    private String flaggedInappropriate;
    private boolean active;

    CharacterImage image;

    public CharacterImage getImage() {
        return image;
    }

    public void setImage(CharacterImage image) {
        this.image = image;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Character() {
        flaggedInappropriate = "not_flagged";
    }

    public String getFlaggedInappropriate() {
        return flaggedInappropriate;
    }

    public void setFlaggedInappropriate(String flaggedInappropriate) {
        this.flaggedInappropriate = flaggedInappropriate;
    }

    public int getMonsterId() {
        return monsterId;
    }

    public void setMonsterId(int monsterId) {
        this.monsterId = monsterId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getDexterity() {
        return dexterity;
    }

    public void setDexterity(int dexterity) {
        this.dexterity = dexterity;
    }

    public int getConstitution() {
        return constitution;
    }

    public void setConstitution(int constitution) {
        this.constitution = constitution;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    public int getWisdom() {
        return wisdom;
    }

    public void setWisdom(int wisdom) {
        this.wisdom = wisdom;
    }

    public int getCharisma() {
        return charisma;
    }

    public void setCharisma(int charisma) {
        this.charisma = charisma;
    }

    public String getCharClass() {
        return charClass;
    }

    public void setCharClass(String charClass) {
        this.charClass = charClass;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    //used to sort an array of Character objects by name to avoid duplicate parties in database
    @Override
    public int compareTo(Character o) {
        return this.name.compareTo(o.getName());
    }
}
