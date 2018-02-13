package com.example.allanjacob.roomsql.DataBase;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

/**
 * Created by allan.jacob on 2/13/2018.
 */

@Dao
public interface ContactDao {
    @Insert
    long insertContact(ContactDetails contactDetails);
    @Query("SELECT * FROM contactdetails")
    List<ContactDetails> getAll();
}
