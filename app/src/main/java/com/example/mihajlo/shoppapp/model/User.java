package com.example.mihajlo.shoppapp.model;

import com.example.mihajlo.shoppapp.utils.DatabaseConstants;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by mihajlo on 5/21/2017.
 */
@DatabaseTable(tableName = "user")
public class User {

    @DatabaseField(columnName = DatabaseConstants.USER_ID, generatedId = true)
    private int id;

    @DatabaseField(columnName = DatabaseConstants.USER_USER_NAME, unique = true,canBeNull = false)
    private  String username;

    @DatabaseField(columnName = DatabaseConstants.USER_PASSWORD)
    private String password;

    public User() {

    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("User{");
        sb.append("id=").append(id);
        sb.append(", username='").append(username).append('\'');
        sb.append(", password='").append(password).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
