package com.example.signuplogin;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    String username, password;
    EditText etUsername, etPassword;
    Button buttonsignup;

    String regex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etUsername = findViewById(R.id.susername);
        etPassword = findViewById(R.id.spassword);
        Button buttonsigup =(Button) findViewById(R.id.sbutton);

        buttonsigup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                username = etUsername.getText().toString();
                password = etPassword.getText().toString();

                if(password.matches(regex)) {
                    Intent intent = new Intent(MainActivity.this, login.class);
                    intent.putExtra("userName", username);
                    intent.putExtra("pwd", password);
                    startActivity(intent);
                }
                else{
                    Toast.makeText(getApplicationContext(),"Your password does not match valid criteria", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}