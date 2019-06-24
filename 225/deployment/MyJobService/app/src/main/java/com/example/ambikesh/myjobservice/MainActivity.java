package com.example.ambikesh.myjobservice;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    JobInfo ji;
    JobScheduler j;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void startjob(View view)
    {
        j = (JobScheduler)
    }
}
