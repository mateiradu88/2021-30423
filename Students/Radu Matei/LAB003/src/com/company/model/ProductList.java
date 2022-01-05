package com.company.model;

import java.util.LinkedHashMap;

public class ProductList {

    private LinkedHashMap<Integer,Product> products = new LinkedHashMap<>();

    private Integer noProducts;

    public ProductList() {
        this.noProducts = 0;
    }

    public Product getProduct(Integer productId) {
        return this.products.get(productId);
    }

    public void addProduct(Product product) {
        //guard clause for duplicate products
        if(this.products.containsKey(product.getId())){
            System.out.println("There's already a product with this id. Canceling job...");
            return;
        }
        //adding the product
        this.products.put(product.getId(),product);
        this.noProducts++;
    }

    public void removeProduct(Integer productId) {
        this.products.remove(productId);
        this.noProducts--;
    }

    public LinkedHashMap<Integer, Product> getProducts() {
        return products;
    }

    public Integer getNoProducts() {
        return noProducts;
    }
}
