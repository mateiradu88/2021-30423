package com.company.model;
import org.jetbrains.annotations.NotNull;

import java.util.LinkedHashMap;
import java.util.Set;

public class ProductCategoryIndex {

    private LinkedHashMap<Integer,ProductList> index = new LinkedHashMap<>();
    public ProductList uncategorized = new ProductList();

    public ProductCategoryIndex() {
    }

    public ProductList getProductListInCategory(Integer categoryId) {
        return this.index.get(categoryId);
    }

    public void addCategory(Integer categoryId) {
        if(this.index.containsKey(categoryId)){
            return;
        }
        this.index.put(categoryId, new ProductList());
    }
    
    public void removeCategory(Integer categoryId, boolean destructive){
        if(destructive){
            this.index.remove(categoryId);
        }
        else{
            ProductList itemsInCategory = this.index.get(categoryId);
            Set<Integer> keySetItemsInCategory = itemsInCategory.getProducts().keySet();
            this.index.remove(categoryId);
            for (Integer productId: keySetItemsInCategory) {
                this.uncategorized.addProduct(itemsInCategory.getProduct(productId));
            }
        }
    }
    
    public void addProductToCategoryIndex(Product product){
        //get all categoryIDs of product and iterate through them
        Set<Integer> ProductCategoryIds = product.getCategoryList().getCategories().keySet();
        for (Integer categoryId : ProductCategoryIds) {
            //smart add checks if there is such a category and only adds it if it does not exist
            addCategory(categoryId);
            ProductList itemsInCategory = index.get(categoryId);
            itemsInCategory.addProduct(product);
            index.replace(categoryId, itemsInCategory);
        }
    }
    
    public void removeProductFromCategoryIndex(Product product) {
        //get all categoryIDs of product and iterate through them
        Set<Integer> ProductCategoryIds = product.getCategoryList().getCategories().keySet();
        for (Integer categoryId : ProductCategoryIds) {
            ProductList itemsInCategory = index.get(categoryId);
            itemsInCategory.removeProduct(product.getId());
            if (itemsInCategory.getNoProducts() == 0) {
                index.remove(categoryId);
            } else {
                index.replace(categoryId, itemsInCategory);
            }
        }
    }
}
