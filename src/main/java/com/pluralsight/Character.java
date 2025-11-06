package com.pluralsight;

public class Character {

    //properties
    private String name;
    private int height;
    private int mass;
    private String eyeColor;
    private String gender;

    //constructor
    public Character(String name, int height, int mass, String eyeColor, String gender) {
        this.name = name;
        this.height = height;
        this.mass = mass;
        this.eyeColor = eyeColor;
        this.gender = gender;
    }

    //getters
    public String getName() {
        return name;
    }

    public int getHeight() {
        return height;
    }

    public int getMass() {
        return mass;
    }

    public String getEyeColor() {
        return eyeColor;
    }

    public String getGender() {
        return gender;
    }

}
