package com.example.alarmdemo;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by USER on 01-Mar-17.
 */

public class MyAsynTask extends AsyncTask<Void,Integer,String>{

    Context ct;
    ProgressDialog pd;

    public MyAsynTask(Context c)
    {
        ct =c;
    }

    @Override
    protected void onPreExecute() {
        pd = new ProgressDialog(ct);
        pd.setTitle("Downloading");
        pd.setMessage("Please wait");
        pd.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        pd.setMax(10);
        pd.setButton(ProgressDialog.BUTTON_NEGATIVE, "Cancel", new OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();

            }
        });

        pd.show();
    }

    @Override
    protected String doInBackground(Void... params) {

        try {
            for (int i = 0; i < 10; i++) {
                Thread.sleep(5000);
                Log.d("Thread", "Do in backgroung");
                publishProgress(i);
            }

        }catch (Exception e){e.printStackTrace();}

        return "Sucess";
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        int myvalue = values[0];
        pd.setProgress(myvalue);
        super.onProgressUpdate(values);
    }

    @Override
    protected void onPostExecute(String s) {
        Toast.makeText(ct,s,Toast.LENGTH_SHORT).show();
        pd.dismiss();
        super.onPostExecute(s);
    }
}
