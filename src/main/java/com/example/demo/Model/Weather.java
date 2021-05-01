package com.example.demo.Model;


public class Weather {
    private Coordinates coord;
    private String name;
    private String id;
    private String timezone;
    private String cod;
    private Temperature main;

    public Coordinates getCoord() {
        return coord;
    }

    public void setCoord(Coordinates coord) {
        this.coord = coord;
    }

    public Temperature getMain() {
        return main;
    }

    public void setMain(Temperature main) {
        this.main = main;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    @Override
    public String toString() {
        return "Weather{" +
                "coord=" + coord +
                ", name='" + name + '\'' +
                ", id='" + id + '\'' +
                ", timezone='" + timezone + '\'' +
                ", cod='" + cod + '\'' +
                ", main=" + main +
                '}';
    }
}
