package com.example.mihajlo.shoppapp.repository;

import android.widget.Toast;

import com.example.mihajlo.shoppapp.database.DatabaseHelper;
import com.example.mihajlo.shoppapp.database.dao.UserDao;
import com.example.mihajlo.shoppapp.model.User;
import com.example.mihajlo.shoppapp.utils.DatabaseConstants;
import com.j256.ormlite.table.TableUtils;

import org.androidannotations.annotations.EBean;
import org.androidannotations.ormlite.annotations.OrmLiteDao;

import java.sql.SQLException;

/**
 * Created by mihajlo on 5/21/2017.
 */
@EBean
public class UserDaoRepository {

    @OrmLiteDao(helper = DatabaseHelper.class)
    UserDao userDao;

    public void create(User user){
        userDao.create(user);
    }

    public User login(User user){
        try {
            User databaseUser = userDao.queryBuilder().where().eq(DatabaseConstants.USER_USER_NAME,user.getUsername()).queryForFirst();
            if (databaseUser == null){
                return  null;
            }
            if(databaseUser.getPassword().equals(user.getPassword())){
                return user;
            }else{
                return databaseUser;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
}
