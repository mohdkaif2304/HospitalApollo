package com.example.hospitalapollo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;

public class LabTestActivity extends AppCompatActivity {

    private String[][] packages = {
            {"Package 1 : Full Body Checkup" , "" , "" , "", "999"},
            {"Package 2 : Full Body Blood Glucose Fasting" , "" , "" , "", "599"},
            {"Package 3 : COVID- 19 AntiBody - IgG" , "" , "" , "", "399"},
            {"Package 4 : Thyroid Check" , "" , "" , "", "500"},
            {"Package 5 : Immunity Check " , "" , "" , "", "300"}
    };
    private String[] package_details = {
         "Blood Glucose fasting \n" +
         "Complete Homogram \n"+
         "HbA1c \n" +
         "Iron Studies \n" +
                 "Kidney Function Test \n" +
         "LDH lactate Dehydrogenase , Serum \n" +
         "Lipid Profile \n" +
         "Liver Function Test \n" ,
         "Blood glucose fasting \n" ,
          "COVID - 19 Antibody IgG \n" ,
           "Thyroid Profile-Total(T3, T4 , & TSH Ultra - sensitive)" ,
           "Complete Hemogram \n" +
                   "CRP (C Reactive Protein ) Quantitive ,Serum \n" +
                   "Iron Studies \n" +
                   "Kidney Function Test \n" +
                   "Vitamin D Total-25 Hydroxy\n"+
                   "Lipid Profile \n" +
                   "Liver Function Test \n"

    };

    HashMap<String , String> item  ;
    ArrayList list ;
    SimpleAdapter sa ;
    Button btnGoToCart , btnBack ;
    ListView listView ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab_test);

        btnGoToCart = findViewById(R.id.buttonLtGoToCart);
        btnBack = findViewById(R.id.buttonLtBack);
        listView = findViewById(R.id.listViewLabTest);

        list = new ArrayList();
        for (int i = 0 ; i< packages.length; i++) {
            item = new HashMap<String, String>();
            item.put("line1", packages[i][0]);
            item.put("line2", packages[i][1]);
            item.put("line3", packages[i][2]);
            item.put("line4", packages[i][3]);
            item.put("line5", "Cons Fees:" + packages[i][4] + "₹");
            list.add(item);

        }   sa = new SimpleAdapter(this ,list ,
                    R.layout.multi_lines ,
                    new String[]{"line1" , "line2" , "line3" , "line4" , "line5"}
                    , new int[] {R.id.linea ,R.id.lineb ,R.id.linec ,R.id.lined  ,R.id.lineE}
            );
        listView.setAdapter(sa);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Intent intent = new Intent(LabTestActivity.this , LabTestDetailsactivity.class);
                intent.putExtra("text1", packages[i][0]);
                intent.putExtra("text2" ,  package_details[i]);
                intent.putExtra("text3" , packages [i][4]);
                startActivity(intent);
            }
        });
        btnGoToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LabTestActivity.this , CartLabActivity.class));
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LabTestActivity.this , HomeActivity.class));
            }
        });
    }
}