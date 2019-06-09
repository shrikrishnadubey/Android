package com.example.admin.lpudemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertNull;
import static junit.framework.Assert.assertTrue;

public class CalledByIntent extends AppCompatActivity {
    String u;
IntentDemo d=new IntentDemo();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_called_by_intent);
        Intent i = getIntent();
       u = i.getStringExtra("username");
        Toast.makeText(this, u, Toast.LENGTH_SHORT).show();
    }
    @Test
   public void calltest() {
        assertEquals("admin",u);
    }
@Test
        public void clickcall()
{
            int a=d.call(100);
        //    assertEquals(100,a);
//assertTrue(false);
  //assertFalse(false);
            String s=null;
         assertNull(s);
        }



}
