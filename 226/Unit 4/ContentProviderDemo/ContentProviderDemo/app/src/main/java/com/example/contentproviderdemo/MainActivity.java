package com.example.contentproviderdemo;

import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText etname, etmob;
    Button bsave, bload;

    ContentValues cv = new ContentValues();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etname = findViewById(R.id.et11);
        etmob = findViewById(R.id.et12);

        bsave = findViewById(R.id.but11);

        bload = findViewById(R.id.but12);

        bsave.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                cv.put("name",etname.getText().toString());
                cv.put("mob",Integer.parseInt(etmob.getText().toString()));

               Uri uri = getContentResolver().insert(MyContentProvider.content_uri,cv);

                Toast.makeText(MainActivity.this,uri.toString(),Toast.LENGTH_SHORT).show();
            }
        });

        bload.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
              Cursor cr = getContentResolver().query(MyContentProvider.content_uri,null,null,null,"name");
              String s ="";
              while (cr.moveToNext())
              {
                  String s1 = cr.getString(0);
                  int a = cr.getInt(1);

                  s = s+ "Name is "+ s1+ " Pass is "+a +"\n";

              }
                Toast.makeText(MainActivity.this,s,Toast.LENGTH_SHORT).show();
            }
        });

    }

}
