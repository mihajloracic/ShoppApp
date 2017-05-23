package com.example.mihajlo.shoppapp.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mihajlo.shoppapp.R;
import com.example.mihajlo.shoppapp.model.User;
import com.example.mihajlo.shoppapp.repository.UserDaoRepository;
import com.example.mihajlo.shoppapp.utils.LoggedInUser;

import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

@EActivity(R.layout.activity_login)
public class LoginActivity extends AppCompatActivity {

    @ViewById
    EditText username;

    @ViewById
    EditText password;

    @Bean
    UserDaoRepository repository;

    @Override
    public void onBackPressed() {

    }

    @Click
    void continueAsGuest() {
        MainActivity_.intent(this).start();
    }

    @Click
    void login() {
        LoggedInUser.getInstance().setUser(repository.login(new User(username.getText().toString(), password.getText().toString())));
        User user = LoggedInUser.getInstance().getUser();
        if (LoggedInUser.getInstance().getUser() != null) {
            Toast.makeText(this, "Welcome " + username.getText().toString(), Toast.LENGTH_LONG).show();
            MainActivity_.intent(this).start();
        } else {
            Toast.makeText(this, "login fail", Toast.LENGTH_LONG).show();
        }
    }

    @Click
    void register() {
        RegistrationActivity_.intent(this).start();
    }
}
