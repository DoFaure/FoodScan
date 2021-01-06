package com.fr.foodscan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.fr.foodscan.model.Product;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ProductDetailActivity extends AppCompatActivity {

    @BindView(R.id.productBrand)
    TextView mProductBrand;

    @BindView(R.id.productName)
    TextView mProductName;

    @BindView(R.id.productImage)
    ImageView mProductImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_detail);

        ButterKnife.bind(this);

        Product product = (Product) getIntent().getSerializableExtra("Product");
        System.out.println(product.toString());
        if(!product.getGeneric_name().isEmpty()) {
            mProductName.setText(product.getGeneric_name());
        }
        mProductBrand.setText(product.getBrands());
        Glide.with(this).load(product.getImage_url()).apply(new RequestOptions().override(500, 500)).into(mProductImage);

    }
}