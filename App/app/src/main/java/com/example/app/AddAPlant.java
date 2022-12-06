package com.example.app;

import android.annotation.SuppressLint;
import android.app.AlarmManager;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

public class AddAPlant extends AppCompatActivity {

    // declare vars
    Button back, add;
    DataBase db;
    EditText bday;
    CheckBox location;
    public static final String plantNotifChannelID = "channel 1";

    @RequiresApi(api = Build.VERSION_CODES.M)
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_aplant);

        // set vars
        back = findViewById(R.id.backToMain);
        add = findViewById(R.id.addPlant);
        bday = findViewById(R.id.plantBday);
        location = findViewById(R.id.location);
        final Spinner plantList = findViewById(R.id.plantList);            // dropdown menu
        db = new DataBase(this);

        // set array adapter
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.listOfPlants, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        plantList.setAdapter(adapter);

        back.setOnClickListener(view -> {
            Intent intent = new Intent(this, MainActivity.class);
            intent.putExtra("EMAIL", getIntent().getStringExtra("EMAIL"));   // stays logged in
            intent.putExtra("NEW_USER", false);                              // makes sure popup doesn't re-appear
            startActivity(intent);
        });

        add.setOnClickListener(view -> {
            Intent intent = new Intent(this, MainActivity.class);
            String name = plantList.getSelectedItem().toString();
            String date = bday.getText().toString();
            String outdoors;
            if (location.isChecked()) outdoors = "It is outdoors.";
            else outdoors = "It is indoors.";

            Plant plant = new Plant(name, outdoors, date);                       // creates plant credentials, adds to database
            db.addPlant(plant);

            //set up daily reminders for notifications
            Calendar cal = Calendar.getInstance();
            cal.set(Calendar.HOUR_OF_DAY, 00);
            cal.set(Calendar.MINUTE, 00);
            cal.set(Calendar.SECOND, 00);

            if (Calendar.getInstance().after(cal)) {
                cal.add(Calendar.DAY_OF_MONTH, 1);
            }

            Intent notifIntent = new Intent(AddAPlant.this,plantBroadCast.class);
            PendingIntent plantPendingIntent = PendingIntent.getBroadcast(getApplicationContext(),0, notifIntent, PendingIntent.FLAG_UPDATE_CURRENT);

            AlarmManager plantAlarm = (AlarmManager) getSystemService(ALARM_SERVICE);
            plantAlarm.setRepeating(AlarmManager.RTC_WAKEUP, cal.getTimeInMillis(), AlarmManager.INTERVAL_DAY,plantPendingIntent);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                plantAlarm.setExactAndAllowWhileIdle(AlarmManager.RTC_WAKEUP,cal.getTimeInMillis(),plantPendingIntent);
            }

            intent.putExtra("EMAIL", getIntent().getStringExtra("EMAIL"));   // stays logged in
            intent.putExtra("NEW_USER", false);                              // makes sure popup doesn't re-appear
            Toast.makeText(this, "Plant added!", Toast.LENGTH_SHORT).show();
            startActivity(intent);
        });

    }
}