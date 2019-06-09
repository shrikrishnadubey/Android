package com.example.admin.lpudemo;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

public class customlayout extends AppCompatActivity {
    Button b1, b11,b22;
    RelativeLayout rl;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customlayout);
        b1 = (Button) findViewById(R.id.but7);
        rl = (RelativeLayout)findViewById(R.id.activity_customlayout);
    }
    public void dothis(View v)
    {
        /*
        Toast.makeText(this,"Clicked..",Toast.LENGTH_SHORT).show();

        final AlertDialog.Builder adb = new AlertDialog.Builder(this);

        adb.setIcon(R.drawable.lpu);
        adb.setTitle("My Alert Dialog");
        adb.setMessage("Are you want to Exit? ");
        adb.setCancelable(false);

        adb.setNegativeButton("No", new OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(),"No Clicked"+ which,Toast.LENGTH_SHORT).show();
                dialog.cancel();
            }
        });

        adb.setPositiveButton("Yes", new DialogInterface.OnClickListener()
        {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                Toast.makeText(getApplicationContext(),"Yes Clicked"+ which,Toast.LENGTH_SHORT).show();
                //finish();

            }
        });

        adb.setNeutralButton("May be", new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(),"May be clicked"+ which,Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        });

        adb.create();
        adb.show();*/
        /*

        AlertDialog.Builder adb = new AlertDialog.Builder(this);
        View v1 = getLayoutInflater().inflate(R.layout.mylayout,null);
        adb.setView(v1);
        adb.setCancelable(false);

        adb.create();
        adb.show();


        if(v.getId() == R.id.b11)
        {
            Toast.makeText(this,"Cancel clicked", Toast.LENGTH_SHORT).show();

        }

        if(v.getId()==R.id.b22)
        {
            Toast.makeText(this,"Submit clicked", Toast.LENGTH_SHORT).show();
        }*/


        AlertDialog.Builder adb = new AlertDialog.Builder(this);

        LayoutInflater inflater = getLayoutInflater();

        View v1 = getLayoutInflater().inflate(R.layout.listitemlayout,null);
        adb.setView(v1);



        b11 = (Button)v1.findViewById(R.id.but8);
        b22 = (Button) v1.findViewById(R.id.but9);

        final AlertDialog dialog = adb.create();

        b11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        dialog.show();

    }

}






