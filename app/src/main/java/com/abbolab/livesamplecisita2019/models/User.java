package com.abbolab.livesamplecisita2019.models;

import java.util.Date;

public class User extends Object {

    public String userName;
    public String surname;
    public Date dateRegistration;
    public boolean userVisibles;
    public int age;

    public User() {

        this.userName = "Name";
        this.surname = "Username";
        this.dateRegistration = new Date();
        this.userVisibles = false;
        this.age = 0;

    }
}
