package com.haetae.eighthapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Button login = findViewById(R.id.login);
        EditText username = findViewById(R.id.textUsername);
        EditText password = findViewById(R.id.textPassword);
        CheckBox savePassword = findViewById(R.id.checkBox);
        SharedPreferences preferences = getSharedPreferences("login", 0);
        String username1 = preferences.getString("username", "");
        String password1 = preferences.getString("password", "");
        if (!"".equals(username1) && !"".equals(password1)) {
            Intent intent = new Intent(this,MainActivity.class);
            startActivity(intent);
        }
        SharedPreferences.Editor editor = preferences.edit();
        login.setOnClickListener(view -> {
            String name = username.getText().toString();
            String passwd = password.getText().toString();
            boolean savePasswordChecked = savePassword.isChecked();
            if (savePasswordChecked) {
                editor.putString("username",name);
                editor.putString("password",passwd);
                editor.commit();
            }
            Intent intent = new Intent(this,MainActivity.class);
            startActivity(intent);
        });
    }
}