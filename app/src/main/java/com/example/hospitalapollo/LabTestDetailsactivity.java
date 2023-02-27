package com.example.hospitalapollo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LabTestDetailsactivity extends AppCompatActivity {
TextView tvPackageName , TvTotalCost ;
EditText edDetails  ;
Button btnaddToCart , btnBack ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab_test_detailsactivity);

        tvPackageName = findViewById(R.id.textViewPackageLabDetailsActivity);
        TvTotalCost = findViewById(R.id.textViewCostLabDetailsActivity);
        edDetails = findViewById(R.id.editTextLCartMultiline);
        btnaddToCart = findViewById(R.id.buttonLtDetailsActivityAddToCart);
        btnBack = findViewById(R.id.buttonLtDetailsActivityBack);

         edDetails.setKeyListener(null);

        Intent intent = getIntent();
        tvPackageName.setText(intent.getStringExtra("text1"));
        edDetails.setText(intent.getStringExtra("text2"));
         TvTotalCost.setText("Total Cost :" + intent.getStringExtra("text3" ) + "₹");

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LabTestDetailsactivity.this , HomeActivity.class));
            }
        });

        btnaddToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sharedPreferences = getSharedPreferences("shred_prefs" , Context.MODE_PRIVATE);
                String  username = sharedPreferences.getString("username" , "").toString();
                String product = tvPackageName.getText().toString();
                float price = Float.parseFloat(intent.getStringExtra("text3").toString());

                Database db = new Database(getApplicationContext(), "healthcare" , null , 1);

                if (db.checkCart(username , product) == 1){
                    Toast.makeText(LabTestDetailsactivity.this, "Product Already Added", Toast.LENGTH_SHORT).show();
                }
                else {
                    db.addToCart(username , product , price , "lab");
                    Toast.makeText(LabTestDetailsactivity.this, "Record Inserted to Cart", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(LabTestDetailsactivity.this , LabTestActivity.class));
                }
            }
        });

    }
}