package com.example.swatishree.database1;

/**
 * Created by Swati Shree on 4/5/2018.
 */

public class Data {
    private String name, regNo, userName, password;

    public Data() {
    }

    public Data(String name, String regNo, String userName, String password) {
        this.name = name;
        this.regNo = regNo;
        this.userName = userName;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public String getRegNo() {
        return regNo;
    }

    public String getUserName() {
        return userName;
    }
}
