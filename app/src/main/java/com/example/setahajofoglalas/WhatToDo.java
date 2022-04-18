package com.example.setahajofoglalas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class WhatToDo extends AppCompatActivity {
    Button newReservation;
    Button modifyReservation;
    Button deleteReservation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_what_to_do);
        newReservation = findViewById(R.id.button3);
        modifyReservation = findViewById(R.id.button4);
        deleteReservation = findViewById(R.id.button6);
        newReservation.setOnClickListener(event -> redirectToFoglalas());
        modifyReservation.setOnClickListener(event -> redirectToChange());
        deleteReservation.setOnClickListener(event -> redirectToDelete());
    }

    public void redirectToFoglalas(){
        Intent register = new Intent(this, DateSelect.class);
        startActivity(register);
    }

    public void redirectToChange(){
        Intent register = new Intent(this, WhichToChange.class);
        startActivity(register);
    }

    public void redirectToDelete(){
        Intent register = new Intent(this, WhichToDelete.class);
        startActivity(register);
    }
}