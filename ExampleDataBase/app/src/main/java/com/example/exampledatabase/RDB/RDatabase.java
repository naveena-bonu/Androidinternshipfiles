package com.example.exampledatabase.RDB;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;


@Database(entities = {RTable.class}, version = 1,exportSchema = false)
//entities -table
//when we migrate data in instance



public abstract class RDatabase extends RoomDatabase {

    public  abstract DAO rDao(); //abstract class so we need live data. no need oncreate if any update or deletion of data is there. Dat instantly syncronises
    public static RDatabase rDatabase;

    public static synchronized RDatabase getrDatabase(Context context) {
        if (rDatabase == null) {
            rDatabase = Room.databaseBuilder(context, RDatabase.class, "MYROOM")
                    .allowMainThreadQueries()
                    .build();
        }
        return rDatabase;

    }



}
