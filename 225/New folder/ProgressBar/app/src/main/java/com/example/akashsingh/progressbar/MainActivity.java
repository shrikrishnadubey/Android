package com.example.akashsingh.progressbar;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ProgressBar;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class MainActivity extends AppCompatActivity {
    ProgressBar bar;
    int total=0,dTotal=0;
    CountDownTimer cdt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bar = (ProgressBar) findViewById(R.id.progress);
        bar.setProgress(total);
        int twoMin = 2; // 2 minutes in milli seconds

        /** CountDownTimer starts with 2 minutes and every onTick is 1 second */
        cdt = new CountDownTimer(twoMin, 1000) {

            public void onTick(long millisUntilFinished) {

                total = (int) ((dTotal / 120) * 100);
                bar.setProgress(total);
            }

            public void onFinish() {
                // DO something when 2 minutes is up
            }
        }.start();

    }
}
