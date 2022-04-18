package com.example.setahajofoglalas;

import static android.content.ContentValues.TAG;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {
EditText userName;
EditText password;
Button button;
Button logIn;

private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        userName = findViewById(R.id.UserName);
        password = findViewById(R.id.Password);
        button = findViewById(R.id.register);
        button.setOnClickListener(event -> registerRedirect());
        auth = FirebaseAuth.getInstance();
        logIn = findViewById(R.id.logIn);
        logIn.setOnClickListener(event -> logIn());
    }

    public void logIn(){
        String userNameTxt = userName.getText().toString();
        String passwodTxt = password.getText().toString();
        auth.signInWithEmailAndPassword(userNameTxt, passwodTxt).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    Log.d(TAG, "Succesfully Signed In");
                    FirebaseUser user = auth.getCurrentUser();
                    redirectToMain();
                } else {
                    Log.w(TAG, "Unsuccesful Sign In", task.getException());
                }
            }
        });
    }

    public void registerRedirect(){
        Intent register = new Intent(this, ResgisterActivity.class);
        startActivity(register);
    }

    public void redirectToMain(){
        Intent register = new Intent(this, WhatToDo.class);
        startActivity(register);
    }
}
