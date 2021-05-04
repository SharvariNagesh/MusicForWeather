package com.example.demo.Model;

import com.wrapper.spotify.enums.ModelObjectType;

import java.util.ArrayList;
import java.util.List;
/**
 * @author: Sharvari Nagesh
 * Model to store Music play lists and Weather information. This object is sent back to the user in the final response.
 */
public class Music {
    private Location location;
    private Temperature temperature;
    private String href;
    private String name;
    private List<Track> trackList = new ArrayList<Track>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public List<Track> getTrackList() {
        return trackList;
    }

    public void setTrackList(List<Track> trackList) {
        this.trackList = trackList;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Temperature getTemperature() {
        return temperature;
    }

    public void setTemperature(Temperature temperature) {
        this.temperature = temperature;
    }

    @Override
    public String toString() {
        return "Music{" +
                "location=" + location +
                ", temperature=" + temperature +
                ", href='" + href + '\'' +
                ", name='" + name + '\'' +
                ", trackList=" + trackList +
                '}';
    }

}
