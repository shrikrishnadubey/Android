package com.example.admin.lpudemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class LIstViewDemo extends AppCompatActivity {
ArrayList<DataModel> myData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_demo);

      ListView list=(ListView) findViewById(R.id.meralist);
        populateData();
        MyAdapter myadap=new MyAdapter(myData,LIstViewDemo.this);
        list.setAdapter(myadap);

    }

    public void populateData(){
        myData=new ArrayList<>();

        for(int i=0;i<10;i++){
            DataModel d=new DataModel();
            d.setDescription("description "+i);
            d.setTitle("Title "+i);
            d.setImageid(R.mipmap.ic_launcher);
            myData.add(d);
        }

    }
}
