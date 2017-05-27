package com.ekklc101.cheesemvc.models;

/**
 * Created by raefo on 16-May-17.
 */
public class Cheese {
    private static int nextId = 0;
    private int id;
    private String name;
    private String desc;

    public Cheese(String n, String d) {
        this();
        name = n;
        desc = d;
    }

    public Cheese() {
        id = nextId++;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
