package com.example.akashsingh.frag_examp;

import android.support.v4.app.Fragment;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Frag2 extends Fragment {
    EditText editText1,editText2,editText3;
    Button button;
    String nm,passw,cnf;
    public View onCreateView(LayoutInflater inflater,ViewGroup container, Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.activity_frag2,container,false);
        editText1=v.findViewById(R.id.name2);
        editText2=v.findViewById(R.id.pwd2);
        editText3=v.findViewById(R.id.pwd);
        button=v.findViewById(R.id.signup);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nm=editText1.getText().toString();
                passw=editText2.getText().toString();
                cnf=editText3.getText().toString();
                if(!cnf.equals(passw)||passw.isEmpty()||cnf.isEmpty()||nm.isEmpty())
                {
                    Toast.makeText(getContext(), "pwd does not match", Toast.LENGTH_SHORT).show();

                }
                else if(cnf.equals(passw))
                {
                    Toast.makeText(getContext(), ""+nm+ "\n"+passw, Toast.LENGTH_SHORT).show();
                }
            }
        });
        return v;
    }
}
