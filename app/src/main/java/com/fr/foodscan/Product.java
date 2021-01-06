package com.fr.foodscan;

import com.google.gson.annotations.Expose;

public class Product {

    @Expose
    private String product_name_fr;

    public String getProduct_name_fr() {
        return product_name_fr;
    }

    public void setProduct_name_fr(String product_name_fr) {
        this.product_name_fr = product_name_fr;
    }
}
