package com.example.setahajofoglalas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.example.setahajofoglalas.databaseclasses.Reservation;
import com.example.setahajofoglalas.databaseclasses.ReservationDao;
import com.example.setahajofoglalas.databaseclasses.ReservationRepository;

import java.util.ArrayList;
import java.util.List;

public class WhichToDelete extends AppCompatActivity {
    Spinner spinner;
    ReservationRepository dao;
    Button deleteButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        dao = new ReservationRepository(getApplication());
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_which_to_delete);
        spinner = findViewById(R.id.spinner2);
        spinner.setAdapter(
                new ArrayAdapter<>(
                        this,
                        android.R.layout.simple_list_item_1,
                        dao.getAll()
                )
        );
        deleteButton = findViewById(R.id.button7);
        deleteButton.setOnClickListener(event -> delete());
    }

    private void delete(){
        Reservation reservation = (Reservation) spinner.getSelectedItem();
        dao.delete(reservation);
        Intent register = new Intent(this, WhatToDo.class);
        startActivity(register);
    }

}