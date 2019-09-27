package com.example.asus.alertcustom;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void Click(View v)
    {
        final Dialog ad1=new Dialog(this);
        View v1=getLayoutInflater().inflate(R.layout.new_layout,null);
        ad1.setContentView(v1);
        final EditText e1=(EditText)v1.findViewById(R.id.e1);
        final EditText e2=(EditText)v1.findViewById(R.id.e2);
        final EditText e3=(EditText)v1.findViewById(R.id.e3);
        Button b2= (Button)v1.findViewById(R.id.bt1);
        Button b3=(Button)v1.findViewById(R.id.bt2);


        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if(e2.getText().toString().equals(e3.getText().toString()))
                {
                    Intent m1=new Intent(MainActivity.this,Profile.class);
                    m1.putExtra("a",e1.getText().toString());
                    m1.putExtra("b",e2.getText().toString());
                    startActivity(m1);
                }
                else
                Toast.makeText(MainActivity.this,"Passwords are not same",Toast.LENGTH_LONG).show();
            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"Cancel",Toast.LENGTH_LONG).show();
            }
        });

        ad1.show();
    }

}

