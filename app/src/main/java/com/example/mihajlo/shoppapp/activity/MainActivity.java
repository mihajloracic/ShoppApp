package com.example.mihajlo.shoppapp.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.mihajlo.shoppapp.R;
import com.example.mihajlo.shoppapp.adapter.ItemListAdapter;
import com.example.mihajlo.shoppapp.model.Item;
import com.example.mihajlo.shoppapp.repository.ItemDaoRepository;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.OnActivityResult;
import org.androidannotations.annotations.ViewById;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Date;

@EActivity(R.layout.activity_main)
public class MainActivity extends AppCompatActivity {

    @ViewById
    ListView listview;

    @Bean
    ItemListAdapter adapter;

    @Bean
    ItemDaoRepository repository;

    @AfterViews
    void bindAdapter(){
        updateList();
        listview.setAdapter(adapter);
    }

    @Override
    public void onBackPressed() {

    }

    @Click
    void fab(){
        NewItem_.intent(this).startForResult(0);
    }
    @OnActivityResult(0)
    void updateList(){
        adapter.setItems(repository.getItems());
    }
}
