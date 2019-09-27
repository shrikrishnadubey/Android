package com.example.sachin.progressbar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class CustomToast extends AppCompatActivity {

    private Button showToast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_toast);

        showToast = findViewById(R.id.showToast);
        showToast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                View view = getLayoutInflater().inflate(R.layout.toast,null);
                Toast toast = new Toast(CustomToast.this);
                toast.setDuration(Toast.LENGTH_LONG);
                toast.setGravity(Gravity.BOTTOM,0,200);
                toast.setView(view);
                toast.show();
            }
        });
    }
}
