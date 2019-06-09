package com.example.admin.lpudemo;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class ImplicitDemo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_implicit_demo);
    }

    public void gotourl(View v){

     //Intent i =new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.google.com"));
      Intent i =new Intent(Intent.ACTION_VIEW, Uri.parse("tel:8447718341"));
     //   Intent i =new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

        //Intent i =new Intent(this,CalledForResult.class);

        startActivityForResult(i,1);

    }
    public void gotocamera(View v){

        Intent i =new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(i,2);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==1) {
            String r = data.getStringExtra("result");
            Toast.makeText(this, r, Toast.LENGTH_SHORT).show();
        }
        if(requestCode==2) {

            Bitmap b = (Bitmap) data.getExtras().get("data");
ImageView image= (ImageView) findViewById(R.id.imageView);
            image.setImageBitmap(b);
            Toast.makeText(this, "camera was called", Toast.LENGTH_SHORT).show();
        }

    }
}
