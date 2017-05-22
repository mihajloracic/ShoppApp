package com.example.mihajlo.shoppapp.database.dao;

import com.example.mihajlo.shoppapp.model.Item;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.RuntimeExceptionDao;

/**
 * Created by mihajlo on 5/22/2017.
 */

public class ItemDao extends RuntimeExceptionDao<Item,Long> {
    public ItemDao(Dao<Item, Long> dao) {
        super(dao);
    }
}
