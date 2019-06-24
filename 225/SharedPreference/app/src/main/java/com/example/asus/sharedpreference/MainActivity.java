package com.example.asus.sharedpreference;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button b1;
    Float text_size;
    int p;
    EditText t1;
    SeekBar s1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b1=(Button)findViewById(R.id.b1);
        t1=(EditText)findViewById(R.id.t1);
        s1=(SeekBar)findViewById(R.id.s1);


        s1.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                t1.setTextSize(progress);

                text_size=(t1.getTextSize());

                p=progress;


            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                seekBar.setProgress(p);
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        SharedPreferences sp1=getSharedPreferences("my_preference",MODE_PRIVATE);
        String s1=sp1.getString("k1",null);
        float a= sp1.getFloat("k2",2);
        p=sp1.getInt("k3",0);
        t1.setText(s1);
        t1.setTextSize(a);


    }



    public void doSave(View view)
    {
        SharedPreferences sp=getSharedPreferences("my_preference",MODE_PRIVATE);
        SharedPreferences.Editor spe=sp.edit();
        spe.putString("k1",t1.getText().toString());
        spe.putFloat("k2",text_size);
        spe.commit();

    }
}
