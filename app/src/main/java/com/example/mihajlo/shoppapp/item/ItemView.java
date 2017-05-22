package com.example.mihajlo.shoppapp.item;

import android.content.Context;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.mihajlo.shoppapp.R;
import com.example.mihajlo.shoppapp.model.Item;

import org.androidannotations.annotations.EViewGroup;
import org.androidannotations.annotations.ViewById;
import org.w3c.dom.Text;

/**
 * Created by mihajlo on 5/21/2017.
 */
@EViewGroup(R.layout.item_item)
public class ItemView extends LinearLayout{

    @ViewById
    TextView name;

    @ViewById
    TextView description;

    @ViewById
    TextView price;

    @ViewById
    TextView date;

    public void bind(Item item) {
        name.setText(item.getName());
        description.setText(item.getDescription());
        price.setText(item.getPrice());
        date.setText(item.getDate().toString());
    }

    public ItemView(Context context) {
        super(context);
    }
}
