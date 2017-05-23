package com.example.mihajlo.shoppapp.utils;

import com.example.mihajlo.shoppapp.model.User;

/**
 * Created by mihajlo on 5/22/2017.
 */

public class LoggedInUser {

    static LoggedInUser u = null;

    User user;

    public static LoggedInUser getInstance(){
        if(u == null){
            u = new LoggedInUser();
        }
        return u;
    }

    protected  LoggedInUser(){

    }

    public User getUser() {
        return user;
    }

    public  void setUser(User user) {
        this.user = user;
    }
}
