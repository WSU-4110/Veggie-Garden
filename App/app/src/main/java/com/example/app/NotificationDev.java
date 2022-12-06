package com.example.app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.annotation.SuppressLint;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class NotificationDev extends AppCompatActivity {
    public static final String channel_2_id = "channel 2";
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

        notifBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NotificationCompat.Builder build = new NotificationCompat.Builder(NotificationDev.this, channel_2_id);
                //code for notification
                build.setContentTitle("Notification Dev");
                //title
                build.setContentText("This is a notification for developers");
                //content of the notification
                build.setSmallIcon(R.drawable.plant); //<- this sets the icon that shows up with the notification.
                //I think we should use the logo for it

                NotificationManagerCompat managerCompat = NotificationManagerCompat.from(NotificationDev.this);
                managerCompat.notify(2,build.build());
            }
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
            NotificationChannel c2 = new NotificationChannel(
                    channel_2_id, "Channel 2", NotificationManager.IMPORTANCE_DEFAULT);
            c2.setDescription("Channel 2");
            //channel 1 is a test for high importance

            NotificationManager manage = getSystemService(NotificationManager.class);
            manage.createNotificationChannel(c2);
        }
    }
}
