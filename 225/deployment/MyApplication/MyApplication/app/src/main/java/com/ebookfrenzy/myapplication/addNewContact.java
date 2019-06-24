package com.ebookfrenzy.myapplication;

import android.support.v4.widget.SimpleCursorAdapter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class addNewContact extends AppCompatActivity {
    DbAdapter db;
    SimpleCursorAdapter adapter;
    EditText etname,etnumber,etemail,etaddress;
    String name,number,email,address;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_contact);
        db = new DbAdapter(this);
        db.open();
        //get data from text feld
        etname =(EditText)findViewById(R.id.name);
        etnumber =(EditText)findViewById(R.id.number);
        etemail =(EditText)findViewById(R.id.email);
        etaddress = (EditText)findViewById(R.id.address);
    }
    public void Save(View v){
        if(db.isExist(number)){
            Toast.makeText(getApplicationContext(),"already exist", Toast.LENGTH_SHORT).show();
        }else{
            name=etname.getText().toString();
            number=etnumber.getText().toString();
            email=etemail.getText().toString();
            address=etaddress.getText().toString();
            db.insert(name,number,email,address);
            Toast.makeText(getApplicationContext(),"Contact added", Toast.LENGTH_SHORT).show();
        } }
}
