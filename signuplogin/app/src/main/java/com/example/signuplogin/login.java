package com.example.signuplogin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class login extends AppCompatActivity {
    EditText username, password;
    int count =0;
    Button lbutton;
    String usrname, pwd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        String usrname = getIntent().getStringExtra("userName");
        String pwd = getIntent().getStringExtra("pwd");

        lbutton = findViewById(R.id.lbutton);
        username= findViewById(R.id.lusername);
        password = findViewById(R.id.lpassword);

        lbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String uname = username.getText().toString();
                String pas = password.getText().toString();

                if(uname.equals(usrname) && pas.equals(pwd)){
                    Intent intent = new Intent(login.this, welcome.class);
                    intent.putExtra("name", uname);
                    startActivity(intent);
                }
                else{
                    Toast.makeText(getApplicationContext(), "logun fgaield", Toast.LENGTH_SHORT).show();
                }
                count++;
                if(count>2)
                {
                    lbutton.setEnabled(false);
                }
            }
        });
    }
}