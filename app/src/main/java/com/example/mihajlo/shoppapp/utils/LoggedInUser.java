package com.example.mihajlo.shoppapp.utils;

import com.example.mihajlo.shoppapp.model.User;

/**
 * Created by mihajlo on 5/22/2017.
 */

public class LoggedInUser {

    static LoggedInUser u = null;

    static User user;

    public static LoggedInUser getInstance(){
        if(u == null){
            u = new LoggedInUser();
        }
        return u;
    }

    protected  LoggedInUser(){
        user = new User();
    }

    public static User getUser() {
        return user;
    }

    public static void setUser(User user) {
        LoggedInUser.user = user;
    }
}
