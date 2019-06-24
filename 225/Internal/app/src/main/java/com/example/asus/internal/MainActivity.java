package com.example.asus.internal;


import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class MainActivity extends AppCompatActivity {
    EditText e1,e2;
    TextView t1;
    Button b1,b2;
    ListView lv;

    String filename="myfile";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        e1=(EditText)findViewById(R.id.ed1);
        e2=(EditText)findViewById(R.id.ed2);
        t1=(TextView) findViewById(R.id.tv);
        b1=(Button)findViewById(R.id.but1);
        b2=(Button)findViewById(R.id.but2);

    }



    public void dothis(View view) {

        int k=view.getId();
        try{
            switch (k){
                case R.id.but1:
                    FileOutputStream fos= openFileOutput(filename, Context.MODE_PRIVATE);

                    String save=e1.getText().toString()+" "+ e2.getText().toString();

                    fos.write(save.getBytes());
                    fos.close();
                    Toast.makeText(this, "Data Saved ", Toast.LENGTH_SHORT).show();
                    break;

                case R.id.but2:

                    FileInputStream fis= openFileInput(filename);
                    int i;
                    String display= "";


                    while((i=fis.read()) !=-1){

                        display=display+(char)i;
                        t1.setText(display);

                    }


                    Toast.makeText(this, "Data Show", Toast.LENGTH_SHORT).show();


                    break;
            }


        }catch (Exception e){

            e.printStackTrace();

        }
    }

    private FileOutputStream openFileInput(String filename, int modePrivate) {
        return null;
    }
}