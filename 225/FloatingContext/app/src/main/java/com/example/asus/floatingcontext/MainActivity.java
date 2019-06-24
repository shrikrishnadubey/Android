package com.example.asus.floatingcontext;

import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ActionMode;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    ImageView i1;
    Button b1;
    ActionMode am;
    ActionMode.Callback am1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        i1=(ImageView)findViewById(R.id.i1);
        b1=(Button)findViewById(R.id.b1);
        registerForContextMenu(i1);
        am1=new ActionMode.Callback() {
            @Override
            public boolean onCreateActionMode(ActionMode mode, Menu menu) {

                getMenuInflater().inflate(R.menu.my_menu,menu);
                menu.add(0,1,1,"Block");
                menu.add(0,2,2,"Delete Chat");
                return true;
            }

            @Override
            public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
                return false;
            }

            @Override
            public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
                return false;
            }

            @Override
            public void onDestroyActionMode(ActionMode mode) {

            }
        };

        b1.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                am=startActionMode(am1);
                return true;
            }
        });

    }
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        menu.add(0,1,1,"Save");
        menu.add(0,2,2,"Open");
        menu.add(0,3,3,"Close");
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {

        int k=item.getItemId();

        switch(k)
        {
            case 1:
                Toast.makeText(this, "Save", Toast.LENGTH_SHORT).show();
                break;
            case 2:
                Toast.makeText(this, "Open", Toast.LENGTH_SHORT).show();
                break;
            case 3:
                Toast.makeText(this, "Close", Toast.LENGTH_SHORT).show();
                break;
        }
        return true;
    }
}
