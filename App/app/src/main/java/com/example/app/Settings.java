package com.example.app;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Settings extends AppCompatActivity implements RecyclerViewInterface{

    //declare variables
    Button backToMain;
    String[] options;

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
        options = getResources().getStringArray(R.array.card_text_titles);

        for (String option : options) {
            recyclerViewSettings.add(new RecyclerViewSettings(option, recyclerImages[0]));     // fill the list
        }
    }

    @Override
    public void onItemClick(int position) {

      switch (position) {
          case 0: Intent intent0 = new Intent(this, CustomizeProfile.class);
              intent0.putExtra("EMAIL", getIntent().getStringExtra("EMAIL"));                       // customize profile page
              startActivity(intent0);
              break;
          case 1: showPopup1();       // notifications popup
              break;
          case 2: showPopup2();       // help popup
              break;
          case 3: Intent intent3 = new Intent(this, ChangePassword.class);
              intent3.putExtra("EMAIL", getIntent().getStringExtra("EMAIL"));                       // update password page
                    startActivity(intent3);
              break;
          case 4: Intent intent4 = new Intent(this, TitlePage.class);
                    Toast.makeText(this, "Log Out Successful", Toast.LENGTH_SHORT).show();          // logout
                    startActivity(intent4);
              break;
          case 5: Intent intent5 = new Intent(this, DeleteAccountPage.class);               // move to delete page
              intent5.putExtra("EMAIL", getIntent().getStringExtra("EMAIL"));
              startActivity(intent5);
              break;                   // delete account popup
      }

    }


    private void showPopup1() {
        Dialog popup = new Dialog(this);
        popup.setContentView(R.layout.notifications_popup);        // popup method
        popup.show();
    }

    private void showPopup2() {
        Dialog popup = new Dialog(this);
        popup.setContentView(R.layout.help_popup);        // popup method
        popup.show();
    }
}