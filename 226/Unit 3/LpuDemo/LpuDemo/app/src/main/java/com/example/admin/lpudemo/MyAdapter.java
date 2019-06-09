package com.example.admin.lpudemo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by admin on 15-Dec-16.
 */

public class MyAdapter extends BaseAdapter
{
    LayoutInflater inflater;

    List<DataModel> data;
    Context c;
    public MyAdapter(List<DataModel> d, Context context){
        data=d;
       // c=context;
      inflater=  LayoutInflater.from(context);
    }
    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int i) {
        return data.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

       DataModel d=(DataModel) getItem(i);
     View v=   inflater.inflate(R.layout.listitemlayout,null);

    TextView title=(TextView) v.findViewById(R.id.mytitle);
        TextView description=(TextView)    v.findViewById(R.id.mydescription);
       ImageView image=(ImageView) v.findViewById(R.id.myimage);

      title.setText(d.getTitle());
        description.setText(d.getDescription());
        image.setImageResource(d.getImageid());
        return v;
    }
}
