package com.example.app;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.ImageButton;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    //declare variables
    ImageButton gearButton;
    Button calendarButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        showPopup();

        //set variables
        gearButton = findViewById(R.id.gearButton);
        calendarButton = findViewById(R.id.calendarView);

        // Retrieve account information
                                                                                      //DataBase db = new DataBase(this);
                                                                    // how to get values: String name = db.getName(getIntent().getStringExtra("EMAIL"));
        gearButton.setOnClickListener(view -> {
            Intent intent = new Intent(view.getContext(), Settings.class);
            intent.putExtra("EMAIL", getIntent().getStringExtra("EMAIL"));
            startActivity(intent);
        });

        calendarButton.setOnClickListener(view -> {
            Intent intent = new Intent(this, CalendarActivity.class);
            startActivity(intent);
        });
    }

    private void showPopup() {
        Dialog popup = new Dialog(this);
        popup.setContentView(R.layout.main_page_welcome_popup);
        popup.getWindow().setBackgroundDrawableResource(R.drawable.popup_background);

        popup.show();
    }

}