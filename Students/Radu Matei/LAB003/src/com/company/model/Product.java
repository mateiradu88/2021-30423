package com.company.model;

public class Product {

    public String name;
    private final Integer id;
    private Integer quantity;
    private CategoryList productCategories;
    private Integer priceInBani;

    public Product(Integer id) {
        this.id = id;
    }

    public Product(String name, Integer id, CategoryList categoryIDs) {
        this.name = name;
        this.id = id;
        this.productCategories = categoryIDs;
    }


    public Integer getPriceInBani() {
        return priceInBani;
    }

    public void setPriceInBani(Integer priceInBani) {
        this.priceInBani = priceInBani;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public CategoryList getCategoryList() {
        return productCategories;
    }

    public void setCategoryIDs(CategoryList categoryIDs) {
        this.productCategories = categoryIDs;
    }

    public Integer getId() {
        return id;
    }
}
