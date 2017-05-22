package com.example.mihajlo.shoppapp.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mihajlo.shoppapp.R;
import com.example.mihajlo.shoppapp.model.Item;
import com.example.mihajlo.shoppapp.repository.ItemDaoRepository;

import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

import java.util.Date;

@EActivity(R.layout.activity_new_item)
public class NewItem extends AppCompatActivity {
    @ViewById
    EditText name;

    @ViewById
    EditText description;

    @ViewById
    EditText price;

    @Bean
    ItemDaoRepository repository;

    @Click
    void post(){
        if(name.getText().toString() != ""){
            repository.create(new Item(name.getText().toString(),description.getText().toString(),
                    new Date().toString(),price.getText().toString(),0));
            finish();
        }else{
            Toast.makeText(this,"Please fill all the fileds",Toast.LENGTH_LONG).show();
        }
    }

}
