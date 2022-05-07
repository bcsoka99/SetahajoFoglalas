package com.example.setahajofoglalas.databaseclasses;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Date;

@Entity(tableName = "reservation")
public class Reservation {
    @PrimaryKey(autoGenerate = true)
    @NonNull
    private Integer id;
    @NonNull
    private String date;
    @NonNull
    private String startingHour;

    public Reservation(@NonNull String date, @NonNull String startingHour) {
        this.date = date;
        this.startingHour = startingHour;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date.toString();
    }

    public String getStartingHour() {
        return startingHour;
    }

    public void setStartingHour(String startingHour) {
        this.startingHour = startingHour;
    }

    @Override
    public String toString() {
        return"date=" + date + ", startingHour='" + startingHour;
    }
}
