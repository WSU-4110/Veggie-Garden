package com.example.app;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class CalendarActivity extends AppCompatActivity {

    //declare vars
    Button backToMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar_view);

        backToMain = findViewById(R.id.backToMain);

        backToMain.setOnClickListener(view -> {
            Intent intent = new Intent(view.getContext(), MainActivity.class);
            intent.putExtra("EMAIL", getIntent().getStringExtra("EMAIL"));   // stays logged in
            intent.putExtra("NEW_USER", false);                              // makes sure popup doesn't re-appear
            startActivity(intent);
        });
    }
}
