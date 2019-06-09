package com.example.admin.lpudemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import org.junit.Test;

public class IntentDemo extends AppCompatActivity {
    EditText u, p;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent_demo);

        u = (EditText) findViewById(R.id.username);
        p = (EditText) findViewById(R.id.password);
    }

    public void gotonext(View v) {

        if (u.getText().toString().equals("admin") && p.getText().toString().equals("admin")) {
            Intent i = new Intent(this, CalledByIntent.class);
            i.putExtra("username", u.getText().toString());

            startActivity(i);
        } else {
            Toast.makeText(this, "Wrong Credentials", Toast.LENGTH_SHORT).show();
        }
    }
    int call(int i)
    {
        return i;
    }





}



