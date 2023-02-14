package com.example.mysignuplogin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import javax.security.auth.login.LoginException;

public class signup extends AppCompatActivity {
    EditText username, password;
    int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        String usrname = getIntent().getStringExtra("userName");
        String pwd = getIntent().getStringExtra("pwd");

        Button buttonlogin = findViewById(R.id.lbutton);
        username = findViewById(R.id.lusername);
        password = findViewById(R.id.lpassword);

        buttonlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String uname = username.getText().toString();
                String pas = password.getText().toString();

                if(uname.equals(usrname) && pas.equals(pwd)){
                    Intent intent = new Intent(signup.this, welcome.class);
                    intent.putExtra("name", uname);
                    startActivity(intent);
                }
                else{
                    Toast.makeText(getApplicationContext(), "Login Failed", Toast.LENGTH_SHORT).show();

                }
                count++;
                if(count>2){
                    buttonlogin.setEnabled(false);
                }
            }
        });


    }
}