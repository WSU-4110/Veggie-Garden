package com.example.app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class plantInfo extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        String plantName;
        TextView textView;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plant_info);

        DataBase db = new DataBase(this);

        Plant plant = db.getPlant(getIntent().getStringExtra("PLANT_NAME"));
        textView = findViewById(R.id.plant_name);
        Button back = findViewById(R.id.backToPlants);



        textView.setText(String.format("Name: %s\nType: %s\nBirthday: %s", plant.getName(), plant.getType(), plant.getBday()));



        back.setOnClickListener(view -> {
            Intent intent = new Intent(this, PlantsPage.class);
            intent.putExtra("EMAIL", getIntent().getStringExtra("EMAIL"));
            startActivity(intent);

        });

    }
}