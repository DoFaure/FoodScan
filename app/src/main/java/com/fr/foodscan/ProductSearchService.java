package com.fr.foodscan;

import com.fr.foodscan.model.ProductSearchResult;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

// Service describing the REST APIs
public interface ProductSearchService {

    public static final String ENDPOINT = "https://fr.openfoodfacts.org/api/v0/";

    @GET("product/{barCode}")
    Call<ProductSearchResult> searchProduct(@Path("barCode") String search);
}

