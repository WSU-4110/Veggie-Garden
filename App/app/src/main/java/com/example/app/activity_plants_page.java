package com.example.app;

import static android.graphics.Color.GREEN;
import static android.graphics.Color.WHITE;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;

import com.example.app.PlantId;

public class activity_plants_page extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plants_page);


        LinearLayout linearLayout = findViewById(R.id.linear_layout);

//        ConstraintSet myConstraints = new ConstraintSet();
//        myConstraints.clone(myLayout);

        for (int i = 0; i < 2; i++) {
            TextView newTextView = new TextView(this);
//            newTextView.setText("View " + i);
//            newTextView.setId(View.generateViewId());
////
////            myConstraints.connect(newTextView.getId(), ConstraintSet.RIGHT, R.id.linear_layout, ConstraintSet.RIGHT, 0);
////            myConstraints.connect(newTextView.getId(), ConstraintSet.TOP, R.id.linear_layout, ConstraintSet.TOP, 0);
////
//            linearLayout.addView(newTextView);


            PlantId newPlant = new PlantId(this);
            newPlant.setPlantName("Test Plant");
            newPlant.setTextColor(Color.valueOf(WHITE));
            newPlant.setPlantBirthday("10/19/2022");

            linearLayout.addView(newPlant);

        }
    }


}
