package com.example.app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class plantInfo extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        String plantName;
        TextView textView;
        FloatingActionButton delete;
        Button back;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plant_info);

        DataBase db = new DataBase(this);

        Plant plant = db.getPlant(getIntent().getStringExtra("PLANT_NAME"));
        textView = findViewById(R.id.plantName);
        back = findViewById(R.id.backToPlants);
        delete = findViewById(R.id.delete);

        textView.setText(String.format("Name: %s\nType: %s\nBirthday: %s", plant.getName(), plant.getType(), plant.getBday()));

        back.setOnClickListener(view -> {
            Intent intent = new Intent(this, PlantsPage.class);
            intent.putExtra("EMAIL", getIntent().getStringExtra("EMAIL"));
            startActivity(intent);

        });

        delete.setOnClickListener(view -> {
            Intent intent = new Intent(this, PlantsPage.class);
            intent.putExtra("EMAIL", getIntent().getStringExtra("EMAIL"));

            db.deleteOne(plant);
            startActivity(intent);
        });

    }
}