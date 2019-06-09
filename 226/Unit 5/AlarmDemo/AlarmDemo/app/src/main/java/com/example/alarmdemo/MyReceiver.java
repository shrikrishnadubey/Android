package com.example.alarmdemo;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.NotificationCompat;


import static android.content.Context.NOTIFICATION_SERVICE;

public class MyReceiver extends BroadcastReceiver {
    public MyReceiver() {
    }

    @Override
    public void onReceive(Context context, Intent intent)
    {
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.
        NotificationCompat.Builder nib = new NotificationCompat.Builder(context);

        nib.setSmallIcon(R.mipmap.ic_launcher);
        nib.setContentTitle("My Alarm");
        nib.setContentText("Alarm is riniging..");

        Intent i = new Intent(context,Main2Activity.class);
        PendingIntent pi = PendingIntent.getActivity(context,0,i,0);

        nib.setContentIntent(pi);
        nib.setAutoCancel(true);

        Notification ni = nib.build();

        NotificationManager nim = (NotificationManager) context.getSystemService(NOTIFICATION_SERVICE);

        nim.notify(0,ni);

    }
}
