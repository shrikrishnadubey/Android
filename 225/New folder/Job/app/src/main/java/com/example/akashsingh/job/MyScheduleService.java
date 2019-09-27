package com.example.akashsingh.job;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.job.JobParameters;
import android.app.job.JobService;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.widget.Toast;

public class MyScheduleService extends JobService {

    @Override
    public boolean onStartJob(JobParameters jobParameters) {

        Toast.makeText(this,"Job started", Toast.LENGTH_SHORT).show();

        Intent i = new Intent(this, MainActivity.class);
        PendingIntent pi = PendingIntent.getActivity(this,0,i,0);
        NotificationManager nm = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);

        Notification.Builder builder = new Notification.Builder(this);
        builder.setContentTitle("My Notification");
        builder.setContentText("My Notification Text");
        builder.setSmallIcon(R.drawable.ic_launcher_background);

        builder.setContentIntent(pi);
        builder.setAutoCancel(true);

        nm.notify(0,builder.build());
        return false;
    }

    @Override
    public boolean onStopJob(JobParameters jobParameters) {
        return false;
    }
}
