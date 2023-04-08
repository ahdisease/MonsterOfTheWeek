package com.techelevator.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class Character {

    @NotNull
    private int id;
    @NotBlank
    private String race;
    @NotBlank
    private String name;
    @NotBlank
    private String desc;
    @NotBlank
    private String charClass;

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

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }



}
