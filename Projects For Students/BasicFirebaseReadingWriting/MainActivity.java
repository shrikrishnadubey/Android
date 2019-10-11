package com.example.antisaby.myapplication;

import android.provider.Telephony;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
{

    /* We'll be creating the following JSON structure in this project.
    Make sure you setup Firebase while using this.

    {
        Name: "Jaspreet Singh",
        ID: 47,
        Courses:
        {
            0: "CSE101",
            1: "CSE102"
        },
        Address:
        {
            Apartment: 74,
            Street: "Julian Rd",
            City: "St. Petersburg"
        }
    }
     */

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final FirebaseDatabase database = FirebaseDatabase.getInstance(); //Setup the Firebase database. You can think of this like setting up a connection to the database.
        DatabaseReference rootRef = database.getReference(); //Get a reference to the root object.

        //This block of code writes the data to Firebase----------------------------------------------------------

        rootRef.child("Name").setValue("Jaspreet Singh");
        rootRef.child("ID").setValue(47);

        ArrayList<String> coursesList = new ArrayList<>(); //Create an empty ArrayList.
        coursesList.add("CSE101"); //Add the values to the list.
        coursesList.add("CSE102");
        rootRef.child("Courses").setValue(coursesList); //Add the list to Firebase

        Address address = new Address(4, "Julian Rd", "St. Petersburg"); //Create a new Address object.
        rootRef.child("Address").setValue(address); //Store the Address object in the Firebase database.
        //Writing part finishes here-------------------------------------------------------------------------------

        //Reading part starts here---------------------------------------------------------------------------------

        //Read "Name"
        DatabaseReference nameRef = rootRef.child("Name"); //First way to get a reference
        nameRef.addValueEventListener(new ValueEventListener()
        {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot)
            {
                Log.d("MainActivity", "Name: " + dataSnapshot.getValue(String.class));
            }

            @Override
            public void onCancelled(DatabaseError databaseError) { }
        });

        //Read "ID"
        DatabaseReference idRef = database.getReference().child("ID"); //Second way to get a reference
        idRef.addValueEventListener(new ValueEventListener()
        {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot)
            {
                Log.d("MainActivity", "ID: " + dataSnapshot.getValue(Integer.class));
            }

            @Override
            public void onCancelled(DatabaseError databaseError) { }
        });

        //Read the list of courses
        DatabaseReference coursesRef = database.getReference("Courses"); //Third way to get a reference
        coursesRef.addChildEventListener(new ChildEventListener()
        {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s)
            {
                Log.d("MainActivity", "Course: " + dataSnapshot.getValue(String.class));
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) { }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) { }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) { }

            @Override
            public void onCancelled(DatabaseError databaseError) { }
        });


        //Read the address
        final DatabaseReference addressRef = database.getReference("Address");
        addressRef.addValueEventListener(new ValueEventListener()
        {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot)
            {
                Address address = dataSnapshot.getValue(Address.class);
                Log.d("MainActivity", "Street: " + address.street);
                Log.d("MainActivity", "Apartment: " + address.apartment);
                Log.d("MainActivity", "City: " + address.city);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) { }
        });
    }

}
