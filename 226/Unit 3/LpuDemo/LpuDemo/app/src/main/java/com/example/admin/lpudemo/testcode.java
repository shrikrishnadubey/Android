package com.example.admin.lpudemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class testcode extends AppCompatActivity  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_testcode);
       Button b = (Button) findViewById(R.id.button6);
       Button  b1 = (Button) findViewById(R.id.button7);


    }
    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void checksum()
    {

        testter t1 = new testter();

        int k =t1.sum(2,3);

        assertEquals(5,k);
    }
}
