package com.example.app;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Settings extends AppCompatActivity implements RecyclerViewInterface{

    //declare variables
    Button backToMain;

    ArrayList<RecyclerViewSettings> recyclerViewSettings = new ArrayList<>();         // array for texts in recycler view
    int[] recyclerImages = {R.drawable.forward};

    @SuppressLint({"MissingInflatedId", "WrongViewCast"})    // suppresses incorrect error messages
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        RecyclerView recyclerView = findViewById(R.id.customizeList);
        RecycleModels();
        RecyclerAdapter adapter = new RecyclerAdapter(this, recyclerViewSettings, this);            // recyclerview stuff
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

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

        for (String option : options) {
            recyclerViewSettings.add(new RecyclerViewSettings(option, recyclerImages[0]));     // fill the list
        }
    }

    @Override
    public void onItemClick(int position) {

    }
}