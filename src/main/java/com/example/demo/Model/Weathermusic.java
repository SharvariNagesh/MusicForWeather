package com.example.demo.Model;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author: Sharvari Nagesh
 * Model to store Music data returned from the DB. The design has changed now. And this model is not used.
 */
@Entity
public class Weathermusic {

    @Id
    private int id;
    private String weather;
    private String music;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getWeather() {
        return weather;
    }

    public void setWeather(String weather) {
        this.weather = weather;
    }

    public String getMusic() {
        return music;
    }

    public void setMusic(String music) {
        this.music = music;
    }
}
