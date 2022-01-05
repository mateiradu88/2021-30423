package com.company.model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Set;

public class ShopService {
    private Integer sales;
    private CategoryList categories = new CategoryList();
    private ProductList products = new ProductList();
    private ProductCategoryIndex productCategoryIndex = new ProductCategoryIndex();

    public ShopService() {
        this.sales = 0;
    }

    public Integer getSales() {
        return sales;
    }

    private void addCategory(Category category){
        this.categories.addCategory(category);
        this.productCategoryIndex.addCategory(category.getId());
    }

    private boolean categoriesExistInCategoryList(CategoryList requestedCategories, boolean message){
        Set<Integer> requestedProductCategoryIds = requestedCategories.getCategories().keySet();
        for (Integer id : requestedProductCategoryIds) {
            //guard clause checking if all the categories have been added
            if(!categories.hasCategory(id)){
                if(message){
                    System.out.println("There is no category with id:" + id);
                }
                return false;
            }
        }
        return true;
    }

    public void addProduct(Product product){
        //check if all categories exist guard clause
        if(!categoriesExistInCategoryList(product.getCategoryList(),true)){
            System.out.println("Canceling job...");
            return;
        }
        this.products.addProduct(product);
        this.productCategoryIndex.addProductToCategoryIndex(product);
    }

    public void removeProduct(Integer productId){
        productCategoryIndex.removeProductFromCategoryIndex(this.products.getProduct(productId));
        products.removeProduct(productId);
    }

    public void updateProduct(Product product){
        if(!categoriesExistInCategoryList(product.getCategoryList(),true)){
            System.out.println("Canceling job...");
            return;
        }
        Product oldProduct = this.products.getProduct(product.getId());
        this.products.removeProduct(product.getId());
        this.products.addProduct(product);
        this.productCategoryIndex.removeProductFromCategoryIndex(oldProduct);
        this.productCategoryIndex.addProductToCategoryIndex(product);
    }

    public void sellProduct(Integer productId, Integer nb){
        Product newProductEntry = this.products.getProduct(productId);
        if(newProductEntry.getQuantity()-nb>=0){
            newProductEntry.setQuantity(newProductEntry.getQuantity()-nb);
            updateProduct(newProductEntry);
            this.sales+=(newProductEntry.getPriceInBani()*nb);
        }
        else {
            System.out.println("Not enough product in stock. Canceling transaction...");
        }
    }

    public void readNCategoriesFromFile(String path, int n ) throws IOException {
        File file = new File(path);
        BufferedReader br;
        br = new BufferedReader(new FileReader(file));

        for(int i=0;i<n;i++){
            String unparsedCategoryData;
            if((unparsedCategoryData = br.readLine()) == null){return;}

            String[] categoryData = unparsedCategoryData.split("  ");
            String categoryName = categoryData[1];
            Integer categoryId = Integer.parseInt(categoryData[0]);
            Category newCategory = new Category(categoryId,categoryName);
            addCategory(newCategory);
        }
    }
    public void readNProductsFromFile(String path, int n ) throws IOException {
        File file = new File(path);
        BufferedReader br;
        br = new BufferedReader(new FileReader(file));

        for(int i=0;i<n;i++){
            boolean flag =false;
            String unparsedProductData;
            if((unparsedProductData = br.readLine()) == null){return;}

            String[] productData = unparsedProductData.replace(",","").split("  ");
            String productName = productData[1];
            Integer productId = Integer.parseInt(productData[0]);
            productData[1]="";
            productData[0]=productData[2];
            productData = productData[0].split(" ");
            CategoryList categoryList = new CategoryList();
            for (String productDatum:productData) {
                Category categoryCheck = categories.getCategory(Integer.parseInt(productDatum));
                if(categoryCheck!=null){
                    categoryList.addCategory(categoryCheck);
                }
                else{
                    flag=true;
                }
            }
            if(!flag){
                addProduct(new Product(productName,productId,categoryList));
            }
            else{
                System.out.println("Add Product ID:"+productId+" : Category not found.\nCanceling job...");
            }
        }
    }
}
