package com.example.allanjacob.roomsql;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.allanjacob.roomsql.DataBase.ContactDao;
import com.example.allanjacob.roomsql.DataBase.ContactDetails;

public class MainActivity extends AppCompatActivity {
    Button add,view;
    EditText nameid,phoneid;
    private String name;
    private String phone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nameid=findViewById(R.id.name_id);
        phoneid=findViewById(R.id.phone_id);
        add=findViewById(R.id.add_id);
        view=findViewById(R.id.view_id);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name=nameid.getText().toString();
                phone=phoneid.getText().toString();
                dummyInsert();

            }
        });
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i= new Intent(MainActivity.this,HomeActivity.class);
                startActivity(i);
            }
        });


    }

    private void dummyInsert() {
        ContactDetails details = new ContactDetails();

        details.setName(name);
        details.setMobile(phone);

        long l = RoomApplication.getInstance().getDb().contactDao().insertContact(details);


        Toast.makeText(this, "" + l, Toast.LENGTH_SHORT).show();


    }
}
