package com.example.setahajofoglalas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.setahajofoglalas.databaseclasses.Reservation;
import com.example.setahajofoglalas.databaseclasses.ReservationDao;

import java.util.Date;

public class CruisesAtDate extends AppCompatActivity {
    Long millisecs;
    RadioGroup radio;
    ReservationDao dao;
    Button select;
    Button back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cruises_at_date);
        Bundle extras = getIntent().getExtras();
        millisecs = extras.getLong("date");
        radio = findViewById(R.id.radioGroup);
        select = findViewById(R.id.button);
        back = findViewById(R.id.button2);
        select.setOnClickListener(event -> reserve());
        back.setOnClickListener(event -> redirectToDate());
    }

    private void reserve(){
        Date datum = new Date(millisecs);
        int radioId = radio.getCheckedRadioButtonId();
        RadioButton rb = findViewById(radioId);
        String time = rb.getText().toString();
        dao.insert(new Reservation(datum, time));
        redirectToMain();
    }

    private void redirectToDate(){
        Intent register = new Intent(this, DateSelect.class);
        startActivity(register);

    }
    private void redirectToMain(){
        Intent register = new Intent(this, WhatToDo.class);
        startActivity(register);
    }
}