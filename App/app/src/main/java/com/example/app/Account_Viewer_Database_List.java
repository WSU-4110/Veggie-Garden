package com.example.app;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.List;

public class Account_Viewer_Database_List extends AppCompatActivity {

    //declare variables
    ImageButton backArrow2;

    @SuppressLint({"WrongViewCast", "MissingInflatedId"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_viewer_database_list);

        //set variables
        backArrow2 = findViewById(R.id.backArrow2);

        backArrow2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), Settings.class);
                startActivity(intent);
            }
        });

        DataBase dataBase = new DataBase(Account_Viewer_Database_List.this);
        List<Credentials> all = dataBase.getAll();
        Toast.makeText(Account_Viewer_Database_List.this, all.toString(), Toast.LENGTH_SHORT).show();


    }
}