package com.example.akashsingh.frag_examp;

import android.support.v4.app.Fragment;
import android.app.FragmentManager;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Frag1 extends Fragment{
    EditText ed1,ed2;
    Button btn1;
    String name,pass;
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.activity_frag1,container,false);
        ed1=view.findViewById(R.id.name1);
        ed2=view.findViewById(R.id.pwd1);
        btn1=view.findViewById(R.id.login);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name=ed1.getText().toString();
                pass=ed2.getText().toString();
                Toast.makeText(getContext(), ""+name+ "\n"+pass, Toast.LENGTH_SHORT).show();

            }
        });
        return view;
    }
}
