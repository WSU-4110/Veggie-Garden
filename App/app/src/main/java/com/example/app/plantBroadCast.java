package com.example.app;

import android.annotation.SuppressLint;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

public class plantBroadCast extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Intent repeat = new Intent(context, AddAPlant.class);
        repeat.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

        @SuppressLint("UnspecifiedImmutableFlag") PendingIntent pending = PendingIntent.getActivity(context, 0, repeat, PendingIntent.FLAG_UPDATE_CURRENT);
        NotificationCompat.Builder build = new NotificationCompat.Builder(context,TitlePage.plantNotifChannelID)
                .setContentIntent(pending)
                .setSmallIcon(R.drawable.plant)
                .setContentTitle("Plant needs watering")
                .setContentText("Water your plant")
                .setAutoCancel(true);

        NotificationManagerCompat notifMan = NotificationManagerCompat.from(context);
        notifMan.notify(1,build.build());
    }

    public static plantBroadCast instance = new plantBroadCast();

    private plantBroadCast getInstance() {
        if (instance == null) {
            instance = new plantBroadCast();
        }
        return instance;
    }
}
