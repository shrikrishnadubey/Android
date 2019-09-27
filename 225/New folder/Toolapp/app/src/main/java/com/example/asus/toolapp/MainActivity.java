package com.example.asus.toolapp;

import android.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    android.support.v7.widget.Toolbar t1;
    android.support.v7.app.ActionBar ab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        t1= (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(t1);
        ab = getSupportActionBar();

        ab.setTitle("My toolbar");
        ab.setSubtitle("this is toolbar");
        ab.setLogo(R.mipmap.ic_launcher);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.my_menu,menu);


        MenuItem m1=menu.add(0,1,10,"Help");
            MenuItem search=menu.findItem(R.id.i5);
            SearchView sv=(SearchView)search.getActionView();

            sv.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {


                Toast.makeText(MainActivity.this,query,Toast.LENGTH_SHORT).show();
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int k=item.getItemId();

        switch(k)
        {
            case R.id.i2 :
                Toast.makeText(this,"This is activity 2",Toast.LENGTH_SHORT).show();
                break;
            case R.id.i3 :
                Toast.makeText(this,"This is activity 3",Toast.LENGTH_SHORT).show();
                break;
            case 1:
                Toast.makeText(this, "This is help", Toast.LENGTH_SHORT).show();
                break;
            case R.id.i5 :
                Toast.makeText(this,"This is Search",Toast.LENGTH_SHORT).show();
                break;
        }

        return true;
    }
}
