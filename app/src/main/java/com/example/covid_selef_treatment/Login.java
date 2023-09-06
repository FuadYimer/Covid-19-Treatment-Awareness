package com.example.covid_selef_treatment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Login extends AppCompatActivity {
    TextView gotoRegister;
    EditText et_username , et_password ;
    String username , password;
    Button btn_login;
    MyDatabaseHelper myDatabaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        gotoRegister = (TextView) findViewById(R.id.gotoRegisterActivity);
        et_username  = findViewById(R.id.et_username);
        et_password = findViewById(R.id.et_password);
        btn_login = findViewById(R.id.btn_login);

        gotoRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), SignUp.class);
                startActivity(intent);
                finish(); // Distroy login screen ...
            }
        });


        myDatabaseHelper = new MyDatabaseHelper(this);
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                username = et_username.getText().toString();
                password = et_password.getText().toString();
                if (username.equals("") && password.equals(""))
                {
                    Toast.makeText(getApplicationContext(), R.string.please_insert_username_and_password, Toast.LENGTH_SHORT).show();
                }
                else {
                    int status  = Integer.parseInt(myDatabaseHelper.getLoginData(username, password));
                    if(status >0){
                        Toast.makeText(getApplicationContext(), R.string.login_successfully, Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(), activity_main.class);
                        startActivity(intent);
                        finish();
                    }
                    else{
                        Toast.makeText(getApplicationContext(), R.string.wrong_username_or_password, Toast.LENGTH_SHORT).show();

                    }
                }
            }
        });


    }
}