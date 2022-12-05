package com.example.app;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
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
        LinearLayout linearLayout = findViewById(R.id.linear_layout);

        back.setOnClickListener(view -> {                                     // back button actions
            Intent intent = new Intent(view.getContext(), MainActivity.class);
            intent.putExtra("EMAIL", getIntent().getStringExtra("EMAIL"));   // stays logged in
            intent.putExtra("NEW_USER", false);                              // makes sure popup doesn't re-appear
            startActivity(intent);
        });

        db = new DataBase(this);
        List<Plant> plantList = db.getPlants();                      // display list

        for (Plant plant :
                plantList) {
            PlantId newPlant = new PlantId(this, plant);                       // displays plants
            linearLayout.addView(newPlant);
        }
    }
}



