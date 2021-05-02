package com.example.demo.Model;


import lombok.Data;

import javax.validation.constraints.Pattern;


@Data
public class Location {
    @Pattern(regexp="^[A-Z a-z \\\\s\\\\-]*$",message = "Invalid Input")
    private String name;
    @Pattern(regexp = "^([-+]?([1-8]?\\d(\\.\\d+)?|90(\\.0+)?))|$", message ="Invalid lat value")
    private String latitude;
    @Pattern(regexp = "^([-+]?(180(\\.0+)?|((1[0-7]\\d)|([1-9]?\\d))(\\.\\d+)?))|$", message ="Invalid long value")
    private String longitude;

    public void Location(){}

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
