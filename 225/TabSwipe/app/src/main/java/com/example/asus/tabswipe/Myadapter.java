package com.example.asus.tabswipe;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by ASUS on 09-04-2018.
 */

public class Myadapter extends FragmentStatePagerAdapter {

    public Myadapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {

        Fragment f1=null;
        switch(position)
        {
            case 0: new Fragment1();
                break;
            case 1:new Fragment2();
                break;
            case 2:new Fragment3();
                break;
        }
        return f1;
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        String s=" ";
        switch(position)
        {
            case 0 : s="Tab 1";
                break;
            case 1: s="Tab 2";
                break;
            case 2: s="Tab 3";
                break;
        }
        return s;
    }
}
