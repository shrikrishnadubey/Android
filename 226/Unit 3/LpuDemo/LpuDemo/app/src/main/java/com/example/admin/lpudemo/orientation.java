package com.example.admin.lpudemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class orientation extends AppCompatActivity {
    Button b1;
    TextView tv1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orientation);
        tv1 =(TextView) findViewById(R.id.tv1);
        b1 = (Button)findViewById(R.id.but1);
    }

 // @Override
   // protected void onRestoreInstanceState(Bundle savedInstanceState) {
//
  //      int a = savedInstanceState.getInt("ID");

    //    tv1.setText(""+a);

    //}


    //@Override
    //protected void onSaveInstanceState(Bundle outState) {
      //  super.onSaveInstanceState(outState);

        //outState.putInt("ID",Integer.parseInt(tv1.getText().toString()));

//    }


    public void dothis(View v)
    {

        int a = Integer.parseInt(""+tv1.getText());
        a = a+1;
        tv1.setText("" +a);

    }

}
