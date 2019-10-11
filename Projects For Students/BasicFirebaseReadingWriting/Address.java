package com.example.antisaby.myapplication;

public class Address
{
    public int apartment;
    public String street, city;

    public Address() //Empty constructor. REQUIRED.
    {

    }

    public Address(int apartment, String street, String city) //This constructor is optional.
    {
        this.apartment = apartment;
        this.street = street;
        this.city = city;
    }
}
