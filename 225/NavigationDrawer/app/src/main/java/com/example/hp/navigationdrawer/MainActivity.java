package com.example.hp.navigationdrawer;

        import android.support.annotation.NonNull;
        import android.support.design.widget.NavigationView;
        import android.support.design.widget.NavigationView.OnNavigationItemSelectedListener;
        import android.support.v4.view.GravityCompat;
        import android.support.v4.widget.DrawerLayout;
        import android.support.v4.widget.DrawerLayout.DrawerListener;
        import android.support.v7.app.ActionBar;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.support.v7.widget.Toolbar;
        import android.view.Gravity;
        import android.view.MenuItem;
        import android.view.View;
        import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    DrawerLayout dl;
    NavigationView nv;

    Toolbar tb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dl = (DrawerLayout)findViewById(R.id.draw_layout);
        nv = (NavigationView)findViewById(R.id.nav_view);

        tb =(Toolbar) findViewById(R.id.toolbar);

        setSupportActionBar(tb);

        ActionBar ab = getSupportActionBar();
        ab.setTitle("My App Bar");
        ab.setSubtitle("My Title");
        ab.setLogo(R.mipmap.ic_launcher);

        ab.setDisplayHomeAsUpEnabled(true);

        ab.setHomeAsUpIndicator(R.drawable.ic_launcher_foreground);


        nv.setNavigationItemSelectedListener(new OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                Toast.makeText(MainActivity.this, item.getTitle(), Toast.LENGTH_SHORT).show();

                item.setCheckable(false);
                dl.closeDrawers();

                return true;
            }
        });

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int k = item.getItemId();

        switch (k)
        {
            case android.R.id.home:
                dl.openDrawer(GravityCompat.START);
                break;
        }
        return true;
    }
}

