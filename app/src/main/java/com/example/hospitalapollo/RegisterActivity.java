package com.example.hospitalapollo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {
    EditText edUsername , edPassword , edConfirmPass , RegEmail;
    Button btn ;
    TextView tv ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        edUsername = findViewById(R.id.editTextFullName);
        edPassword = findViewById(R.id.editTextApppContactNumber);
        edConfirmPass = findViewById(R.id.editTextRegConsultantFees);
        RegEmail = findViewById(R.id.editTextAppAddress);
        btn = findViewById(R.id.buttonBookAppointment);
        tv = findViewById(R.id.textViewExistingUser);

        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(RegisterActivity.this , LoginActivity.class));
            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = edUsername.getText().toString();
                String password = edPassword.getText().toString();
                String confirmPassword = edConfirmPass.getText().toString();
                String email = RegEmail.getText().toString();
                Database db = new Database(getApplicationContext() , "healthcare" , null , 1);

                if (username.length() == 0 || email.length() == 0 ||  password.length() == 0 || confirmPassword.length() == 0 ){
                    Toast.makeText(RegisterActivity.this, "Please fill all Details ", Toast.LENGTH_SHORT).show();
                }
                else {
                    if (password.compareTo(confirmPassword) == 0){
                        if (IsValidInput(password)){
                            db.register(username , email , password);
                            Toast.makeText(RegisterActivity.this, "You have Registered SuccessFully", Toast.LENGTH_SHORT).show();
                        }
                        else{
                            Toast.makeText(RegisterActivity.this, "Password Must contain 8 letters more than one Lowercase letter and Uppercase Letter", Toast.LENGTH_SHORT).show();
                        }
                    }
                    else {
                        Toast.makeText(RegisterActivity.this, "Password and Confirm Password didn't match", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });
    }
    public static boolean IsValidInput(String s) {

        boolean status = false;
        char [] array = s.toCharArray();
        int lower=0, upper=0, digits=0;

        if (s.length() > 8)
            status = true;

        for ( int i = 0;  i < array.length; i++) {
            if(Character.isDigit(array[i]))
                digits++;
            if(Character.isLowerCase(array[i]))
                lower++;
            if(Character.isUpperCase(array[i]))
                upper++;
        }

        if ( !(lower  > 0 ))
            status = false;

        if ( !(upper  > 0 ))
            status = false;

        if ( !(digits > 0 ))
            status = false;

        return status;
    }
}