package com.example.admin.lpudemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class CalledForResult extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_called_for_result);


        Intent i =new Intent();
        i.putExtra("result","result from another activity");
        setResult(1,i);
        finish();


    }
}
