package com.example.admin.lpudemo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class mybroadcast extends BroadcastReceiver {
    public mybroadcast() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.
        Toast.makeText(context,"charging",Toast.LENGTH_SHORT).show();
    }
}
