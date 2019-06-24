package com.example.dell.jobschedulingdemo;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.io.FileOutputStream;

public class MainActivity extends AppCompatActivity {

    //NotificationManager nm;

    JobInfo ji;
    JobScheduler js;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

      //  nm=(NotificationManager)getSystemService(NOTIFICATION_SERVICE);

    }

    public void startJob(View view) {

        //This is program for cse225 unit-5;how to write data in file!!

       /* try {
            FileOutputStream fon = openFileOutput("abc.txt", MODE_PRIVATE);
            String s="This text I want to write!!";
            fon.write(s.getBytes());
            fon.close();

        }catch (Exception e){e.printStackTrace();}
        */

//        Intent i=new Intent(this,Main2Activity.class);
//
//        PendingIntent pi=PendingIntent.getActivity(this,0,i,0);
//
//        Notification.Builder nib=new Notification.Builder(this);
//        nib.setContentTitle("My Notification");
//        nib.setContentText("Hey There!!");
//        nib.setSmallIcon(R.drawable.b7);
//        //When user clicks on button,then notifcation pops up.When i click on notification,then only user goes to new activity!
//
//        nib.setContentIntent(pi);
//
//        nib.setAutoCancel(true);  //after clicking on notification,notification will be cancel(udd jayega notification)!!
//
//        nm.notify(0,nib.build());

        js=(JobScheduler)getSystemService(JOB_SCHEDULER_SERVICE);

        ComponentName cn=new ComponentName(this,MyJobService.class);
        JobInfo.Builder jib=new JobInfo.Builder(0,cn);

        jib.setRequiredNetworkType(JobInfo.NETWORK_TYPE_ANY);
        jib.setRequiresCharging(true);
        jib.setRequiresDeviceIdle(false);

        ji=jib.build();

        js.schedule(ji);

    }


    public void stopJob(View view) {

        if(js!=null)
        {
            js.cancelAll();
            js=null;
        }
        Toast.makeText(this,"Job cancelled",Toast.LENGTH_SHORT).show();
        //nm.cancel(0);
        //nm.cancelAll();  //if more than 1 notifcationa are there!!!

    }


}
