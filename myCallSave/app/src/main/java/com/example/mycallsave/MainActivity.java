package com.example.mycallsave;

import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    Button one, two, three, four, five, six, seven, eight, nine, zero, del, hash, star, call, save;
    EditText inputNum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        zero = findViewById(R.id.button0);
        one = findViewById(R.id.button1);
        two =findViewById(R.id.button2);
        three = findViewById(R.id.button3);
        four = findViewById(R.id.button4);
        five =findViewById(R.id.button5);
        six = findViewById(R.id.button6);
        seven =findViewById(R.id.button7);
        eight= findViewById(R.id.button8);
        nine = findViewById(R.id.button9);
        inputNum = findViewById(R.id.inputNum);
        star = findViewById(R.id.buttonstar);
        hash = findViewById(R.id.buttonhash);
        call = findViewById(R.id.buttoncall);
        save = findViewById(R.id.buttonsave);
        del = findViewById(R.id.buttondel);
        
        one.setOnClickListener(this::onClick);
        two.setOnClickListener(this::onClick);
        three.setOnClickListener(this::onClick);
        four.setOnClickListener(this::onClick);
        five.setOnClickListener(this::onClick);
        six.setOnClickListener(this::onClick);
        seven.setOnClickListener(this::onClick);
        eight.setOnClickListener(this::onClick);
        nine.setOnClickListener(this::onClick);
        zero.setOnClickListener(this::onClick);
        star.setOnClickListener(this::onClick);
        hash.setOnClickListener(this::onClick);
        call.setOnClickListener(this::onClick);
        save.setOnClickListener(this::onClick);
        del.setOnClickListener(this::onClick);
    }

    private void onClick(View v) {
        if(v.getTag()!=null){
            switch(v.getId()){
                case R.id.buttondel:
                    inputNum.setText(inputNum.getText().subSequence(0,inputNum.length()-1));
                    break;
                case R.id.buttoncall:
                    if((Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) && checkSelfPermission(Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                        requestPermissions(new String[]{Manifest.permission.CALL_PHONE}, 1);
                    }
                    else{
                        String phoneno = inputNum.getText().toString();

                        Intent intentcall = new Intent(Intent.ACTION_CALL);
                        intentcall.setData(Uri.parse("tel: "+phoneno));
                        startActivity(intentcall);
                        break;
                        }
                case R.id.buttonsave:
                    String contact = inputNum.getText().toString();
                    Intent intentsave = new Intent(ContactsContract.Intents.SHOW_OR_CREATE_CONTACT, Uri.parse("tel: "+contact));
                    startActivity(intentsave);
                    break;


                }
            }
        else{
            inputNum.setText(inputNum.getText() + ((Button)v).getText().toString());
        }

        }
    }


