package com.example.app;

import static android.graphics.Color.WHITE;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.widget.LinearLayout;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class PlantsPage extends AppCompatActivity {

    DataBase db = new DataBase(this);

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plants_page);


        LinearLayout linearLayout = findViewById(R.id.linear_layout);

/**
 ConstraintSet myConstraints = new ConstraintSet();
 myConstraints.clone(myLayout);

 for (int i = 0; i < 8; i++) {
 TextView newTextView = new TextView(this);
 newTextView.setText("View " + i);
 newTextView.setId(View.generateViewId());

 myConstraints.connect(newTextView.getId(), ConstraintSet.RIGHT, R.id.linear_layout, ConstraintSet.RIGHT, 0);
 myConstraints.connect(newTextView.getId(), ConstraintSet.TOP, R.id.linear_layout, ConstraintSet.TOP, 0);

 linearLayout.addView(newTextView);}
 **/

        List<Plant> plantList = db.getPlants();

        for (Plant plant :
                plantList) {
            PlantId newPlant = new PlantId(this, plant);
            linearLayout.addView(newPlant);
        }
    }
}



