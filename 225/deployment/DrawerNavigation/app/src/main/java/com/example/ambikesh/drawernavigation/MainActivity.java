package com.example.ambikesh.drawernavigation;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    DrawerLayout dl;
    NavigationView nv;
    Toolbar tb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dl =findViewById(R.id.dl);
        nv = findViewById(R.id.nav_view);
        tb =findViewById(R.id.tb);
        setSupportActionBar(tb);
        ActionBar ab =getSupportActionBar();
        ab.setTitle("My APP Bar");
        ab.setSubtitle("My Title");
        ab.setLogo(R.mipmap.ic_launcher);
        ab.setDisplayHomeAsUpEnabled(true);

        ab.setHomeAsUpIndicator(R.drawable.a);

        nv.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                Toast.makeText(MainActivity.this, "Hi there"+item.getTitle(), Toast.LENGTH_SHORT).show();
                dl.closeDrawer(nv);
                return true;
            }
        });

    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //return super.onOptionsItemSelected(item);

        int k = item.getItemId();
        switch (k)
        {
            case android.R.id.home:
                dl.openDrawer(GravityCompat.START);
                break;
        }
        return true;
    }
}
