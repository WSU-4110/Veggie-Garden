package com.example.app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class plantInfo extends AppCompatActivity {

    String plantName;
    TextView textView;
    Button back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plant_info);

        plantName = getIntent().getStringExtra("PLANT_NAME");
        textView = findViewById(R.id.plantName);
        back = findViewById(R.id.backToPlants);

        textView.setText(plantName);

        back.setOnClickListener(view -> {
            Intent intent = new Intent(this, PlantsPage.class);
            intent.putExtra("EMAIL", getIntent().getStringExtra("EMAIL"));
            startActivity(intent);

        });

    }
}