package com.techelevator.model;

import javax.validation.constraints.NotBlank;

public class CharacterImage {
    private int id;
    @NotBlank
    private String url;
    private boolean approved = false;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public boolean isApproved() {
        return approved;
    }

    public void setApproved(boolean approved) {
        this.approved = approved;
    }
}
