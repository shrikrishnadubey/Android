package com.example.dell.jobschedulingdemo;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.job.JobParameters;
import android.app.job.JobService;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by Dell on 12-Apr-18.
 */

//after creating class,write any manifest the permission to use the service..

public class MyJobService extends JobService {
    NotificationManager nm;
    @Override
    public boolean onStartJob(JobParameters jobParameters) {

        nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

        Toast.makeText(this,"Job strated",Toast.LENGTH_SHORT).show();

        Intent i=new Intent(this,Main2Activity.class);

        PendingIntent pi=PendingIntent.getActivity(this,0,i,0);

        Notification.Builder nib=new Notification.Builder(this);
        nib.setContentTitle("My Notification");
        nib.setContentText("Hey There!!");
        nib.setSmallIcon(R.drawable.b7);
        //When user clicks on button,then notifcation pops up.When i click on notification,then only user goes to new activity!

        nib.setContentIntent(pi);

        nib.setAutoCancel(true);  //after clicking on notification,notification will be cancel(udd jayega notification)!!

        nm.notify(0,nib.build());

        return false;
    }

    @Override
    public boolean onStopJob(JobParameters jobParameters) {
        return false;


    }
}
