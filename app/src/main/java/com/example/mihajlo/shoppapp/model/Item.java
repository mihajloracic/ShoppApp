package com.example.mihajlo.shoppapp.model;

import com.example.mihajlo.shoppapp.utils.DatabaseConstants;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.sql.Date;

/**
 * Created by mihajlo on 5/21/2017.
 */
@DatabaseTable(tableName = "item")
public class Item {

    @DatabaseField(columnName = DatabaseConstants.IITEM_ID, generatedId = true)
    int id;

    @DatabaseField(columnName = DatabaseConstants.ITEM_NAME)
    String name;

    @DatabaseField(columnName = DatabaseConstants.ITEM_DESCRIPTION)
    String description;

    @DatabaseField(columnName = DatabaseConstants.ITEM_DATE)
    String date;

    @DatabaseField(columnName = DatabaseConstants.ITEM_PRICE)
    String price;

    @DatabaseField(columnName = DatabaseConstants.ITEM_USER)
    int user;

    public Item() {
    }

    public Item(String name, String description, String date, String price, int user) {
        this.name = name;
        this.description = description;
        this.date = date;
        this.price = price;
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public int getUser() {
        return user;
    }

    public void setUser(int user) {
        this.user = user;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Item{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", description='").append(description).append('\'');
        sb.append(", date='").append(date).append('\'');
        sb.append(", price='").append(price).append('\'');
        sb.append(", user=").append(user);
        sb.append('}');
        return sb.toString();
    }
}
