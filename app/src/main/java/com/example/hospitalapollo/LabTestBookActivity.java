package com.example.hospitalapollo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LabTestBookActivity extends AppCompatActivity {
EditText edName , edAddress , edPincode , edNumber ;
Button btnBooking ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab_test_book);

        edName = findViewById(R.id.FullNameLabTextBook);
        edAddress = findViewById(R.id.LabTestBookAddress);
        edPincode = findViewById(R.id.LabTestBookPinCode);
        edNumber = findViewById(R.id.LabTestBookContact_Number);
        btnBooking = findViewById(R.id.buttonLabTestBookBtn);

        Intent intent = getIntent();
        String[]price = intent.getStringExtra("price").toString().split(java.util.regex.Pattern.quote(":"));
        String date = intent.getStringExtra("date");
        String time = intent.getStringExtra("time");

        btnBooking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sharedPreferences = getSharedPreferences("shared_prefs" , Context.MODE_PRIVATE);
                String username = sharedPreferences.getString("username" ,"").toString();
                Database db = new Database(getApplicationContext(), "healthcare" , null , 1);
                db.addOrder(username , edName.getText().toString(), edAddress.getText().toString(), edNumber.getText().toString(),Integer.parseInt(edPincode.getText().toString()), date.toString(), time.toString(),Float.parseFloat(price[1].toString()), "lab");
                db.removeCart(username , "lab");
                Toast.makeText(LabTestBookActivity.this, "Your Booking is Done Successfully", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(LabTestBookActivity.this ,HomeActivity.class));
            }
        });
    }
}