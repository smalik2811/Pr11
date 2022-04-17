package com.du.pr11;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Login extends AppCompatActivity implements View.OnClickListener {
    static String KEY = "username";
    private Button login;
    private TextView username, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        username = findViewById(R.id.email);
        password = findViewById(R.id.password);

        login = findViewById(R.id.login);
        login.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Resources resources = getResources();
        String correctUsername = resources.getString(R.string.username);
        String correctPassword = resources.getString(R.string.password);

        String enteredUsername = username.getText().toString();
        String enteredPassword = password.getText().toString();

        if(enteredUsername.equals(correctUsername)){
            if(enteredPassword.equals(correctPassword)){
                Intent intent = new Intent(this, Logout.class);
                intent.putExtra(KEY,enteredUsername);
                startActivity(intent);
            }else{
                Toast.makeText(this,"Wrong Password",Toast.LENGTH_LONG).show();
            }
        }else{
            Toast.makeText(this,"Wrong Username",Toast.LENGTH_LONG).show();
        }
    }
}