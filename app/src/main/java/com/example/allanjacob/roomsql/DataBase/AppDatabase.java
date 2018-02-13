package com.example.allanjacob.roomsql.DataBase;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

/**
 * Created by allan.jacob on 2/13/2018.
 */

@Database(entities = {ContactDetails.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract ContactDao contactDao();
}
