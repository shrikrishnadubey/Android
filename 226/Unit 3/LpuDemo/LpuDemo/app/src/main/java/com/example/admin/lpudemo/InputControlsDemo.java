package com.example.admin.lpudemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class InputControlsDemo extends AppCompatActivity {
    CheckBox chb1, chb2, chb3;
    RadioGroup rg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_controls_demo);
        chb1 = (CheckBox) findViewById(R.id.checkBox);
        chb3 = (CheckBox) findViewById(R.id.checkBox3);
        chb2 = (CheckBox) findViewById(R.id.checkBox2);


        rg = (RadioGroup) findViewById(R.id.rgroup);


    }

    public void getChecked(View v) {
        if (chb1.isChecked()) {
            Toast.makeText(this, "u selected Politics", Toast.LENGTH_SHORT).show();
        }
        if (chb2.isChecked()) {
            Toast.makeText(this, "u selected IT", Toast.LENGTH_SHORT).show();
        }
        if (chb3.isChecked()) {
            Toast.makeText(this, "u selected Entertainment", Toast.LENGTH_SHORT).show();
        }

    }

    public void getRadio(View v) {
        int i = rg.getCheckedRadioButtonId();

        RadioButton rb = (RadioButton) findViewById(i);
        Toast.makeText(this, rb.getText().toString(), Toast.LENGTH_SHORT).show();
    }
}