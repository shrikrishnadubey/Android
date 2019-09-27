package com.example.asus.listapp;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView lv;
    ArrayList<Person> a1;
    Person p;
    Myadapter mad;
    int i;
    String name,pass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv = (ListView) findViewById(R.id.lv);
        Intent m1=getIntent();
        name=m1.getStringExtra("a");
        pass=m1.getStringExtra("b");

        a1 = new ArrayList<>();


            p = new Person();
            p.setName(name);
            p.setDesc(pass);
            p.setImage(R.mipmap.ic_launcher);

            a1.add(p);


        mad = new Myadapter(this, a1);
        lv.setAdapter(mad);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                view.setBackgroundColor(Color.RED);
                parent.setBackgroundColor(Color.YELLOW);
            }
        });
    }


}
