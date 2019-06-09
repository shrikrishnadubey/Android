package com.example.admin.lpudemo;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class alarm extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm);
    }
    public void startalert(View v)
    {
        EditText text=(EditText)findViewById(R.id.et1);
        int i=Integer.parseInt(text.getText().toString());
        Intent intent=new Intent(this,mybroadcast.class);
        PendingIntent pendingIntent=PendingIntent.getBroadcast(this.getApplicationContext(),0,intent,0);
        AlarmManager alarmManager=(AlarmManager)getSystemService(ALARM_SERVICE);
        alarmManager.set(alarmManager.RTC_WAKEUP, System.currentTimeMillis()+(i*1000),pendingIntent);
        Toast.makeText(this,"alarm set in"+i+"seconds",Toast.LENGTH_SHORT).show();
 }
}
