package com.example.ambikesh.jobscheduling;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    NotificationManager nm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

    }


    public void startjob(View v)
    {
        Intent i = new Intent(this,Main2Activity.class);
        PendingIntent pi  =PendingIntent.getActivity(this,0,i,0);
        Notification.Builder nib = new Notification.Builder(this);
        nib.setContentTitle("My notification");
        nib.setContentText("Akash");
        nib.setSmallIcon(R.mipmap.ic_launcher);
        nib.setContentIntent(pi);
        nm.notify(0,nib.build());
        nib.setAutoCancel(true);

    }


    public void stopjob(View v)
    {
        nm.cancel(0);
    }
}
