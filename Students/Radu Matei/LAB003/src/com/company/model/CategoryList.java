package com.company.model;

import java.util.LinkedHashMap;

public class CategoryList {

    private LinkedHashMap<Integer,Category> categories = new LinkedHashMap<>();
    private Integer noCategories;

    public CategoryList() {
        this.noCategories = 0;
    }

    public Category getCategory(Integer categoryId) {
        return this.categories.get(categoryId);
    }

    public void addCategory(Category category) {
        if(categories.containsKey(category.getId())){
            System.out.println("Category ID already in Category List");
            System.out.println("Canceling job...");
            return;
        }
        this.categories.put(category.getId(),category);
        this.noCategories++;
    }

    public void removeCategory(Integer categoryId) {
        this.categories.remove(categoryId);
        this.noCategories--;
    }

    public LinkedHashMap<Integer, Category> getCategories() {return this.categories;}

    public boolean hasCategory(Integer categoryId){return this.categories.containsKey(categoryId);}

    public Integer getNoCategories() {return this.noCategories;}
}
