package com.example.hospitalapollo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class FindDoctor extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_doctor);

        CardView fdBack = findViewById(R.id.FdCardBack);
        fdBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               startActivity(new Intent(FindDoctor.this , HomeActivity.class));
            }
        });

        CardView familyPhysician = findViewById(R.id.cardFamilyPhysician);
        familyPhysician.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FindDoctor.this , DoctorDetailsActivity.class);
                intent.putExtra("title" , "Family Physician");
                startActivity(intent);
            }
        });
        CardView dietician = findViewById(R.id.cardFamilyDietician);
       dietician.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FindDoctor.this , DoctorDetailsActivity.class);
                intent.putExtra("title" , "Family Dietitian");
                startActivity(intent);
            }
        });

        CardView surgeon = findViewById(R.id.FamilySurgeon);
        surgeon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FindDoctor.this , DoctorDetailsActivity.class);
                intent.putExtra("title" , "Family Surgeon");
                startActivity(intent);
            }
        });
        CardView cardioLogist = findViewById(R.id.cardiologist);
        cardioLogist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FindDoctor.this , DoctorDetailsActivity.class);
                intent.putExtra("title" , "Cardiologist");
                startActivity(intent);
            }
        });

        CardView dentist = findViewById(R.id.dentist);
        dentist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FindDoctor.this , DoctorDetailsActivity.class);
                intent.putExtra("title" , "Dentist");
                startActivity(intent);
            }
        });
    }
}