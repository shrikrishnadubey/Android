package com.example.akashsingh.customlist;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by AKASH SINGH on 25-Jan-18.
 */

public class MyAdapter extends BaseAdapter {
    ArrayList<Person>alp;
    LayoutInflater inflater;
    Context ct;
    MyAdapter(ArrayList<Person>alp,Context ct)
    {
        this.alp=alp;
        this.ct=ct;
    }

    @Override
    public int getCount() {
        Toast.makeText(ct, "size is"+alp.size(), Toast.LENGTH_SHORT).show();
        return alp.size();
    }

    @Override
    public Object getItem(int position) {
        return alp.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Toast.makeText(ct, "Position"+position, Toast.LENGTH_SHORT).show();
        Person p=(Person) getItem(position);
        Activity at=(Activity) ct;
        LayoutInflater lif=at.getLayoutInflater();
        View v1=lif.inflate(R.layout.activity_imageadd2,null);
        ImageView iv=v1.findViewById(R.id.iv1);
        TextView t1=v1.findViewById(R.id.tv1);
        TextView t2=v1.findViewById(R.id.tv2);
        iv.setImageResource(p.getImage());
        t1.setText(p.getName());
        t2.setText(p.getDescription());
        return v1;
    }
}
