package com.example.mysignuplogin;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class welcome extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        String uname = getIntent().getStringExtra("name");
        TextView unmame = findViewById(R.id.name);
        unmame.setText("Hello. Welcome"+ uname);
    }
}