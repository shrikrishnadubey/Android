package com.example.asus.drawlayout;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    DrawerLayout d1;
    NavigationView n1;
    Toolbar t1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        d1=(DrawerLayout)findViewById(R.id.d1);
        n1=(NavigationView)findViewById(R.id.n1);
        t1=(Toolbar)findViewById(R.id.t1);
        setSupportActionBar(t1);
        ActionBar ab= getSupportActionBar();
        ab.setLogo(R.mipmap.ic_launcher_round);
        ab.setDisplayHomeAsUpEnabled(true);
        ab.setTitle(" ");
        ab.setHomeAsUpIndicator(R.drawable.ic_list_black_24dp);




        n1.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                int i=item.getItemId();
                Toast.makeText(MainActivity.this, item.getTitle(), Toast.LENGTH_SHORT).show();
                d1.closeDrawers();
                item.setCheckable(false);
                return true;
            }
        });

        d1.addDrawerListener(new DrawerLayout.DrawerListener() {
            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {

                Toast.makeText(MainActivity.this, "yooo ", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onDrawerOpened(View drawerView) {

            }

            @Override
            public void onDrawerClosed(View drawerView) {

            }

            @Override
            public void onDrawerStateChanged(int newState) {

            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int i = item.getItemId();

        switch(i)
        {
            case android.R.id.home:
                d1.openDrawer(GravityCompat.START);
                break;
        }

        return true;
    }
}
