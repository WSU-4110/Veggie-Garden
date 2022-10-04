package com.example.app;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
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

        backToSettings.setOnClickListener(view -> {
            Intent intent = new Intent(view.getContext(), Settings.class);
            intent.putExtra("EMAIL", getIntent().getStringExtra("EMAIL"));
            startActivity(intent);
        });

        DataBase db = new DataBase(Account_Viewer_Database_List.this);
        List<Credentials> all = db.getAll();
        ArrayAdapter<Credentials> arrayAdapter = new ArrayAdapter<>(Account_Viewer_Database_List.this, android.R.layout.simple_list_item_1, all);
        lv_credentials.setAdapter(arrayAdapter);

    }
}