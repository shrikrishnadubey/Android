package com.example.asus.viewswipe;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    // Handler is used to display the toast/message when a worker thread completes its task.It runs in main thread.
    Handler obj =  new Handler(){
        @Override
        public void handleMessage(Message msg) {
            //super.handleMessage(msg);
            t1.setText("Updated!");
            Toast.makeText(MainActivity.this, "Completed!", Toast.LENGTH_SHORT).show();
        }
    };
    ViewPager vp;
    TextView t1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        vp=(ViewPager)findViewById(R.id.vp);
        t1=(TextView)findViewById(R.id.t1);
        MyAdapter mad = new MyAdapter(getSupportFragmentManager());
        vp.setAdapter(mad);

    }

    public void dothis(View v)
    {
        //Intent m=new Intent(MainActivity.this,Main2Activity.class);
        //startActivity(m);
        Runnable r=new Runnable() {
            @Override
            public void run() {
                int count=0;
                while(count<10)
                {
                    synchronized (this)
                    {
                        try {
                            Thread.sleep(1000);
                            count++;

                        }
                        catch (InterruptedException e)
                        {
                            e.printStackTrace();
                        }
                    }
                }

                       obj.sendEmptyMessage(0);
            }
        };

        Thread t=new Thread(r);
        t.start();


    }

    @Override
    public void onBackPressed() {
        //super.onBackPressed();

        AlertDialog.Builder ad1=new AlertDialog.Builder(this);

        ad1.setTitle("Alert");
        ad1.setIcon(R.mipmap.ic_launcher);
        ad1.setMessage("Are you sure?");

        ad1.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                finish();
            }
        });
        ad1.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                Toast.makeText(MainActivity.this,"Not Closing",Toast.LENGTH_LONG).show();

            }
        });

        ad1.show();

    }
}
