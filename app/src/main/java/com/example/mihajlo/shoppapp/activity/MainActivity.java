package com.example.mihajlo.shoppapp.activity;

import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.GridView;
import android.widget.Toast;

import com.example.mihajlo.shoppapp.R;
import com.example.mihajlo.shoppapp.adapter.ItemListAdapter;
import com.example.mihajlo.shoppapp.repository.ItemDaoRepository;
import com.example.mihajlo.shoppapp.utils.LoggedInUser;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.OnActivityResult;
import org.androidannotations.annotations.OptionsItem;
import org.androidannotations.annotations.OptionsMenu;
import org.androidannotations.annotations.OptionsMenuItem;
import org.androidannotations.annotations.ViewById;

@EActivity(R.layout.activity_main)
@OptionsMenu(R.menu.menu)
public class MainActivity extends AppCompatActivity {

    @ViewById
    GridView listview;

    @Bean
    ItemListAdapter adapter;

    @OptionsMenuItem(R.id.logut)
    MenuItem logout;

    @Bean
    ItemDaoRepository repository;

    @OptionsItem(R.id.logut)
    void logout() {
        LoggedInUser.getInstance().setUser(null);
        LoginActivity_.intent(this).start();
    }

    @OptionsItem(R.id.order)
    void setOrder() {
        if(listview.getNumColumns() == 1){
            listview.setNumColumns(2);
        }else{
            listview.setNumColumns(1);
        }
    }

    @OptionsItem(R.id.myAccount)
    void myAccount(){
        if(LoggedInUser.getInstance().getUser() !=null){
            MyAccount_.intent(this).startForResult(0);
        }else{
            Toast.makeText(this,"Guest don't have items lists",Toast.LENGTH_LONG).show();
        }
    }

    @AfterViews
    void bindAdapter(){
        updateList();
        listview.setNumColumns(2);
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
