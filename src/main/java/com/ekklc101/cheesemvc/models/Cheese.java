package com.ekklc101.cheesemvc.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by raefo on 16-May-17.
 */

@Entity
public class Cheese {
    @Id
    @GeneratedValue
    private int id;

    private CheeseType type;

    @NotNull
    @Size(min=3, max=15)
    private String name;

    @NotNull
    @Size(min=1, message="Description must not be empty")
    private String description;

    public Cheese(String n, String d) {
        name = n;
        description = d;
    }

    public Cheese() {}// for hibernate

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public CheeseType getType() {
        return type;
    }

    public void setType(CheeseType t) {
        type = t;
    }
}
