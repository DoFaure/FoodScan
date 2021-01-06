package com.fr.foodscan.call;

import android.os.AsyncTask;

import com.fr.foodscan.ProductSearchService;
import com.fr.foodscan.model.Product;
import com.fr.foodscan.model.ProductSearchResult;

import java.io.IOException;

import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ProductAsyncCall extends AsyncTask<String, Void, Product> {

    @Override
    protected Product doInBackground(String... strings) {
        ProductSearchService productService = new Retrofit.Builder()
                .baseUrl(ProductSearchService.ENDPOINT)
                //convertie le json automatiquement
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ProductSearchService.class);

        Response<ProductSearchResult> productResult = null;
        try {
            productResult = productService.searchProduct(strings[0]).execute();
            System.out.println(productResult.body().getProduct());
            return productResult.body().getProduct();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


}
