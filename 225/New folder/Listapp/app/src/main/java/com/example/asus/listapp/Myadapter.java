package com.example.asus.listapp;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by ASUS on 25-01-2018.
 */

public class Myadapter extends BaseAdapter{


    Context ct;
    ArrayList<Person> a1;
    Myadapter(Context ct, ArrayList<Person> a1)
    {
        this.ct=ct;
        this.a1=a1;
    }

    @Override
    public int getCount() {
        return a1.size();
    }

    @Override
    public Object getItem(int position) {
        return a1.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {


        Person p=(Person)getItem(position);
        Activity ac=(Activity) ct;
        View v1 = ac.getLayoutInflater().inflate(R.layout.my_layout,null);

        ImageView t1=(ImageView)v1.findViewById(R.id.t1);
        TextView t2 = (TextView)v1.findViewById(R.id.t2);
        TextView t3 = (TextView)v1.findViewById(R.id.t3);
        t1.setImageResource(p.getImage());
        t2.setText(p.getName());
        t3.setText(p.getDesc());
        return v1;

    }
}
