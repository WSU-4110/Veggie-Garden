package com.example.app;

//import android.widget.*;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

/**
 * The design pattern that I integrated into this class is the VirtualGardenState design pattern. This class controls the virtual garden view within the app. After adding the state design pattern, the class has two states. The default state is the view only state and the other state is the editing state. In the view only state, the user can view their virtual garden and access the PlantID for all of their plants by tapping any plant, to then be linked to that plant's PlantID screen. The state can be changed back and forth by tapping a state-switching button on the screen. The editing state allows the user to rearrange the virtual garden layout by dragging and dropping the veggies to different locations on the grid layout. Also, the editing state allows the user to select one or multiple veggies at once with the ability to do things such as update their "Watered" status, mark them as Harvested, or delete them completely. Note, these actions may be done on the PlantID page for individual plants, but the edit garden feature is mostly convenient for making large scale adjustments early on in the season, when the garden is most volatile.
 */
public class VirtualGarden extends AppCompatActivity {
    int veggiesInGarden;
    //private PlantID myPlants;
    public int currentState = 1; //state 1 is read only, state 2 is edit
    //button to go to home page
    Button backButton, goToPlants, editButton;
    GridView theGridViewVG;
    ArrayList veggieList = new ArrayList<>();//Used for the GridView
    //veggiePictures to be shown in the virtual garden. Referencing position 0 of this array will display an empty garden planter.
    int[] veggiePictures = {
            R.drawable.planter_clipart,
            R.drawable.broccoli,
            R.drawable.cabbage,
            R.drawable.celery,
            R.drawable.corn,
            R.drawable.pepper,
            R.drawable.potato,
            R.drawable.tomato,
            R.drawable.zucchini};

    @SuppressLint("MissingInflatedId")
    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_virtual_garden);

        //Button to go to MainActivity
        backButton = findViewById(R.id.back_to_main_page_from_virtual_garden);
        backButton.setOnClickListener(view -> {                                     // back button actions
            Intent intent = new Intent(view.getContext(), MainActivity.class);
            intent.putExtra("EMAIL", getIntent().getStringExtra("EMAIL"));   // stays logged in
            intent.putExtra("NEW_USER", false);                              // makes sure popup doesn't re-appear
            startActivity(intent);
        });
        goToPlants = findViewById(R.id.go_to_plants_from_virtual_garden);
        goToPlants.setOnClickListener(view -> {
            Intent intent = new Intent(this, PlantsPage.class);
            intent.putExtra("EMAIL", getIntent().getStringExtra("EMAIL"));
            intent.putExtra("NEW_USER", false);
            startActivity(intent);
        });
        editButton = findViewById(R.id.edit_vg_button);
        editButton.setOnClickListener(view -> {
            Intent intent = new Intent(this, EditVirtualGarden.class);
            intent.putExtra("EMAIL", getIntent().getStringExtra("EMAIL"));
            intent.putExtra("NEW_USER", false);
            startActivity(intent);
        });
        theGridViewVG =(GridView) findViewById(R.id.virtualGarden_GridView);
        veggieList.add(new VirtualGardenItem("veggie 1", R.drawable.broccoli));
        veggieList.add(new VirtualGardenItem("veggie 2", R.drawable.cabbage));
        veggieList.add(new VirtualGardenItem("veggie 3", R.drawable.celery));
        veggieList.add(new VirtualGardenItem("veggie 4", R.drawable.corn));
        veggieList.add(new VirtualGardenItem("veggie 5", R.drawable.pepper));
        veggieList.add(new VirtualGardenItem("veggie 6", R.drawable.potato));
        veggieList.add(new VirtualGardenItem("veggie 7", R.drawable.tomato));
        veggieList.add(new VirtualGardenItem("veggie 8", R.drawable.zucchini));
        VirtualGardenItemAdapter adapter = new VirtualGardenItemAdapter(this, R.layout.virtual_garden_item, veggieList);
        theGridViewVG.setAdapter(adapter);

        //theGridViewVG = findViewById(R.id.virtualGarden_GridView);
        //ArrayAdapter adapter=new ArrayAdapter<String>(this, R.id.GridView, veggiePictures)

        //old code
        //CustomAdapter customAdapter = new CustomAdapter(getApplicationContext(), veggiePictures);
        //theGridViewVG.setAdapter(customAdapter);
    }

    class VirtualGardenState {
        public void changeToOppositeState() {
            //changes current state to opposite state
            if (currentState == 1) {
                currentState = 2;
            } else if (currentState == 2) {
                currentState = 1;
            }
        }

        public void changeStateToReadOnly() {
            //changes current state to read only state
            currentState = 1;
        }

        public void changeStateToEdit() {
            //changes current state to edit state
            currentState = 2;
        }
    }
}
