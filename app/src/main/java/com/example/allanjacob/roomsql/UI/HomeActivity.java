package com.example.allanjacob.roomsql.UI;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.arch.paging.PagedList;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatEditText;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;

import com.example.allanjacob.roomsql.DataBase.ContactDetails;
import com.example.allanjacob.roomsql.DataBase.ContactDetailsViewModel;
import com.example.allanjacob.roomsql.R;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity implements Observer<PagedList<ContactDetails>>, TextWatcher {
    private List<ContactDetails> dataList = new ArrayList<>();
    private RecyclerView recyclerView;
    private AppCompatEditText mSearchAppCompatEditText;
    private DataAdaptor mAdapter;
    private ContactDetailsViewModel contactDetailsViewModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


        recyclerView =findViewById(R.id.recycle_id);
        mSearchAppCompatEditText =findViewById(R.id.serachEditText);

        mSearchAppCompatEditText.addTextChangedListener(this);

        mAdapter = new DataAdaptor();
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);
        contactDetailsViewModel = ViewModelProviders.of(this).get(ContactDetailsViewModel.class);

        contactDetailsViewModel.getAllContact().observeForever(this);


    }

    private void dummydata() {

//        mAdapter.notifyDataSetChanged();


}

    @Override
    public void onChanged(@Nullable PagedList<ContactDetails> contactDetails) {
        //Toast.makeText(this, contactDetails.get(0).getName(), Toast.LENGTH_SHORT).show();
        mAdapter.setList(contactDetails);
    }


    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        StringBuilder builder = new StringBuilder();
        builder.append("%").append(charSequence.toString()).append("%");
        contactDetailsViewModel.getFilterResult(builder.toString()).observe(HomeActivity.this,HomeActivity.this);

    }

    @Override
    public void afterTextChanged(Editable editable) {

    }
}
