package com.example.asus.customtoast;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void click(View view)
    {
        View v1=getLayoutInflater().inflate(R.layout.toast_activity,null);

        Toast t=new Toast(this);
        t.setView(o);

        t.setDuration(Toast.LENGTH_LONG);
        t.setGravity(Gravity.TOP,50,700);
        t.show();
    }
}
