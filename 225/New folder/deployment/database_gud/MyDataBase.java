package com.example.swatishree.database1;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.view.View;

public class MyDataBase extends SQLiteOpenHelper {

    public MyDataBase(Context context) {
        super(context, "DataBase", null, 1);
    }

//    public MyDataBase(Context context, String name, SQLiteDatabase.CursorFactory factory, int version, DatabaseErrorHandler errorHandler) {
//        super(context, name, factory, version, errorHandler);
//    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String createTable = "CREATE TABLE DATA (NAME VARCHAR,REGISTRATION_NUMBER VARCHAR,USERNAME VARCHAR,PASSWORD VARCHAR);";
        db.execSQL(createTable);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void InsertValues(String Name, String RegistrationNumber, String Username, String Password){

        String insertValues = "INSERT INTO DATA (NAME,REGISTRATION_NUMBER,USERNAME,PASSWORD) VALUES("+Name+","+RegistrationNumber+","+Username+","+Password+");";

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("NAME", Name);
        values.put("REGISTRATION_NUMBER", RegistrationNumber);
        values.put("USERNAME",Username);
        values.put("PASSWORD",Password);

        db.insert("DATA",null,values);
        db.close();
    }

    public Cursor getAllData(){

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor resultSet = db.rawQuery("Select * from DATA",null);

        return resultSet;
    }

    public Data SearchData(String value){

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor resultSet = null;
        try {
            resultSet = db.rawQuery("Select * from DATA WHERE REGISTRATION_NUMBER IS " + value, null);
            resultSet.moveToLast();
            return new Data(resultSet.getString(0), resultSet.getString(1), resultSet.getString(2), resultSet.getString(3));
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(resultSet != null) resultSet.close();
            db.close();
        }
        return null;
    }

    public void updateValues(String s1,String s2){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("NAME", s2);

        String value[] = {s1};

        db.update("DATA",values,"REGISTRATION_NUMBER=?",value);

    }

    public void deleteValues(String registrationNumber){

        SQLiteDatabase db = this.getWritableDatabase();

        String value[]={registrationNumber};

        db.delete("DATA","REGISTRATION_NUMBER=?",value);
    }

}

