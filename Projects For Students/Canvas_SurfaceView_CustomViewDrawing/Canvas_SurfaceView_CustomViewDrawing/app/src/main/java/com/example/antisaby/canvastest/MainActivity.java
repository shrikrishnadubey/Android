package com.example.antisaby.canvastest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity
{
    private CustomSurfaceView mCustomSurfaceView;

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        mCustomSurfaceView = new CustomSurfaceView(this);
        setContentView(mCustomSurfaceView);
    }

    @Override
    protected void onResume()
    {
        super.onResume();
        mCustomSurfaceView.resume();
    }

    @Override
    protected void onPause()
    {
        super.onPause();
        mCustomSurfaceView.pause();
    }
}
