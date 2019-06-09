package com.example.admin.lpudemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ContextMenuDemo extends AppCompatActivity implements AdapterView.OnItemClickListener{
List<String> myDatalist;
    ArrayAdapter<String> adap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_context_menu_demo);

      ListView list=(ListView) findViewById(R.id.mylistview);

        makeData();

      adap=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,myDatalist);


        list.setAdapter(adap);

registerForContextMenu(list);

      //  list.setOnItemClickListener(this);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        getMenuInflater().inflate(R.menu.mymenu,menu);

      //  super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
if(item.getTitle().equals("item1")){
    Toast.makeText(this,"item1 selected",Toast.LENGTH_SHORT).show();
}
        return super.onContextItemSelected(item);
    }


    public void makeData(){
        myDatalist=new ArrayList<>();
        myDatalist.add("Lpu");
        myDatalist.add("Kuk");
        myDatalist.add("Kukd");
        myDatalist.add("Kukju");
        myDatalist.add("Kuktg");myDatalist.add("Kuk");
        myDatalist.add("Kukgg");
        myDatalist.add("Kukgg"); myDatalist.add("Kukgg");
        myDatalist.add("Kukgg");
        myDatalist.add("Kukgg");
        myDatalist.add("Kukgg");
        myDatalist.add("Kukgg");
        myDatalist.add("Kukgg");
        myDatalist.add("Kukgg");
        myDatalist.add("Kukgg");
        myDatalist.add("Kukgg");
        myDatalist.add("Kukgg"); myDatalist.add("Kukgg");

    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        String value= adapterView.getItemAtPosition(i).toString();
        Toast.makeText(this,"value selected ="+value,Toast.LENGTH_SHORT).show();
        myDatalist.remove(i);
        adap.notifyDataSetChanged();
    }
}
