package com.example.app;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class Settings extends AppCompatActivity {

    //declare variables
    Button backToMain;

    ArrayList<RecyclerViewSettings> recyclerViewSettings = new ArrayList<>();         // array for texts in recycler view


    @SuppressLint({"MissingInflatedId", "WrongViewCast"})    // suppresses incorrect error messages
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);        // declare layout

        //set variables
        backToMain = findViewById(R.id.backToMain);      // declare back button

        backToMain.setOnClickListener(view -> {                                     // back button actions
            Intent intent = new Intent(view.getContext(), MainActivity.class);
            intent.putExtra("EMAIL", getIntent().getStringExtra("EMAIL"));   // stays logged in
            intent.putExtra("NEW_USER", false);                              // makes sure popup doesn't re-appear
            startActivity(intent);
        });
    }
}