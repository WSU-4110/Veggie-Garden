package com.example.app;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    //declare variables
    ImageButton gearButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //set variables
        gearButton = findViewById(R.id.gearButton);
        TextView textView = findViewById(R.id.textView);

        // Retrieve account information
        DataBase db = new DataBase(this);
        String name = db.getName(getIntent().getStringExtra("EMAIL"));

        gearButton.setOnClickListener(view -> {
            Intent intent = new Intent(view.getContext(), Settings.class);
            intent.putExtra("EMAIL", getIntent().getStringExtra("EMAIL"));
            startActivity(intent);
        });

        // Display user's name
        textView.setText(String.format("Hello %s", name));

    }

}