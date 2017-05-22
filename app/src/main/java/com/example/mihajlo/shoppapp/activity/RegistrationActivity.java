package com.example.mihajlo.shoppapp.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mihajlo.shoppapp.R;
import com.example.mihajlo.shoppapp.model.User;
import com.example.mihajlo.shoppapp.repository.UserDaoRepository;

import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;
import org.w3c.dom.Text;

@EActivity(R.layout.activity_registration)
public class RegistrationActivity extends AppCompatActivity {

    @Bean
    UserDaoRepository repository;

    @ViewById
    EditText username;

    @ViewById
    EditText password;

    @ViewById
    EditText passwordRepeat;

    @Click
    void register(){
        if(username.getText().toString() == "" || password.getText().toString() == ""){
            Toast.makeText(this,"Please fill all the fields",Toast.LENGTH_LONG).show();
            return;
        }
        if(password.getText().toString().equals(passwordRepeat.getText().toString())){
            try{
                repository.create(new User(username.getText().toString(),password.getText().toString()));
                Toast.makeText(this,"User " + username.getText() + " was created",Toast.LENGTH_LONG).show();
                finish();
            }catch (Exception e){
                Toast.makeText(this,"Username " + username.getText() + " already taken",Toast.LENGTH_LONG).show();
            }

        }else{
            Toast.makeText(this,"Please type the same password",Toast.LENGTH_LONG).show();
        }
    }

}
