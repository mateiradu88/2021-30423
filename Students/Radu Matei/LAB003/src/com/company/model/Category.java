package com.company.model;

public class Category {

    private String name;
    private final Integer id;

    public Category(Integer id) {
        this.id = id;
    }

    public Category(Integer id, String name) {
        this.id =id;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }
}
