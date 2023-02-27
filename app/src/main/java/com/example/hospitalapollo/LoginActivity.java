package com.example.hospitalapollo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    EditText edUsername , ePassword ;
    Button btn ;
    TextView tv ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        edUsername = findViewById(R.id.editTextLoginName);
        ePassword = findViewById(R.id.editTextLoginPassword);
        btn = findViewById(R.id.loginButton);
        tv = findViewById(R.id.textViewNewUser);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            //  startActivity(new Intent(LoginActivity.this , HomeActivity.class));
                String username = edUsername.getText().toString();
                String password = ePassword.getText().toString();
                Database db = new Database(getApplicationContext() , "healthcare" , null , 1);
                if (username.length() == 0 || password.length() == 0){
                    Toast.makeText(LoginActivity.this, "Please fill all Details ", Toast.LENGTH_SHORT).show();
                }
                else {
                    if (db.login(username , password) ==1 ){
                        Toast.makeText(LoginActivity.this, "Login Success", Toast.LENGTH_SHORT).show();
                        SharedPreferences sharedPreferences = getSharedPreferences("shared_prefs" , MODE_PRIVATE);
                        // Creating an editor object to edit or to write the file
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.putString("username" , username);
                        editor.apply();
                        startActivity(new Intent(LoginActivity.this , HomeActivity.class));
                    }
                    else {
                        Toast.makeText(LoginActivity.this, "Invalid username and password", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivity.this , RegisterActivity.class));
            }
        });
    }
}