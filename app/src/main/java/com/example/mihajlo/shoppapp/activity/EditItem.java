package com.example.mihajlo.shoppapp.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

import com.example.mihajlo.shoppapp.R;
import com.example.mihajlo.shoppapp.model.Item;
import com.example.mihajlo.shoppapp.repository.ItemDaoRepository;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.Extra;
import org.androidannotations.annotations.ViewById;

@EActivity(R.layout.activity_edit_item)
public class EditItem extends AppCompatActivity {

    @Bean
    ItemDaoRepository repository;

    @Extra
    int itemId;

    Item item;

    @ViewById
    EditText name;

    @ViewById
    EditText description;

    @ViewById
    EditText price;

    @AfterViews
    void bind(){
        item = repository.getById(itemId);
        name.setText(item.getName());
        description.setText(item.getDescription());
        price.setText(item.getPrice());
    }

    @Click
    void delete(){
        repository.delete(itemId);
        finish();
    }

    @Click
    void update(){
        item.setName(name.getText().toString());
        item.setPrice(price.getText().toString());
        item.setDescription(description.getText().toString());
        repository.update(item);
        finish();
    }

}
