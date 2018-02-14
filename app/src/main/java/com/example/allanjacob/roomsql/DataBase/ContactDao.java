package com.example.allanjacob.roomsql.DataBase;

import android.arch.paging.LivePagedListProvider;
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
    LivePagedListProvider<Integer, ContactDetails> getAll();

    @Query("SELECT * FROM contactdetails WHERE name LIKE :filterString")
    LivePagedListProvider<Integer, ContactDetails> getFilterResult(String filterString);
}
