package com.example.app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.annotation.SuppressLint;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.widget.Button;

public class NotificationDev extends AppCompatActivity {
    public static final String channel_1_id = "channel1";
    //id for notif channel 1
    Button notifBtn;
    Button backToSettings;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification_dev);

        notifBtn = findViewById(R.id.notifBtn);
        backToSettings = findViewById(R.id.backToSettings);

        notifBtn.setOnClickListener(view -> {
            NotificationCompat.Builder build = new NotificationCompat.Builder(NotificationDev.this, channel_1_id);
            //code for notification
            build.setContentTitle("Notification Dev");
            //title
            build.setContentText("This is a notification for developers");
            //content of the notification
            //build.setSmallIcon() <- this sets the icon that shows up with the notification.
            //I think we should use the logo for it
            build.setAutoCancel(true);

            NotificationManagerCompat managerCompat = NotificationManagerCompat.from(NotificationDev.this);
            managerCompat.notify(1,build.build());
        });

        backToSettings.setOnClickListener(view -> {                                     // back button actions
            Intent intent = new Intent(view.getContext(), Settings.class);
            intent.putExtra("EMAIL", getIntent().getStringExtra("EMAIL"));   // stays logged in
            intent.putExtra("NEW_USER", false);                              // makes sure popup doesn't re-appear
            startActivity(intent);
        });

        createNotifChann();
    }

    private void createNotifChann() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel c1 = new NotificationChannel(
                    channel_1_id, "Channel 1", NotificationManager.IMPORTANCE_HIGH);
            c1.setDescription("Channel 1");
            //channel 1 is a test for high importance

            NotificationManager manage = getSystemService(NotificationManager.class);
            manage.createNotificationChannel(c1);
        }
    }
}
