package com.example.asus.viewswipe;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by ASUS on 21-03-2018.
 */

public class MyAdapter extends FragmentStatePagerAdapter {


    public MyAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {

        /*Fragment1 f1= new Fragment1();
        Bundle b= new Bundle();

        b.putInt("k1",(position+1));
        f1.setArguments(b);
        return f1;*/

        Fragment f=null;
        switch(position)
        {
            case 0:f=new Fragment1();
                break;
            case 1:f=new Fragment2();
                break;
            case 2:f=new Fragment3();
                break;
            case 3:f=new Fragment4();
                break;
            case 4:f=new Fragment5();
                break;
        }
        return f;

    }

    @Override
    public int getCount() {
        return 5;
    }
}
