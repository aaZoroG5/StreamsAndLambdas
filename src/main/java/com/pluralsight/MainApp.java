package com.pluralsight;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MainApp {

    public static void main(String[] args) {

        ArrayList<Character> characters = new ArrayList<Character>();
        characters.add(new Character("Luke Skywalker", 172, 77, "blue", "male"));
        characters.add(new Character("Darth Vader", 202, 136, "yellow", "male"));
        characters.add(new Character("Leia Organa", 150, 49, "brown", "female"));
        characters.add(new Character("Anakin Skywalker", 188, 84, "blue", "male"));

        // 1. Print names in all uppercase
        System.out.println("=== Names in UPPERCASE ===");
        for (Character c : characters) {
            System.out.println(c.getName().toUpperCase());
        }

        //Made a stream with the map method with each character and convert its name to upper
        //create a for each loop to display the results
        characters.stream()
                        .map( (character) -> character.getName().toUpperCase() )
                        .forEach( (name) -> System.out.println(name) );//the result of map gets passed down as "name", but you ca call it whatever

        //here we are creating a new list with the characters name in uippercase
        List<String> namesUpperCase =  characters.stream()
                        .map( (character) -> character.getName().toUpperCase() )
                        .collect(Collectors.toList());

        namesUpperCase.forEach((name) -> {
            System.out.println(name);
            System.out.println(name.toLowerCase());
        });

        // 2. Filter characters with mass > 80
        System.out.println("\n=== Characters with Mass > 80 ===");
        ArrayList<Character> filtered = new ArrayList<Character>();
        for (Character c : characters) {
            if (c.getMass() > 80) {
                filtered.add(c);
                System.out.println(c.getName() + " (" + c.getMass() + ")");
            }
        }

        List<Character> heavyCharacter = characters.stream()
                .filter((character) -> character.getMass() > 80)
                        .toList();

        heavyCharacter.forEach((character) -> System.out.println(character.getName() + " - " + character.getMass()));

        // 3. Create a list of just names
        System.out.println("\n=== Character Names ===");
        ArrayList<String> names = new ArrayList<String>();
        for (Character c : characters) {
            names.add(c.getName());
        }
        for (String name : names) {
            System.out.println(name);
        }

        // 4. Check if any character has blue eyes
        boolean hasBlueEyes = false;
        for (Character c : characters) {
            if (c.getEyeColor().equalsIgnoreCase("blue")) {
                hasBlueEyes = true;
                break;
            }
        }

        boolean tieneBlueEyes = characters.stream().anyMatch((character) -> character.getEyeColor().equalsIgnoreCase("blue"));

        if (hasBlueEyes) {
            System.out.println("\nSome characters have blue eyes");
        } else {
            System.out.println("\nNo characters have blue eyes");
        }

        // 5. Check if all characters are male
        boolean allMale = true;
        for (Character c : characters) {
            if (!c.getGender().equalsIgnoreCase("male")) {
                allMale = false;
                break;
            }
        }
        if (allMale) {
            System.out.println("All the characters are male");
        } else {
            System.out.println("Not all characters are male");
        }

        // 6. Calculate total mass
        int totalMass = 0;
        for (Character c : characters) {
            totalMass += c.getMass();
        }
        System.out.println("Total mass: " + totalMass);
    }
}
