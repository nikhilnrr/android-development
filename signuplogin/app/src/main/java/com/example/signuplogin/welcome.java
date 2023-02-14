package com.example.signuplogin;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class welcome extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        String wname = getIntent().getStringExtra("name");

        TextView uname = findViewById(R.id.name);
        uname.setText("Welcome" + wname);
    }
}