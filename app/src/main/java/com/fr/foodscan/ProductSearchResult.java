package com.fr.foodscan;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ProductSearchResult {

    @Expose
    private Product product;

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
