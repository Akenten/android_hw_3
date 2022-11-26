package com.example.database;

import android.content.Context;

import androidx.room.Room;

public class DatabaseClient {

    private Context mCtx;
    private static DatabaseClient mInstance;

    private com.example.database.AppDatabase appDatabase;

    private DatabaseClient(Context mCtx){
        this.mCtx = mCtx;
        appDatabase = Room.databaseBuilder(mCtx, com.example.database.AppDatabase.class, "songs").allowMainThreadQueries().build();
    }

    public static synchronized DatabaseClient getInstance(Context mCtx){
        if (mInstance == null){
            mInstance = new DatabaseClient(mCtx);
        }
        return mInstance;
    }

    public com.example.database.AppDatabase getAppDatabase(){return appDatabase;}
}
