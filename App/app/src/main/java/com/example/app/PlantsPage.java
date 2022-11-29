package com.example.app;

import static android.graphics.Color.WHITE;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.widget.Button;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

public class PlantsPage extends AppCompatActivity {

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

            PlantId newPlant = new PlantId(this);
            newPlant.setPlantName("Test Plant");
            newPlant.setTextColor(Color.valueOf(WHITE));
            newPlant.setPlantBirthday("10/19/2022");

            //linearLayout.addView(newPlant);

        }
    }



