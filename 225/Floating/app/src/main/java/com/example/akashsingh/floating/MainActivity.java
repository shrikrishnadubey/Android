package com.example.akashsingh.floating;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

public class MainActivity extends AppCompatActivity {

    FloatingActionButton aero,ambu,gana;
    Animation o,cl,c,a;
    Boolean b=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        aero=findViewById(R.id.aero);
        ambu=findViewById(R.id.ambulance);
        gana=findViewById(R.id.gaana);
        o= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.open);
        cl= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.close);
        c= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.clock);
        a= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.anti);
        ambu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               if(b)
               {
                   ambu.startAnimation(c);
                   aero.startAnimation(cl);
                   gana.startAnimation(cl);
                   aero.setClickable(false);
                   gana.setClickable(false);
                   b=false;
               }
               else
               {
                   ambu.startAnimation(a);
                   aero.startAnimation(o);
                   gana.startAnimation(o);
                   aero.setClickable(true);
                   gana.setClickable(true);
                   b=true;
               }
            }
        });

    }
}
