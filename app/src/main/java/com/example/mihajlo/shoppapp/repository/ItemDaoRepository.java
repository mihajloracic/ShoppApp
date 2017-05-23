package com.example.mihajlo.shoppapp.repository;

import com.example.mihajlo.shoppapp.database.DatabaseHelper;
import com.example.mihajlo.shoppapp.database.dao.ItemDao;
import com.example.mihajlo.shoppapp.model.Item;
import com.example.mihajlo.shoppapp.utils.DatabaseConstants;

import org.androidannotations.annotations.EBean;
import org.androidannotations.ormlite.annotations.OrmLiteDao;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by mihajlo on 5/22/2017.
 */
@EBean
public class ItemDaoRepository {
    @OrmLiteDao(helper = DatabaseHelper.class)
    ItemDao itemDao;

    public void create(Item item){
        itemDao.create(item);
    }

    public List<Item> getItemsByUser(int userid){
        List<Item> itemList = null;
        try {
            itemList = itemDao.queryBuilder().where().eq(DatabaseConstants.ITEM_USER,userid).query();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return itemList;
    }

    public List<Item> getItems(){
        return itemDao.queryForAll();
    }

    public ItemDao getItemDao() {
        return itemDao;
    }

    public void setItemDao(ItemDao itemDao) {
        this.itemDao = itemDao;
    }
}
