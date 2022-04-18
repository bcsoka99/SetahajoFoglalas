package com.example.setahajofoglalas.databaseclasses;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Reservation.class}, version = 1, exportSchema = false)
public abstract class ReservationRoomDatabase extends RoomDatabase {

    public abstract ReservationDao reservationDao();

    private static ReservationRoomDatabase instance;

    public static ReservationRoomDatabase getInstance(Context context){
        if (instance == null){
            synchronized (ReservationRoomDatabase.class){
                if (instance == null){
                    instance = Room.databaseBuilder(context.getApplicationContext(),
                            ReservationRoomDatabase.class,
                            "reservation_database")
                            .fallbackToDestructiveMigration()
                            .build();
                }
            }
        }
        return instance;
    }

}
