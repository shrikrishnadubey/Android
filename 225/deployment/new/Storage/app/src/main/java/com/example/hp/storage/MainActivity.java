package com.example.hp.storage;

import android.content.Context;
import android.content.Intent;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;


import static android.os.Environment.getExternalStorageDirectory;
import static android.os.Environment.getExternalStoragePublicDirectory;
import static android.os.Environment.getExternalStorageState;

public class MainActivity extends AppCompatActivity {

    EditText etname, etmob;
    Button bsave, bshow;
    TextView tvdisplay;

    String filename = "internalFile";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etname = (EditText) findViewById(R.id.etname);
        etmob = (EditText) findViewById(R.id.etmob);

        bsave = (Button) findViewById(R.id.butsave);
        bshow = (Button) findViewById(R.id.butshow);

        tvdisplay = (TextView) findViewById(R.id.tvdisplay);
    }

    public void dothis(View v) {
        int k = v.getId();
        try {
            switch (k) {
                case R.id.butsave:

                    /* //Internal Storage save button
                    FileOutputStream fos = openFileOutput(filename, Context.MODE_APPEND);
                    String save = "\n"+etname.getText().toString()+" "+ etmob.getText().toString();
                    fos.write(save.getBytes());
                    fos.close();
                    Toast.makeText(this, "Data Saved", Toast.LENGTH_SHORT).show();
                    //end of internal storage save button*/


                     //External Storage save button
                    String state  = getExternalStorageState();
                    if(Environment.MEDIA_MOUNTED.equals(state))
                    {
                        Toast.makeText(this,"Storage Available",Toast.LENGTH_SHORT).show();
                        File f = getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM);
                        File dir = new File(f.getAbsolutePath()+"/mydir");
                            if(! dir.exists())
                            {
                                boolean b = dir.mkdir();
                                Toast.makeText(this,"Directory Created" + b,Toast.LENGTH_SHORT).show();
                             }
                            File file = new File(dir, "ExternalFile");
                        FileOutputStream fos = new FileOutputStream(file);
                        String save = "\n"+etname.getText().toString()+" "+ etmob.getText().toString();
                        fos.write(save.getBytes());
                        fos.close();

                    }
                    else
                    {
                        Toast.makeText(this,"No External Storage Available",Toast.LENGTH_SHORT).show();
                    }
                    //end of external storage save button
                    break;

                case R.id.butshow:
                    /*//Internal storage show button
                    FileInputStream fis = openFileInput(filename);
                    int i;
                    String display = "";
                    while ((i = fis.read()) != -1)
                    {
                        display = display+(char)i;
                    }
                    tvdisplay.setText(display);
                    //end of internal storage show button*/


                    //External storage show button
                    File f = getExternalStorageDirectory();
                    FileInputStream fis = openFileInput(filename);

                    int i;
                    String display = "";
                    while ((i = fis.read()) != -1)
                    {
                        display = display+(char)i;
                    }
                    tvdisplay.setText(display);
                    //end of external storage show button*/

                    break;
            }
        }
        catch (Exception e){e.printStackTrace();}
    }

    public void openactivity(View view)
    {
        Intent i = new Intent(this,SharedPreference.class);
        startActivity(i);
    }
}
