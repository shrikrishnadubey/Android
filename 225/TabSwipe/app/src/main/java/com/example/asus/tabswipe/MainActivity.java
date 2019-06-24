package com.example.asus.tabswipe;

import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.TableLayout;

public class MainActivity extends AppCompatActivity {

    ViewPager vp1;
   TabLayout t1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        vp1=(ViewPager)findViewById(R.id.vp1);
        t1=(TabLayout) findViewById(R.id.t1);
        Myadapter mad=new Myadapter(getSupportFragmentManager());
        vp1.setAdapter(mad);
        t1.setupWithViewPager(vp1);
    }
}
