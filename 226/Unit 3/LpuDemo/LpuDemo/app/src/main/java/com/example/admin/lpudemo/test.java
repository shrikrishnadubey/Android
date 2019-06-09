package com.example.admin.lpudemo;


import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by subhita.menon on 24/04/2017.
 */

public class test {
    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
    }


@Test

    public void checksum()throws Exception
    {

        testter t1 = new testter();

        int k =t1.sum(2,3);

       assertEquals(5,k);
    }
}
