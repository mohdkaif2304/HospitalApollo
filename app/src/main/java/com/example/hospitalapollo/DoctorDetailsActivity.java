package com.example.hospitalapollo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class DoctorDetailsActivity extends AppCompatActivity {

    private String[][] doctor_detail1  = {
            {" Doctor Name : Firdaus Jahan" ,"Hospital Address : Lucknow" ,"Exp : 15 yrs " , "Mobile No.: 9120698975", "1000"},
            {" Doctor Name :  Mohd Kaif Khan" ,"Hospital Address : Lucknow" ,"Exp : 1 yrs " , "Mobile No.: 9120698975", "10"},
            {" Doctor Name : Mohd Faizan Khan" ,"Hospital Address : Lucknow" ,"Exp : 0 yrs " , "Mobile No.: 9120698975", "11"},
            {" Doctor Name : Labeeba Khan" ,"Hospital Address : Lucknow" ,"Exp : -2 yrs " , "Mobile No.: 9120698975", "-100"},
            {" Doctor Name : Ashikun Nisha" ,"Hospital Address : Lucknow" ,"Exp : 50 yrs " , "Mobile No.: 9120698975", "1500"}
    };
    private String[][] doctor_detail2  = {
            {" Doctor Name :  Mohd Kaif Khan" ,"Hospital Address : Lucknow" ,"Exp : 1 yrs " , "Mobile No.: 9120698975", "10"},
            {" Doctor Name : Mohd Faizan Khan" ,"Hospital Address : Lucknow" ,"Exp : 0 yrs " , "Mobile No.: 9120698975", "11"},
            {" Doctor Name : Labeeba Khan" ,"Hospital Address : Lucknow" ,"Exp : -2 yrs " , "Mobile No.: 9120698975", "-100"},
            {" Doctor Name : Ashikun Nisha" ,"Hospital Address : Lucknow" ,"Exp : 50 yrs " , "Mobile No.: 9120698975", "1500"},
            {" Doctor Name : Firdaus Jahan" ,"Hospital Address : Lucknow" ,"Exp : 15 yrs " , "Mobile No.: 9120698975", "1000"}
    };
    private String[][] doctor_detail3  = {
            {" Doctor Name : Mohd Faizan Khan" ,"Hospital Address : Lucknow" ,"Exp : 0 yrs " , "Mobile No.: 9120698975", "11"},
            {" Doctor Name : Labeeba Khan" ,"Hospital Address : Lucknow" ,"Exp : -2 yrs " , "Mobile No.: 9120698975", "-100"},
            {" Doctor Name : Ashikun Nisha" ,"Hospital Address : Lucknow" ,"Exp : 50 yrs " , "Mobile No.: 9120698975", "1500"},
            {" Doctor Name : Firdaus Jahan" ,"Hospital Address : Lucknow" ,"Exp : 15 yrs " , "Mobile No.: 9120698975", "1000"},
            {" Doctor Name :  Mohd Kaif Khan" ,"Hospital Address : Lucknow" ,"Exp : 1 yrs " , "Mobile No.: 9120698975", "10"}
    };
    private String[][] doctor_detail4  = {
            {" Doctor Name : Labeeba Khan" ,"Hospital Address : Lucknow" ,"Exp : -2 yrs " , "Mobile No.: 9120698975", "-100"},
            {" Doctor Name : Ashikun Nisha" ,"Hospital Address : Lucknow" ,"Exp : 50 yrs " , "Mobile No.: 9120698975", "1500"},
            {" Doctor Name : Firdaus Jahan" ,"Hospital Address : Lucknow" ,"Exp : 15 yrs " , "Mobile No.: 9120698975", "1000"},
            {" Doctor Name :  Mohd Kaif Khan" ,"Hospital Address : Lucknow" ,"Exp : 1 yrs " , "Mobile No.: 9120698975", "10"},
            {" Doctor Name : Mohd Faizan Khan" ,"Hospital Address : Lucknow" ,"Exp : 0 yrs " , "Mobile No.: 9120698975", "11"}
    };
    private String[][] doctor_detail5  = {
            {" Doctor Name : Ashikun Nisha" ,"Hospital Address : Lucknow" ,"Exp : 50 yrs " , "Mobile No.: 9120698975", "1500"},
            {" Doctor Name : Firdaus Jahan" ,"Hospital Address : Lucknow" ,"Exp : 15 yrs " , "Mobile No.: 9120698975", "1000"},
            {" Doctor Name :  Mohd Kaif Khan" ,"Hospital Address : Lucknow" ,"Exp : 1 yrs " , "Mobile No.: 9120698975", "10"},
            {" Doctor Name : Mohd Faizan Khan" ,"Hospital Address : Lucknow" ,"Exp : 0 yrs " , "Mobile No.: 9120698975", "11"},
            {" Doctor Name : Labeeba Khan" ,"Hospital Address : Lucknow" ,"Exp : -2 yrs " , "Mobile No.: 9120698975", "-100"}
    };
    TextView tv ;
    Button btn ;
    String[][] doctor_details = {};
    ArrayList list ;
    SimpleAdapter sa ;
    HashMap<String , String> item;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_details);

        tv = findViewById(R.id.textViewDdTitle);
        btn = findViewById(R.id.buttonddBack);

        Intent it = getIntent();
        String title = it.getStringExtra("title");
        tv.setText(title);

        if ( title.compareTo("Family Physician") == 0){
            doctor_details = doctor_detail1 ;
        }
        if ( title.compareTo("Family Dietitian") == 0){
            doctor_details = doctor_detail2 ;
        }
        if ( title.compareTo("Cardiologist") == 0){
            doctor_details = doctor_detail3 ;
        }
        if ( title.compareTo("Dentist") == 0){
            doctor_details = doctor_detail4 ;
        }
        if ( title.compareTo("Family Surgeon") == 0){
            doctor_details = doctor_detail5 ;
        }
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DoctorDetailsActivity.this , FindDoctor.class));
            }
        });


        list = new ArrayList();
        for (int i = 0 ; i< doctor_details.length; i++){
          item = new HashMap<String , String>();
          item.put("line1" , doctor_details[i][0]);
          item.put("line2" , doctor_details[i][1]);
          item.put("line3" , doctor_details[i][2]);
          item.put("line4" , doctor_details[i][3]);
          item.put("line5" ,"Cons Fees:" + doctor_details[i][4] + "₹");
          list.add(item);

          sa = new SimpleAdapter(this ,list ,
                  R.layout.multi_lines ,
                  new String[]{"line1" , "line2" , "line3" , "line4" , "line5"}
                  , new int[] {R.id.linea ,R.id.lineb ,R.id.linec ,R.id.lined  ,R.id.lineE}
          );

            ListView list = findViewById(R.id.listViewDdDetails);
            list.setAdapter(sa);

            list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    Intent intent = new Intent(DoctorDetailsActivity.this , BookAppointmentActivity.class);
                    intent.putExtra("text1" , title);
                    intent.putExtra("text2" ,  doctor_details[i][0]);
                    intent.putExtra("text3" ,  doctor_details[i][1]);
                    intent.putExtra("text4" ,  doctor_details[i][3]);
                    intent.putExtra("text5" ,  doctor_details[i][4]);
                    startActivity(intent);
                }
            });

        }
    }
}