package com.fr.foodscan.model;

import com.google.gson.annotations.Expose;

public class ProductSearchResult {

    @Expose
    private Product product;

    public Product getProduct() {
        return product;
    }

}
