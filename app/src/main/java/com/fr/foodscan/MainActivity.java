package com.fr.foodscan;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.fr.foodscan.call.ProductAsyncCall;
import com.fr.foodscan.model.Product;
import com.fr.foodscan.model.ProductSearchResult;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import java.io.IOException;
import java.io.Serializable;
import java.util.concurrent.ExecutionException;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @BindView(R.id.buttonScan)
    Button mScanButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mScanButton.setOnClickListener(this);
    }

    //Methode appelé lorsque que l'on appuis sur le boutton SCAN PRODUCT
    @Override
    public void onClick(View view) {
        scanBarCode();
    }

    //Methode permettant de lancer l'activite de scan (CaptureActivity)
    private void scanBarCode() {

        IntentIntegrator integrator = new IntentIntegrator(this);
        integrator.setCaptureActivity(CaptureActivity.class);
        integrator.setOrientationLocked(false);
        integrator.setDesiredBarcodeFormats(IntentIntegrator.ALL_CODE_TYPES);
        integrator.setPrompt("Placez un code-barre dans le rectangle pour le scanner");
        integrator.initiateScan();

    }

    //Si le scan reussi
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if (result != null) {
            if (result.getContents() != null) {


                //Appel Asynchrone à l'API
                AsyncTask<String, Void, Product> asyncTaskProduct = new ProductAsyncCall().execute(result.getContents());
                try {
                    Product product = asyncTaskProduct.get();
                    System.out.println(product.toString());

                    //Affiche les details des produits dans une nouvelle activité
                    Intent intentDetailActivity = new Intent(this, ProductDetailActivity.class);
                    intentDetailActivity.putExtra("Product", product);
                    startActivity(intentDetailActivity);

                } catch (ExecutionException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            } else {
                Toast.makeText(this, "no result", Toast.LENGTH_LONG).show();
            }
        } else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }


}