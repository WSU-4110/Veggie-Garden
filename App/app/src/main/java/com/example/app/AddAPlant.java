package com.example.app;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class AddAPlant extends AppCompatActivity {

    // declare vars
    Button back, add;
    DataBase db;
    EditText bday;
    CheckBox location;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_aplant);

        // set vars
        back = findViewById(R.id.backToMain);
        add = findViewById(R.id.addPlant);
        bday = findViewById(R.id.plantBday);
        location = findViewById(R.id.location);
        final Spinner plantList = findViewById(R.id.plantList);            // dropdown menu
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
            Intent intent = new Intent(this, PlantsPage.class);
            String name = plantList.getSelectedItem().toString();
            String date = bday.getText().toString();
            String outdoors;
            if (location.isChecked()) outdoors = "It is outdoors.";
            else outdoors = "It is indoors.";

            Plant plant = new Plant(name, outdoors, date);                       // creates plant credentials, adds to database
            db.addPlant(plant);

            intent.putExtra("EMAIL", getIntent().getStringExtra("EMAIL"));   // stays logged in
            intent.putExtra("NEW_USER", false);                              // makes sure popup doesn't re-appear
            Toast.makeText(this, "Plant added!", Toast.LENGTH_SHORT).show();
            startActivity(intent);
        });

    }
}