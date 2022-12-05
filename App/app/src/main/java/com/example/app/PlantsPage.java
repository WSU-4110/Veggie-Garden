package com.example.app;

import static android.graphics.Color.WHITE;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.widget.LinearLayout;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class PlantsPage extends AppCompatActivity {

    DataBase db = new DataBase(this);

    // declare vars
    Button back;

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

/**        ConstraintSet myConstraints = new ConstraintSet();
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



