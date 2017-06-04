package com.ekklc101.cheesemvc.models;

/**
 * Created by raefo on 04-Jun-17.
 */
public enum CheeseType {
    AGED ("Aged"),
    PROCESSED ("Processed"),
    SHARP ("Sharp"),
    NONE ("none"),
    MILD ("Mild");

    private final String name;

    CheeseType(String n) {
        name = n;
    }

    public String getName() {
        return name;
    }
}
