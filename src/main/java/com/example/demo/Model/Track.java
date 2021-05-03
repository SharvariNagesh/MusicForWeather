package com.example.demo.Model;

public class Track {
    private String name;
    private String externalUrl;

    public Track(String name, String externalUrl) {
        this.name = name;
        this.externalUrl = externalUrl;
    }

    public Track() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getExternalUrl() {
        return externalUrl;
    }

    public void setExternalUrl(String externalUrl) {
        this.externalUrl = externalUrl;
    }

    @Override
    public String toString() {
        return "Track{" +
                "name='" + name + '\'' +
                ", externalUrl='" + externalUrl + '\'' +
                '}';
    }
}
