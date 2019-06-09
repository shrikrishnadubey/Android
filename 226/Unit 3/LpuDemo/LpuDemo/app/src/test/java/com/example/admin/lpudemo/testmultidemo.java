package com.example.admin.lpudemo;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by subhita.menon on 26/04/2017.
 */

public class testmultidemo {
    @Test
    public void multitest()
    {
        multi m=new multi();
        int c=m.callmulti(2,2,2);
        assertEquals(8,c);
    }
}
