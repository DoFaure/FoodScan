package com.fr.foodscan.model;

import com.google.gson.annotations.Expose;

import java.io.Serializable;

public class Product implements Serializable {

    @Expose
    private String generic_name;

    @Expose
    private String brands;

    @Expose
    private String image_url;

    @Expose
    private String nutriscore_grade;

    @Expose
    private String link;

    public String getGeneric_name() {
        return generic_name;
    }

    public void setGeneric_name(String generic_name) {
        this.generic_name = generic_name;
    }

    public String getBrands() {
        return brands;
    }

    public void setBrands(String brands) {
        this.brands = brands;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public String getNutriscore_grade() {
        return nutriscore_grade;
    }

    public void setNutriscore_grade(String nutriscore_grade) {
        this.nutriscore_grade = nutriscore_grade;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    @Override
    public String toString() {
        return "Product{" +
                "generic_name='" + generic_name + '\'' +
                ", brands='" + brands + '\'' +
                ", image_url='" + image_url + '\'' +
                ", nutriscore_grade='" + nutriscore_grade + '\'' +
                ", link='" + link + '\'' +
                '}';
    }
}
