package com.example.app;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.card.MaterialCardView;

import java.util.List;

public class PlantsPage extends AppCompatActivity {

    // declare vars
    Button back;
    DataBase db;

    @SuppressLint("MissingInflatedId")
    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plants_page);

        // set vars
        back = findViewById(R.id.backToMain);
        LinearLayout root = findViewById(R.id.linear_layout);

        back.setOnClickListener(view -> {                                     // back button actions
            Intent intent = new Intent(view.getContext(), MainActivity.class);
            intent.putExtra("EMAIL", getIntent().getStringExtra("EMAIL"));   // stays logged in
            intent.putExtra("NEW_USER", false);                              // makes sure popup doesn't re-appear
            startActivity(intent);
        });

        db = new DataBase(this);
        List<Plant> plantList = db.getPlants();                                 // display list

        for (Plant plant :
                plantList) {
            MaterialCardView cardView = new MaterialCardView(this);
            MaterialCardView.LayoutParams layoutParams = new MaterialCardView.LayoutParams(
                    ViewGroup.LayoutParams.WRAP_CONTENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT
            );

            layoutParams.setMargins(10, 20, 10, 10);

            PlantId newPlant = new PlantId(this, plant);                       // displays plants
            newPlant.setOnClickListener(view -> {
                Intent intent = new Intent(this, plantInfo.class);
                intent.putExtra("EMAIL", getIntent().getStringExtra("EMAIL"));
                intent.putExtra("PLANT_NAME", plant.getName());
                startActivity(intent);
            });
            cardView.addView(newPlant);
            cardView.setLayoutParams(layoutParams);
            cardView.setPadding(10, 10, 10, 10);
            cardView.setCardBackgroundColor(Color.WHITE);
            cardView.setRadius(100);


            root.addView(cardView);
        }
    }
}



