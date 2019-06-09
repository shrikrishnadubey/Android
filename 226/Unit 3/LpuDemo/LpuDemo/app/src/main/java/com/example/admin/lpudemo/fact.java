package com.example.admin.lpudemo;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

//import static junit.framework.Assert.*;


/**
 * Created by subhita.menon on 23/02/2018.
 */

public class fact {
        public int fact(int a) {
            int i, fact1 = 1;
            for (i = 1; i <= a; i++) {
                fact1 = fact1 * i;

            }
            return  fact1;
        }
@Test
     public    void hello()
            {
                assertEquals(120,fact(5));
               // assertEquals(6,fact(3));
            }

    @Test
    public void get()
{}

}