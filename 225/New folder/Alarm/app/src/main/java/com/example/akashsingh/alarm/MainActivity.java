package com.example.akashsingh.alarm;

import android.app.AlarmManager;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.PendingIntent;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    static AlarmManager am;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        am = (AlarmManager) getSystemService(ALARM_SERVICE);
    }
        public void dothis(View v)
    {
//        Intent i=new Intent(this,MyReceiver.class);
//        i.setAction("My Alarm is ring");
//        PendingIntent pi=PendingIntent.getBroadcast(this,0,i,0);
//        am.setRepeating(AlarmManager.RTC_WAKEUP, SystemClock.elapsedRealtime(),1000*5,pi);
        DialogFragment newFragment=new TimePickerFragment();
        newFragment.show(getFragmentManager(),"timepicker");
    }
    public static class TimePickerFragment extends DialogFragment implements TimePickerDialog.OnTimeSetListener
    {
        int minute;

        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            final Calendar c=Calendar.getInstance();
            int hour = c.get(Calendar.HOUR_OF_DAY);
            minute = c.get(Calendar.MINUTE);
            TimePickerDialog tpd = new TimePickerDialog(getActivity(),this,hour,minute,true);

            return tpd;
        }

        @Override
        public void onTimeSet(TimePicker view, int hourOfDay, int m) {
            Intent i= new Intent(getActivity(),MyReceiver.class);
            i.setAction("My_ALARM_MSG");
            int diff=m-minute;
            Toast.makeText(getActivity(), ""+diff, Toast.LENGTH_SHORT).show();
            PendingIntent pi=PendingIntent.getBroadcast(getActivity(),0,i,0);
            am.setRepeating(AlarmManager.RTC_WAKEUP,System.currentTimeMillis(),1*diff,pi);
        }
    }
}

