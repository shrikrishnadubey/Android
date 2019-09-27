package com.example.akashsingh.alertbox;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.regex.Matcher;

public class MainActivity extends AppCompatActivity {
    TextView t1;
    EditText e1,e2;
    Button b1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        t1=findViewById(R.id.t1);
        t1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder bd=new AlertDialog.Builder(MainActivity.this);
                View v1=getLayoutInflater().inflate(R.layout.dialogue_layout,null);
                bd.setTitle("Spinner in custom dialogue");
                Spinner spin=v1.findViewById(R.id.spin1);
                v1.findViewById(R.id.tv1);
                v1.findViewById(R.id.im1);
                ArrayAdapter<String> ad=new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_spinner_dropdown_item,getResources().getStringArray(R.array.Language));
                spin.setAdapter(ad);
                bd.setCancelable(false);
                bd.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        final AlertDialog.Builder bd2=new AlertDialog.Builder(MainActivity.this);
                        bd2.setTitle("Choose any one of them");
                        bd2.setCancelable(false);
                        bd2.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                                AlertDialog.Builder ad=new AlertDialog.Builder(MainActivity.this);
                                ad.setTitle("Single choice item");
                                ad.setSingleChoiceItems(getResources().getStringArray(R.array.Language), 0, new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {

                                        Toast.makeText(MainActivity.this,"ok",Toast.LENGTH_LONG).show();
                                    }
                                });
                                AlertDialog d11=ad.create();
                                d11.show();
                            }
                        });
                        bd2.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                AlertDialog.Builder ad2=new AlertDialog.Builder(MainActivity.this);
                                ad2.setTitle("Multiple choice item");

                                ad2.setMultiChoiceItems(getResources().getStringArray(R.array.Language), null, new DialogInterface.OnMultiChoiceClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                                        Toast.makeText(MainActivity.this,"Cancel",Toast.LENGTH_LONG).show();
                                    }
                                });
                                AlertDialog d22=ad2.create();
                                d22.show();
                            }
                        });
                        bd2.setNeutralButton("Neutral", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                                Toast.makeText(MainActivity.this,"Neutral",Toast.LENGTH_LONG).show();
                                AlertDialog.Builder ad3=new AlertDialog.Builder(MainActivity.this);
                                ad3.setTitle("ListView items");
                                ad3.setItems(getResources().getStringArray(R.array.Language), new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {

                                    }
                                });
                                AlertDialog d33=ad3.create();
                                d33.show();
                            }
                        });
                        AlertDialog d1=bd2.create();
                        d1.show();
                    }
                });
                bd.setNegativeButton("Login page", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        AlertDialog.Builder lg=new AlertDialog.Builder(MainActivity.this);
                        View v2=getLayoutInflater().inflate(R.layout.login,(ViewGroup)findViewById(R.id.l1));
                        lg.setTitle("Login");
                        e1=v2.findViewById(R.id.edit1);
                        e2=v2.findViewById(R.id.edit2);
                        b1=v2.findViewById(R.id.btn2);
                        b1.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                if(e1.getText().toString().equals(e2.getText().toString()))
                                {
                                    Toast.makeText(MainActivity.this, "Login Successfull", Toast.LENGTH_SHORT).show();
                                }
                                else
                                {
                                    Toast.makeText(MainActivity.this, "Userid and password doesnot match", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
                        lg.setView(v2);
                        AlertDialog d=lg.create();
                        d.show();
                    }
                });
                bd.setNeutralButton("Toast", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        AlertDialog.Builder b=new AlertDialog.Builder(MainActivity.this);
                        View q=getLayoutInflater().inflate(R.layout.toastlayout,(ViewGroup)findViewById(R.id.t11));
                        b.setView(q);
                        AlertDialog d1=b.create();
                        d1.show();

                    }

                });
                bd.setView(v1);
                AlertDialog dialog = bd.create();
                dialog.show();
            }
        });
    }
}
