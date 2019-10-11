package com.example.antisaby.animationtest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //This method is called on click of "Start Animation" button.
    public void startAnimation(View view)
    {
        TextView tvHelloWorld = findViewById(R.id.tvHelloWorld);
        Animation myAnim = AnimationUtils.loadAnimation(this, R.anim.my_anim);
        tvHelloWorld.startAnimation(myAnim);
    }
}
