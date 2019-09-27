package com.example.sachin.progressbar;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.ProgressDialog;
import android.widget.TextView;

public class ProgressBar extends AppCompatActivity {

    private android.widget.ProgressBar circularProgress,horizontalProgress;
    int progress = 0;
    Handler handler;
    TextView size;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress_bar);

        handler = new Handler();

        horizontalProgress = findViewById(R.id.horizontalProgressbar);
        size = findViewById(R.id.size);

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (progress<100){
                    progress+=5;
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            horizontalProgress.setProgress(progress);
                            size.setText(progress+"/100");
                        }
                    });

                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }
}
