package com.example.setahajofoglalas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CalendarView;

public class DateSelect extends AppCompatActivity {
    Button dateSelected;
    CalendarView calendar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date_select);
        calendar = findViewById(R.id.calendarView);
        dateSelected = findViewById(R.id.DateSelected);
        dateSelected.setOnClickListener(event -> redirectToTimeChange());


    }

    public void redirectToTimeChange(){
        Long millisecs = calendar.getDate();
        Intent register = new Intent(this, CruisesAtDate.class);
        register.putExtra("date", millisecs);
        startActivity(register);
    }
}