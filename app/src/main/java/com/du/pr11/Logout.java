package com.du.pr11;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Logout extends AppCompatActivity implements View.OnClickListener {

    private Button logout;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.logout);

        textView = findViewById(R.id.wlcm);
        Intent intent = getIntent();
        String username = intent.getStringExtra(Login.KEY);
        textView.setText("Welcome "+ username);

        logout = findViewById(R.id.logout);
        logout.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        ConfirmDialog confirmDialog = new ConfirmDialog();
        confirmDialog.show(getSupportFragmentManager(),"logout");
    }
}