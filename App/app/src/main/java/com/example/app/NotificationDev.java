package com.example.app;

import androidx.appcompat.app.AppCompatActivity;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;
import android.os.Bundle;

public class NotificationDev extends AppCompatActivity {
    public static final String channel_1_id = "channel1";
    //id for notif channel 1
    public static final String channel_2_id = "channel2";
    //id for notif channel 2

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification_dev);

        createNotifChann();
    }

    private void createNotifChann() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel c1 = new NotificationChannel(
                    channel_1_id, "Channel 1", NotificationManager.IMPORTANCE_HIGH);
            c1.setDescription("Channel 1");
            //channel 1 is a test for high importance

            NotificationChannel c2 = new NotificationChannel(
                    channel_2_id, "Channel 2", NotificationManager.IMPORTANCE_LOW);
            c2.setDescription("Channel 2");
            //channel 2 is a test for low importance

            NotificationManager manage = getSystemService(NotificationManager.class);
            manage.createNotificationChannel(c1);
            manage.createNotificationChannel(c2);
        }
    }
}
