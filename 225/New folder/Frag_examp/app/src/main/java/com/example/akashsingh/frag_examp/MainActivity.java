package com.example.akashsingh.frag_examp;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    String s1,s2;
    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv=findViewById(R.id.tv);
        FragmentTransaction ft=getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.f1,new Frag1(),"First");
        ft.commit();
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction ft1=getSupportFragmentManager().beginTransaction();
                ft1.replace(R.id.f1,new Frag2(),"Second");
                ft1.commit();
            }
        });
    }
}
