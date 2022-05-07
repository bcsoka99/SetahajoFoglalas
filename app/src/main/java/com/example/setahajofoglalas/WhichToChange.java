package com.example.setahajofoglalas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.example.setahajofoglalas.databaseclasses.Reservation;
import com.example.setahajofoglalas.databaseclasses.ReservationDao;
import com.example.setahajofoglalas.databaseclasses.ReservationRepository;

public class WhichToChange extends AppCompatActivity {
    Spinner spinner;
    ReservationRepository dao;
    Button changeButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        dao = new ReservationRepository(getApplication());
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_which_to_change);
        spinner = findViewById(R.id.spinner);
        spinner.setAdapter(
                new ArrayAdapter<>(
                        this,
                        android.R.layout.simple_list_item_1,
                        dao.getAll()
                )
        );
        changeButton = findViewById(R.id.button5);
        changeButton.setOnClickListener(event -> change());
    }

    private void change(){
        Reservation reservation = (Reservation) spinner.getSelectedItem();
        dao.delete(reservation);
        Intent register = new Intent(this, DateSelect.class);
        startActivity(register);
    }
}