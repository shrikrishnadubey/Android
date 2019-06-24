package com.example.asus.viewswipe;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 *
 *
 */
public class Fragment1 extends Fragment {

   ImageView t1;
    public Fragment1() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v=inflater.inflate(R.layout.fragment_fragment1, container, false);
        t1=(ImageView) v.findViewById(R.id.t1);

        /*Bundle b = getArguments();
        int a = b.getInt("k1");
        if(a==1)
        {
            t1.setImageResource(R.drawable.one);
        }

        else if(a==2)
        {
            t1.setImageResource(R.drawable.two);
        }

        else if(a==3)
        {
            t1.setImageResource(R.drawable.three);
        }
        else if(a==4)
        {
            t1.setImageResource(R.drawable.four);
        }
        else if(a==5)
        {
            t1.setImageResource(R.drawable.five);
        }
          */

        return v;
    }

}
