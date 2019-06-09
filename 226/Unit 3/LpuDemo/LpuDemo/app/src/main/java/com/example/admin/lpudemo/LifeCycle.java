package com.example.admin.lpudemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class LifeCycle extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_life_cycle);

        Log.d("LifeCycle","Created");
    }

    public void gotoo(View v){

        Intent i =new Intent(this,LifeCycleCalled.class);
        startActivity(i);

    }


    @Override
    protected void onStart() {
        super.onStart();
        Log.d("LifeCycle","started");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("LifeCycle","resumed");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("LifeCycle","paused");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("LifeCycle","stopped");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("LifeCycle","Destroyed");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("LifeCycle","Restarted");
    }
}
