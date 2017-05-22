package com.example.mihajlo.shoppapp.repository;

import com.example.mihajlo.shoppapp.database.DatabaseHelper;
import com.example.mihajlo.shoppapp.database.dao.ItemDao;
import com.example.mihajlo.shoppapp.model.Item;

import org.androidannotations.annotations.EBean;
import org.androidannotations.ormlite.annotations.OrmLiteDao;

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
