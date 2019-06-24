package com.example.akashsingh.context_menu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ActionMode;
import android.view.ActionMode.Callback;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView tv1;
    Button bt;
    ActionMode am;
    //ActionMode.Callback amc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       tv1= findViewById(R.id.tv);
       bt=findViewById(R.id.btn);
       registerForContextMenu(tv1);
       bt.setOnLongClickListener(new View.OnLongClickListener() {
           @Override
           public boolean onLongClick(View v) {
              am=startActionMode(amc);
              return true;
           }
       });
       bt.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               PopupMenu pm=new PopupMenu(MainActivity.this,v);
               getMenuInflater().inflate(R.menu.menu,pm.getMenu());
               pm.show();
               pm.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                   @Override
                   public boolean onMenuItemClick(MenuItem item) {
                       int k=item.getItemId();
                       switch (k)
                       {

                       }
                       return false;
                   }
               });
           }
       });
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        getMenuInflater().inflate(R.menu.menu,menu);
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        int k=item.getItemId();
        switch(k)
        {
            case 0:
                Toast.makeText(this, ""+item.getTitle(), Toast.LENGTH_SHORT).show();
                break;
            case 1:
                Toast.makeText(this, ""+item.getTitle(), Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onContextItemSelected(item);
    }

    ActionMode.Callback amc=new Callback() {
        @Override
        public boolean onCreateActionMode(ActionMode mode, Menu menu) {
            menu.add(0,1,0,"Add");
            menu.add(0,2,1,"Download");
            menu.add(0,3,2,"Delete");
//            menu.add(0,4,3,"Delete");
            mode.setTitle("Demo of Context Acton Mode");
            mode.setSubtitle("Subtitle");
            return true;
        }

        @Override
        public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
            return false;
        }

        @Override
        public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
            Toast.makeText(MainActivity.this, ""+item.getTitle(), Toast.LENGTH_SHORT).show();
            return false;
        }

        @Override
        public void onDestroyActionMode(ActionMode mode) {

        }
    };

}
