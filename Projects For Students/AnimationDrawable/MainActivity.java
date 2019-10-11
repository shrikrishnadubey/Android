package com.example.antisaby.animationdrawabletest;

import android.graphics.drawable.AnimationDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity
{
    private AnimationDrawable mMyAnim;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView ivHeart = findViewById(R.id.ivHeart);
        ivHeart.setBackgroundResource(R.drawable.myanim);
        mMyAnim = (AnimationDrawable) ivHeart.getBackground();
    }

    public void startAnimation(View view)
    {
        mMyAnim.start();
    }
}
