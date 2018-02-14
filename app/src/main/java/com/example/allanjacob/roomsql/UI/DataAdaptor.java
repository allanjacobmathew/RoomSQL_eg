package com.example.allanjacob.roomsql.UI;

import android.arch.paging.PagedListAdapter;
import android.support.annotation.NonNull;
import android.support.v7.recyclerview.extensions.DiffCallback;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.example.allanjacob.roomsql.DataBase.ContactDetails;
import com.example.allanjacob.roomsql.R;

import java.util.List;

/**
 * Created by aduser on 2/12/2018.
 */

public class DataAdaptor extends PagedListAdapter<ContactDetails,DataAdaptor.MyViewHolder> {

    private static DiffCallback<ContactDetails> DIFF_CALLBACK = new DiffCallback<ContactDetails>() {
        @Override
        public boolean areItemsTheSame(@NonNull ContactDetails oldItem, @NonNull ContactDetails newItem) {
            return oldItem.getId() == newItem.getId();
        }

        @Override
        public boolean areContentsTheSame(@NonNull ContactDetails oldItem, @NonNull ContactDetails newItem) {
            return oldItem.equals(newItem);
        }
    };
    protected DataAdaptor() {
        super(DIFF_CALLBACK);
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.data_row, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        ContactDetails dataClass = getItem(position);
        holder.name_id.setText(dataClass.getName());
        holder.phone_id.setText(dataClass.getMobile());

    }





    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView name_id,phone_id;

        public MyViewHolder(View view) {
            super(view);
            name_id = view.findViewById(R.id.name_id);
            phone_id = view.findViewById(R.id.phone_id);
        }

    }
}
