package com.example.app;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class DeleteAccountPage extends AppCompatActivity {

    // declare vars
    Button sure, nevermind;
    DataBase db;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_account_page);

        sure = findViewById(R.id.are_you_sure);
        nevermind = findViewById(R.id.nevermind);
        db = new DataBase(this);

        sure.setOnClickListener(view -> {
                Intent intent = new Intent(this, TitlePage.class);
                String x = getIntent().getStringExtra("EMAIL");
                Credentials deleting = new Credentials("NAME", x, "PASSWORD");
                db.deleteUser(deleting);
                startActivity(intent);
        });

        nevermind.setOnClickListener(view -> {
            Intent intent = new Intent(this, Settings.class);
            startActivity(intent);
        });
    }




}