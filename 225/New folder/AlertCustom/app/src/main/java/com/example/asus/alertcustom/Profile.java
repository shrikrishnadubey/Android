package com.example.asus.alertcustom;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Profile extends AppCompatActivity {


    TextView t1;
    String name,pass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        t1=(TextView)findViewById(R.id.t1);
        Intent m1=getIntent();
        name=m1.getStringExtra("a");
        pass=m1.getStringExtra("b");
        t1.setText("Welcome "+name+" password is: "+pass);
    }
}
