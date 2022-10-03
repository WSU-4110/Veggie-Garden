package com.example.app;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;

import java.util.List;

public class activity_plants_page extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plants_page);

        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.linear_layout);
        ConstraintLayout myLayout = (ConstraintLayout) findViewById(R.id.constraint_layout);
        ConstraintSet myConstraints = new ConstraintSet();
        myConstraints.clone(myLayout);

        for (int i = 0; i < 5; i++) {
            TextView newTextView = new TextView(this);
            newTextView.setText("View " + i);
            newTextView.setId(View.generateViewId());

            myConstraints.connect(newTextView.getId(), ConstraintSet.RIGHT, R.id.linear_layout, ConstraintSet.RIGHT, 0);
            myConstraints.connect(newTextView.getId(), ConstraintSet.TOP, R.id.linear_layout, ConstraintSet.TOP, 0);

            linearLayout.addView(newTextView);
        }
    }


}
