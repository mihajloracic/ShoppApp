package com.example.mihajlo.shoppapp.database.dao;

import com.example.mihajlo.shoppapp.model.User;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.RuntimeExceptionDao;

/**
 * Created by mihajlo on 5/21/2017.
 */

public class UserDao extends RuntimeExceptionDao<User,Long>{
    public UserDao(Dao<User, Long> dao) {
        super(dao);
    }
}
