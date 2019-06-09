package com.example.admin.lpudemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity  implements View.OnClickListener{
Button b,b1;
    TextView t;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b = (Button) findViewById(R.id.mybutton);
        b1 = (Button) findViewById(R.id.secondButon);

        b.setOnClickListener(this);
        b1.setOnClickListener(this);

        t=(TextView) findViewById(R.id.mytext);
    }


   @Override
    public void onClick(View view) {
       if( R.id.mybutton==view.getId()) {
          // Toast.makeText(this, "Increment clicked", Toast.LENGTH_SHORT).show();
String val=t.getText().toString();

          int myval= Integer.parseInt(val);
           myval=myval+1;
           t.setText(""+myval);
       }
        if( R.id.secondButon==view.getId()) {
          //  Toast.makeText(this, "Decrement clicked", Toast.LENGTH_SHORT).show();
            String val=t.getText().toString();

            int myval= Integer.parseInt(val);
            myval=myval-1;
            t.setText(""+myval);
        }
       }
}
