package com.example.mihajlo.shoppapp.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.example.mihajlo.shoppapp.item.ItemView;
import com.example.mihajlo.shoppapp.item.ItemView_;
import com.example.mihajlo.shoppapp.model.Item;

import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.RootContext;

import java.util.List;

/**
 * Created by mihajlo on 5/21/2017.
 */
@EBean
public class ItemListAdapter extends BaseAdapter{

    List<Item> items;

    @RootContext
    Context context;

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return items.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ItemView itemView;
        if (convertView == null) {
            itemView = ItemView_.build(context);
        } else {
            itemView = (ItemView) convertView;
        }

        itemView.bind(items.get(position));

        return itemView;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }
}
