package com.ebookfrenzy.mycustomdrwaing;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
pict v;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       v=new pict(this);
        setContentView(v);
    }
}
