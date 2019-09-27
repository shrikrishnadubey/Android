package com.example.sachin.progressbar;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button button;
    private Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);

                View view = getLayoutInflater().inflate(R.layout.dialoge_box,null);

                builder.setTitle("Alert Dialoge Box");
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        Toast.makeText(MainActivity.this, "Yes Button", Toast.LENGTH_SHORT).show();
                        AlertDialog.Builder builder1 = new AlertDialog.Builder(MainActivity.this);
                        builder1.setView(R.layout.dialoge_box);
                        builder1.setTitle("Second Dialoge Box");

                        AlertDialog alertDialog = builder1.create();
                        alertDialog.show();
                    }
                });

                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this, "No Button", Toast.LENGTH_SHORT).show();
                        dialog.dismiss();
                    }
                });

                String[] values = {"c","c++"};
                spinner = view.findViewById(R.id.spinner);
                ArrayAdapter<String> adapter  = new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_list_item_1,values);
                spinner.setAdapter(adapter);
                spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        switch (position){
                            case 0:
                                Toast.makeText(MainActivity.this, "C language", Toast.LENGTH_LONG).show();
                                break;

                            case 1:
                                Toast.makeText(MainActivity.this, "C language", Toast.LENGTH_LONG).show();
                                break;

                        }
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });

                builder.setView(view);
                AlertDialog alertDialog = builder.create();
                alertDialog.show();
            }
        });
    }
}
