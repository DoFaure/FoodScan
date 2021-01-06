package com.fr.foodscan;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import butterknife.BindView;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @BindView(R.id.buttonScan)
    Button mScanButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mScanButton = findViewById(R.id.buttonScan);
        mScanButton.setOnClickListener(this);

        //ProductSearchService.INSTANCE.searchProductFromBarcode("8002270014901");

    }

    @Override
    public void onClick(View view) {
        scanBarCode();
    }

    private void scanBarCode(){

        IntentIntegrator integrator = new IntentIntegrator(this);
        integrator.setCaptureActivity(CaptureActivity.class);
        integrator.setOrientationLocked(false);
        integrator.setDesiredBarcodeFormats(IntentIntegrator.ALL_CODE_TYPES);
        integrator.initiateScan();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode,resultCode,data);
        if(result != null){
            if(result.getContents() != null){
                /*
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setMessage(result.getContents());
                builder.setTitle("Barcode scanned");

                AlertDialog dialog = builder.create();
                dialog.show();
                 */
                ProductSearchService.INSTANCE.searchProductFromBarcode(result.getContents());
            }else{
                Toast.makeText(this, "no result", Toast.LENGTH_LONG).show();
            }
        }else{
            super.onActivityResult(requestCode,resultCode,data);
        }
    }
}