package com.example.setahajofoglalas.databaseclasses;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import java.util.Date;

@Database(entities = {Reservation.class}, version = 1, exportSchema = false)
public abstract class ReservationRoomDatabase extends RoomDatabase {

    public abstract ReservationDao reservationDao();

    private static ReservationRoomDatabase instance;

    public static ReservationRoomDatabase getInstance(Context context) {
        if (instance == null) {
            synchronized (ReservationRoomDatabase.class) {
                if (instance == null) {
                    instance = Room.databaseBuilder(context.getApplicationContext(),
                            ReservationRoomDatabase.class,
                            "reservation")
                            .fallbackToDestructiveMigration()
                            .addCallback(populate)
                            .allowMainThreadQueries()
                            .build();
                }
            }
        }
        return instance;
    }

    private static RoomDatabase.Callback populate = new RoomDatabase.Callback(){
        public void onOpen(@NonNull SupportSQLiteDatabase db){
            new InitDb(instance).execute();
        }
    };

    private static class InitDb extends AsyncTask<Void, Void, Void>{
        private ReservationDao dao;

        InitDb(ReservationRoomDatabase db){
            this.dao = db.reservationDao();
        }

        @Override
        protected Void doInBackground(Void ... voids){
            this.dao.deleteAll();
            return null;
        }

    }

}
