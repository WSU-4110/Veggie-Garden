package com.example.app;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

public class Account_Viewer_Database_List extends AppCompatActivity {

    //declare variables
    Button backToSettings;
    ListView lv_credentials;

    @SuppressLint({"WrongViewCast", "MissingInflatedId"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_viewer_database_list);

        //set variables
        backToSettings = findViewById(R.id.backToSettings);
        lv_credentials = findViewById(R.id.lv_credentials);

        backToSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), Settings.class);
                startActivity(intent);
            }
        });

        DataBase dataBase = new DataBase(Account_Viewer_Database_List.this);
        List<Credentials> all = dataBase.getAll();
        ArrayAdapter arrayAdapter = new ArrayAdapter<Credentials>(Account_Viewer_Database_List.this, android.R.layout.simple_list_item_1, all);
        lv_credentials.setAdapter(arrayAdapter);

    }
}