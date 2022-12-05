package com.example.app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class plantInfo extends AppCompatActivity {

    private String plantName;

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plant_info);

        plantName = getIntent().getStringExtra("PLANT_NAME");
        textView = findViewById(R.id.plantName);

        textView.setText(plantName);
    }
}