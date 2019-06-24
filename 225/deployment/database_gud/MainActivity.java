package com.example.swatishree.database1;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText name, registrationNumber, username, password;
    Button update;

    MyDataBase myDataBase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myDataBase = new MyDataBase(this);

        name = (EditText)findViewById(R.id.name);
        registrationNumber = (EditText)findViewById(R.id.registration);
        username = (EditText)findViewById(R.id.username);
        password = (EditText)findViewById(R.id.password);

        update = (Button)findViewById(R.id.update);

        findViewById(R.id.save).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Data Inserted", Toast.LENGTH_SHORT).show();
                myDataBase.InsertValues(name.getText().toString(), registrationNumber.getText().toString(), username.getText().toString(), password.getText().toString());
            }
        });

        findViewById(R.id.show).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Cursor res = myDataBase.getAllData();

                if (res.getCount() == 0) {
                    showMessage("Error", "Nothing Found");
                }

                StringBuffer buffer = new StringBuffer();

                while (res.moveToNext()) {
                    buffer.append("Name: " + res.getString(0) + "\n");
                    buffer.append("RegistrationNumber: " + res.getString(1) + "\n");
                    buffer.append("UserName: " + res.getString(2) + "\n");
                    buffer.append("Password: " + res.getString(3) + "\n");
                }

                showMessage("Data", buffer.toString());
            }
        });

        findViewById(R.id.search).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                @SuppressLint("InflateParams")
                View view = getLayoutInflater().inflate(R.layout.search, null);

                final EditText search = (EditText)view.findViewById(R.id.search);

                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Search");
                builder.setPositiveButton("Search", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Data data = myDataBase.SearchData(search.getText().toString());
                        StringBuffer buffer = new StringBuffer();
                        buffer.append("Name: " + data.getName() + "\n");
                        buffer.append("RegistrationNumber: " + data.getRegNo() + "\n");
                        buffer.append("UserName: " + data.getUserName() + "\n");
                        buffer.append("Password: " + data.getPassword() + "\n");
                        showMessage("Search Data", buffer.toString());
                    }
                });
                builder.setView(view);
                AlertDialog alertDialog = builder.create();
                alertDialog.show();
            }
        });

        findViewById(R.id.delete).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                View view = getLayoutInflater().inflate(R.layout.search, null);

                final EditText search = (EditText)view.findViewById(R.id.search);

                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Delete By Registration Number");

                builder.setPositiveButton("Delete", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        myDataBase.deleteValues(search.getText().toString());

                        Toast.makeText(MainActivity.this, "Data Deleted", Toast.LENGTH_SHORT).show();
                    }
                });
                builder.setView(view);
                AlertDialog alertDialog = builder.create();
                alertDialog.show();

            }
        });

        findViewById(R.id.update).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                View view = getLayoutInflater().inflate(R.layout.update, null);

                final EditText search = (EditText)view.findViewById(R.id.registration);
                final EditText updatename = (EditText)view.findViewById(R.id.updateName);

                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Delete By Registration Number");

                builder.setPositiveButton("Update", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        myDataBase.updateValues(search.getText().toString(),updatename.getText().toString());

                        Toast.makeText(MainActivity.this, "Data updated", Toast.LENGTH_SHORT).show();
                    }
                });
                builder.setView(view);
                AlertDialog alertDialog = builder.create();
                alertDialog.show();

            }
        });
    }

    public void showMessage(String data, String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle(data);
        builder.setMessage(message);
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }
}