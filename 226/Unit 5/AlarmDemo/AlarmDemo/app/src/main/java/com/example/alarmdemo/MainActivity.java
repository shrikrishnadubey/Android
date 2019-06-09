package com.example.alarmdemo;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.SystemClock;
import android.provider.AlarmClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    AlarmManager alm;
    PendingIntent pi;
    MyAsynTask mst;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        alm = (AlarmManager) getSystemService(ALARM_SERVICE);
    }

    public void startalarm(View view)
    {
        Intent i = new Intent();
        i.setAction("mymessagedemo");

         pi = PendingIntent.getBroadcast(this,0,i,0);


       // alm.set(AlarmManager.ELAPSED_REALTIME_WAKEUP,SystemClock.elapsedRealtime()+(1000*5),pi);

        alm.setRepeating(AlarmManager.RTC_WAKEUP,SystemClock.elapsedRealtime(),5000,pi);

    }

    public void stopalarm(View view)
    {
        alm.cancel(pi);
        Toast.makeText(this,"Alarm cancelled",Toast.LENGTH_SHORT).show();

    }


    public void stopActivity(View view)
    {
      mst = new MyAsynTask(this);
      mst.execute();
    }
}
