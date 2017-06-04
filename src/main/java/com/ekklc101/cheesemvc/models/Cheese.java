package com.ekklc101.cheesemvc.models;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by raefo on 16-May-17.
 */
public class Cheese {
    private static int nextId = 0;
    private int id;
    private CheeseType type;

    @NotNull
    @Size(min=3, max=15)
    private String name;

    @NotNull
    @Size(min=1, message="Description must not be empty")
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

    public CheeseType getType() {
        return type;
    }

    public void setType(CheeseType t) {
        type = t;
    }
}
