package com.example.setahajofoglalas;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
EditText userName;
EditText password;
Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        userName = findViewById(R.id.UserName);
        password = findViewById(R.id.Password);
        button = findViewById(R.id.register);
        button.setOnClickListener(event -> registerRedirect());
    }

    public void logIn(){

        String userNameTxt = userName.getText().toString();
        String passwodTxt = password.getText().toString();
    }

    public void registerRedirect(){
        Intent register = new Intent(this, ResgisterActivity.class);

        startActivity(register);
    }
}
