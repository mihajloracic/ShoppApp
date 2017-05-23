package com.example.mihajlo.shoppapp.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.mihajlo.shoppapp.R;
import com.example.mihajlo.shoppapp.adapter.ItemListAdapter;
import com.example.mihajlo.shoppapp.repository.ItemDaoRepository;
import com.example.mihajlo.shoppapp.utils.LoggedInUser;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.OnActivityResult;
import org.androidannotations.annotations.ViewById;

@EActivity(R.layout.activity_my_account)
public class MyAccount extends AppCompatActivity {
    @ViewById
    ListView listviewMyAccount;

    @Bean
    ItemListAdapter adapter;

    @Bean
    ItemDaoRepository repository;

    @AfterViews
    void bindAdapter(){
        updateList();
    }

    void updateList(){
        adapter.setItems(repository.getItemsByUser(LoggedInUser.getInstance().getUser().getId()));
        listviewMyAccount.setAdapter(adapter);
    }
}
