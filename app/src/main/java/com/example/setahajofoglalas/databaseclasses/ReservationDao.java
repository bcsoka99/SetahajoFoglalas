package com.example.setahajofoglalas.databaseclasses;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface ReservationDao {

    @Insert
    void insert(Reservation reservation);

    @Delete
    void delete(Reservation reservation);

    @Query("SELECT * from reservation")
    List<Reservation> getAll();

    @Query("SELECT * from reservation where id = :id ")
    Reservation findOne(Integer id);

}
