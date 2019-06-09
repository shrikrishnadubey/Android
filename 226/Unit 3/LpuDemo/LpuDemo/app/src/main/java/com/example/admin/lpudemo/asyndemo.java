package com.example.admin.lpudemo;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class asyndemo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_asyndemo);
        masyn a=new masyn();
        a.execute();

    }
    public class masyn extends AsyncTask<String,Void,String> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }
        @Override
        protected String doInBackground(String... params) {
            String data="data";
            return data;
        }
        @Override
        protected void onPostExecute(String s) {
            Toast.makeText(asyndemo.this,s,Toast.LENGTH_SHORT).show();
            super.onPostExecute(s);
        }
    }
}

