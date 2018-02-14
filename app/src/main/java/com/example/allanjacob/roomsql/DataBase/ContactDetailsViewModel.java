package com.example.allanjacob.roomsql.DataBase;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;
import android.arch.paging.PagedList;

import com.example.allanjacob.roomsql.RoomApplication;

/**
 * Created by allan.jacob on 2/14/2018.
 */

public class ContactDetailsViewModel extends ViewModel {

    public LiveData<PagedList<ContactDetails>> getAllContact(){
        return RoomApplication.getInstance().getDb().contactDao().getAll()
                .create(0,new PagedList.Config.Builder()
                        .setPageSize(30).setPrefetchDistance(30).build());
    }

    public LiveData<PagedList<ContactDetails>> getFilterResult(String filterString) {
         return RoomApplication.getInstance().getDb().contactDao().getFilterResult(filterString)
                .create(0,new PagedList.Config.Builder()
                        .setPageSize(30).setPrefetchDistance(30).build());
    }
}
