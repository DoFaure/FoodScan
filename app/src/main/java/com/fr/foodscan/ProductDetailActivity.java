package com.fr.foodscan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.fr.foodscan.model.Product;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ProductDetailActivity extends AppCompatActivity{

    @BindView(R.id.buttonScanNewProduct)
    Button mScanButton;

    @BindView(R.id.productBrand)
    TextView mProductBrand;

    @BindView(R.id.productName)
    TextView mProductName;

    @BindView(R.id.productImage)
    ImageView mProductImage;

    @BindView(R.id.caracteristique)
    TextView mCaracteristique;

    @BindView(R.id.score)
    TextView mScore;

    @BindView(R.id.ingredientList)
    TextView mIngredients;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_detail);

        ButterKnife.bind(this);
        mCaracteristique.setTypeface(null, Typeface.BOLD);
        Product product = (Product) getIntent().getSerializableExtra("Product");
        if(product.getGeneric_name() != null && !product.getGeneric_name().isEmpty()) {
            mProductName.setText(product.getGeneric_name());
        }else{
            mProductName.setText(product.getProduct_name());
        }
        if(product.getBrands()!= null && !product.getBrands().isEmpty()) {
            mProductBrand.setText(product.getBrands().toUpperCase());
        }
        mIngredients.setText(product.getIngredients_text());

        if(product.getNutriscore_grade()!= null && !product.getNutriscore_grade().isEmpty()) {
            mScore.setText(product.getNutriscore_grade().toUpperCase());
        }

        mIngredients.setTypeface(null, Typeface.ITALIC);
        mScore.setTypeface(null, Typeface.ITALIC);
        Glide.with(this).load(product.getImage_url()).apply(new RequestOptions().override(500, 500)).into(mProductImage);

        mScanButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                finish();
            }
        });

    }
}