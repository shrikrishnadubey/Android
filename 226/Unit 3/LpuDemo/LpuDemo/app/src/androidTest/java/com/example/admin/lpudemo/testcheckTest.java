package com.example.admin.lpudemo;

import android.support.test.rule.ActivityTestRule;
import android.view.View;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by subhita.menon on 01/03/2018.
 */
public class testcheckTest {
    @Rule
    ActivityTestRule<testcheck> ac=new
            ActivityTestRule<testcheck>
            (testcheck.class);
    private testcheck t=null;
@Before
public void setUp() throws Exception
{
t=ac.getActivity();
}
@Test
public void testLaunch() throws Exception{
    View v= t.findViewById(R.id.b1);
}
@After
public void tearDown() throws  Exception {

    ac=null;
}}