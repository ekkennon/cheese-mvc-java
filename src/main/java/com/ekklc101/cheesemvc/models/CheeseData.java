package com.ekklc101.cheesemvc.models;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by raefo on 27-May-17.
 */
public class CheeseData {
    static ArrayList<Cheese> cheeses = new ArrayList<>();

    public static ArrayList<Cheese> getAll() {
        return cheeses;
    }

    public static void add(Cheese c) {
        cheeses.add(c);
    }

    public static void remove(int c) {
        //cheeses.removeIf(c -> c.getName().equals(cheeseName));
        cheeses.remove(getById(c));
    }

    public static void edit(Cheese c) {
        Cheese editCheese = cheeses.get(c.getId());
        editCheese.setName(c.getName());
        editCheese.setDesc(c.getDesc());
    }

    public static Cheese getById(int id) {
        for (Cheese candidate : cheeses) {
            if (candidate.getId() == id) {
                return candidate;
            }
        }
        return null;
    }

    public static boolean isValidInput(String input) {
        for (int c : input.toCharArray()) {
            if (c > 122 || c < 32 || (c < 65 && c > 32) || (c < 97 && c > 90)) {//space=32,uppercase=65-90,lowercase=97-122
                return false;
            }
        }
        return true;
    }
}
