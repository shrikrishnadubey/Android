package com.example.akashsingh.internal_storage;

import android.content.Context;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import static android.os.Environment.getExternalStorageDirectory;
import static android.os.Environment.getExternalStoragePublicDirectory;
import static android.os.Environment.getExternalStorageState;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    EditText editText1,editText2;
    Button button1,button2;
    TextView textdisplay;
    String filename="myFile";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText1=findViewById(R.id.name);
        editText2=findViewById(R.id.mob);
        button1=findViewById(R.id.save);
        button2=findViewById(R.id.show);
        textdisplay=findViewById(R.id.textdisp);

    }

    public void dothis(View view) {
        int k=view.getId();
        try {
            switch (k) {
                case R.id.save:
                    String state=getExternalStorageState();
                    if(Environment.MEDIA_MOUNTED.equals(state)) {
                        Toast.makeText(this, "Storage Available", Toast.LENGTH_SHORT).show();
                        File f = getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM);


                        File dir = new File(f.getAbsolutePath() + "/mydir");
                        if (!dir.exists()) {
                            boolean b = dir.mkdir();
                            Toast.makeText(this, "Directory Created" + b, Toast.LENGTH_SHORT).show();
                        }
                        File file = new File(dir, "myfile1");
                        //file = new File(f, "myfile2");
                        FileOutputStream fileOutputStreamStream = new FileOutputStream(file);
                        String save = "\n" + editText1.getText().toString() + "" + editText2.getText().toString();
                        fileOutputStreamStream.write(save.getBytes());
                        fileOutputStreamStream.close();

//                        //-------For Internal Storage------//
//                        FileOutputStream fileOutputStreamStream = openFileOutput(filename, Context.MODE_APPEND);
//                        String save = "\n" + editText1.getText().toString() + "" + editText2.getText().toString();
//                        fileOutputStreamStream.write(save.getBytes());
//                        fileOutputStreamStream.close();
//                        Toast.makeText(this, "Data Saved", Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                        Toast.makeText(this, " No Storage avialable", Toast.LENGTH_SHORT).show();
                    }
                    break;
                case R.id.show:
                    FileInputStream fileInputStream=openFileInput(filename);
                    int i;

                    String display="";
                    while((i=fileInputStream.read()) !=-1)
                    {
                        display=display+(char)i;
                    }
                    textdisplay.setText(""+display);
                    break;
            }
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
