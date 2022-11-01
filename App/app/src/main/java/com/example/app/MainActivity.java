package com.example.app;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.ImageButton;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    // create variables
    ImageButton gearButton;
    Button calendarButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent1 = getIntent();
        if (intent1.getExtras().getBoolean("NEW_USER", true)) {
            showPopup();                                                              // check if new account, if so show popup
        }

        //set variables
        gearButton = findViewById(R.id.gearButton);
                                                                    // DataBase db = new DataBase(this); can be used later if needed
        calendarButton = findViewById(R.id.calendarView);

        // Retrieve account information
                                                                                      //DataBase db = new DataBase(this);
                                                                    // how to get values: String name = db.getName(getIntent().getStringExtra("EMAIL"));

        gearButton.setOnClickListener(view -> {
            Intent intent = new Intent(view.getContext(), Settings.class);
            intent.putExtra("EMAIL", getIntent().getStringExtra("EMAIL"));
            intent.putExtra("NEW_USER", false);                                // check new account, move to settings
            startActivity(intent);
        });

        calendarButton.setOnClickListener(view -> {
            Intent intent = new Intent(this, CalendarActivity.class);
            startActivity(intent);
        });
    }

    private void showPopup() {
        Dialog popup = new Dialog(this);
        popup.setContentView(R.layout.create_account_page_welcome_popup);
        popup.getWindow().setBackgroundDrawableResource(R.drawable.popup_background);        // popup method
        popup.show();
    }
}