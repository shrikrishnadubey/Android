package com.example.hp.storage;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.Toast;

/**
 * Created by hp on 23-04-2018.
 */
        import android.content.Context;
        import android.content.SharedPreferences;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.MenuItem;
        import android.view.View;
        import android.widget.AdapterView;
        import android.widget.AdapterView.OnItemClickListener;
        import android.widget.Button;
        import android.widget.EditText;
        import android.widget.ListView;
        import android.widget.PopupMenu;
        import android.widget.PopupMenu.OnMenuItemClickListener;
        import android.widget.SeekBar;
        import android.widget.SeekBar.OnSeekBarChangeListener;
        import android.widget.Toast;

public class SharedPreference extends AppCompatActivity {

    EditText etmessage;
    SeekBar sb;

    float text_size;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_preference);

        etmessage = (EditText)findViewById(R.id.etmesssage);
        sb = (SeekBar) findViewById(R.id.sb);


        SharedPreferences sp = getSharedPreferences("my_pref", Context.MODE_PRIVATE);
        String s1 = sp.getString("K1","");
        float f = sp.getFloat("K2",0);
        etmessage.setTextSize(f);
        etmessage.setText(s1);


        sb.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {


                text_size = etmessage.getTextSize()+i;

                etmessage.setTextSize(text_size);

                Toast.makeText(getApplicationContext(),"Text size is"+ text_size+" i is"+i,Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }

    public void dosave(View v)
    {
        SharedPreferences sp = getSharedPreferences("my_pref",Context.MODE_PRIVATE);

        SharedPreferences.Editor spe = sp.edit();

        Toast.makeText(this,"Text size id on Create is "+etmessage.getTextSize(),Toast.LENGTH_SHORT).show();
        spe.putString("K1",etmessage.getText().toString());
        spe.putFloat("K2",etmessage.getTextSize());


        spe.commit();

        Toast.makeText(this,"Data Saved", Toast.LENGTH_SHORT).show();
    }



}
