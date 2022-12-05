package com.example.app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

public class AddAPlant extends AppCompatActivity {

    // declare vars
    Button back, add;
    Spinner plantList;
    DataBase db;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_aplant);

        // set vars
        back = findViewById(R.id.backToMain);
        add = findViewById(R.id.addPlant);
        plantList = findViewById(R.id.plantList);
        db = new DataBase(this);

        // set array adapter
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.listOfPlants, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        plantList.setAdapter(adapter);

        back.setOnClickListener(view -> {
            Intent intent = new Intent(this, MainActivity.class);
            intent.putExtra("EMAIL", getIntent().getStringExtra("EMAIL"));   // stays logged in
            intent.putExtra("NEW_USER", false);                              // makes sure popup doesn't re-appear
            startActivity(intent);
        });

        add.setOnClickListener(view -> {
            Intent intent = new Intent(this, MainActivity.class);
            // add database stuff here ___________________________________________________________________________
            intent.putExtra("EMAIL", getIntent().getStringExtra("EMAIL"));   // stays logged in
            intent.putExtra("NEW_USER", false);                              // makes sure popup doesn't re-appear
            Toast.makeText(this, "Plant added!", Toast.LENGTH_SHORT).show();
            startActivity(intent);
        });

    }
}