package com.example.app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import java.util.List;

public class Account_Viewer_Database_List extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_viewer_database_list);

        DataBase dataBase = new DataBase(Account_Viewer_Database_List.this);
        List<Credentials> all = dataBase.getAll();
        Toast.makeText(Account_Viewer_Database_List.this, all.toString(), Toast.LENGTH_SHORT).show();


    }
}