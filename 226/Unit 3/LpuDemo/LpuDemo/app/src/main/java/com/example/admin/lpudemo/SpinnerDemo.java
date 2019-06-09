package com.example.admin.lpudemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class SpinnerDemo extends AppCompatActivity  implements AdapterView.OnItemSelectedListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner_demo);

      Spinner s=(Spinner) findViewById(R.id.spinner);
        //take data
        List<String> mylist=new ArrayList<>();
        mylist.add("Manish");
        mylist.add("Anupinder");
        mylist.add("Pramod");
        mylist.add("Abhishek");
        mylist.add("rakesh");
        mylist.add("rahul");
        mylist.add("pardeep");
        mylist.add("nilesh");
        mylist.add("hemmant");
        mylist.add("nisha");
        mylist.add("misha");
        mylist.add("aish");


     //   ArrayAdapter<String> adap=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,mylist);
ArrayAdapter<String> adap=new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,mylist);
        adap.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);


        s.setAdapter(adap);

        s.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
       String value= adapterView.getItemAtPosition(i).toString();

        Toast.makeText(this,"You Selected "+value,Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
        Toast.makeText(this,"Nothing Selected ",Toast.LENGTH_SHORT).show();
    }
}
