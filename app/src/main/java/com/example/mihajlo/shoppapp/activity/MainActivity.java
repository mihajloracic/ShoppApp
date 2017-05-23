package com.example.mihajlo.shoppapp.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.mihajlo.shoppapp.R;
import com.example.mihajlo.shoppapp.adapter.ItemListAdapter;
import com.example.mihajlo.shoppapp.model.Item;
import com.example.mihajlo.shoppapp.repository.ItemDaoRepository;
import com.example.mihajlo.shoppapp.utils.LoggedInUser;

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
    GridView listview;

    @Bean
    ItemListAdapter adapter;

    @Bean
    ItemDaoRepository repository;

    @AfterViews
    void bindAdapter(){
        updateList();
        listview.setNumColumns(2);

    }

    private void setNumCols(){
        if(listview.getNumColumns() == 1){
            listview.setNumColumns(2);
        }else{
            listview.setNumColumns(1);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.logut:
                LoggedInUser.getInstance().setUser(null);
                LoginActivity_.intent(this).start();
                return true;
            case R.id.myAccount:
                if(LoggedInUser.getInstance().getUser() !=null){
                    MyAccount_.intent(this).startForResult(0);
                }else{
                    Toast.makeText(this,"Please login to view your account",Toast.LENGTH_LONG).show();
                }

                return true;
            case R.id.order:
                setNumCols();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onBackPressed() {

    }

    @Click
    void fab(){
        if(LoggedInUser.getInstance().getUser() != null){
            NewItem_.intent(this).startForResult(0);
        }else{
            Toast.makeText(this,"Please login to add posts",Toast.LENGTH_LONG).show();
        }
    }
    @OnActivityResult(0)
    void updateList(){
        adapter.setItems(repository.getItems());
        listview.setAdapter(adapter);
    }
}
