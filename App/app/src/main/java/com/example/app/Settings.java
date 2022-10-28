package com.example.app;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class Settings extends AppCompatActivity {

    //declare variables
    Button backToMain;

    ArrayList<RecyclerViewSettings> recyclerViewSettings = new ArrayList<>();         // array for texts in recycler view
    int[] recyclerImages = {R.drawable.forward};


    @SuppressLint({"MissingInflatedId", "WrongViewCast"})    // suppresses incorrect error messages
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);        // declare layout
        RecycleModels();

        //set variables
        backToMain = findViewById(R.id.backToMain);      // declare back button

        backToMain.setOnClickListener(view -> {                                     // back button actions
            Intent intent = new Intent(view.getContext(), MainActivity.class);
            intent.putExtra("EMAIL", getIntent().getStringExtra("EMAIL"));   // stays logged in
            intent.putExtra("NEW_USER", false);                              // makes sure popup doesn't re-appear
            startActivity(intent);
        });
    }

    private void RecycleModels() {                                                    // method for displaying full string array in recycler view
        String[] options = getResources().getStringArray(R.array.card_text_titles);

        for (int i = 0; i < options.length; i++) {
            recyclerViewSettings.add(new RecyclerViewSettings(options[i], recyclerImages[i]));     // fill the list
        }
    }
}