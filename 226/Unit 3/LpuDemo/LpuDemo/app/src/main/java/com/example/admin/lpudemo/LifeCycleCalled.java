package com.example.admin.lpudemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class LifeCycleCalled extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_life_cycle_called);
        Log.d("LifeCycle2","created");
    }
    @Override
    protected void onStart() {
        super.onStart();
        Log.d("LifeCycle2","started");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("LifeCycle2","resumed");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("LifeCycle2","paused");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("LifeCycle2","stopped");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("LifeCycle2","Destroyed");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("LifeCycle2","Restarted");
    }
}
