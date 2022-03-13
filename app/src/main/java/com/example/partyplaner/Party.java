package com.example.partyplaner;

import android.media.Image;

import androidx.annotation.NonNull;

import java.util.Date;
import java.util.UUID;

public class Party {
    private String name;
    private String location;
    private String datetime;
    private Image image;
    private String type;
    private String description;
    private int likes;
    private String uuid;

    public Party(String name, String location, String datetime, String type, String description) {
        this.name = name;
        this.location = location;
        this.datetime = datetime;
        //this.image = image;
        this.type = type;
        this.description = description;
        //this.likes = likes;
    }

    public Party() {
        uuid = UUID.randomUUID().toString().replace("-","");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    @NonNull
    @Override
    public String toString() {
        return super.toString();
    }
}
