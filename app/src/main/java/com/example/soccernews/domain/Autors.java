package com.example.soccernews.domain;

import androidx.room.Entity;
import androidx.room.PrimaryKey;
@Entity
public  class Autors {
    @PrimaryKey
    public int id;
    public String title;
    public String description;
    public String image;
    public String link;
    public String etc;

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public void setEtc(String etc) {
        this.link = etc;
    }



}
