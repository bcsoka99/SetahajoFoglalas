package com.example.setahajofoglalas.databaseclasses;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

public class ReservationRepository {
    private ReservationDao dao;

    ReservationRepository(Application application){
        ReservationRoomDatabase db = ReservationRoomDatabase.getInstance(application);
        dao = db.reservationDao();
    }

    public List<Reservation> getAll(){
        return dao.getAll();
    }

    public void delete(Reservation reservation){
        dao.delete(reservation);
    }

    public void insert(Reservation reservation){
        dao.insert(reservation);
    }
}
