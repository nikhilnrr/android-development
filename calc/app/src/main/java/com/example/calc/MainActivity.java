package com.example.calc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.nio.charset.Charset;

public class MainActivity extends AppCompatActivity {
    Button buttonc, button0, button1, button2, button3, button4, button5, button6, button7, button8, button9, buttonadd, buttonsub, buttonmul, buttondiv, buttoneq, buttondot;
    TextView input;
    String OPERATOR="";
    String operator1="", operator2="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button0 = findViewById(R.id.button0);
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);
        button5 = findViewById(R.id.button5);
        button6 = findViewById(R.id.button6);
        button7 = findViewById(R.id.button7);
        button8 = findViewById(R.id.button8);
        button9 = findViewById(R.id.button9);
        button0 = findViewById(R.id.button0);
        buttonadd = findViewById(R.id.buttonadd);
        buttonsub = findViewById(R.id.buttonsub);
        buttonmul = findViewById(R.id.buttonmul);
        buttondiv = findViewById(R.id.buttondiv);
        buttondot = findViewById(R.id.buttondot);
        buttoneq = findViewById(R.id.buttoneq);
        buttonc = findViewById(R.id.buttonc);
        input = (TextView)findViewById(R.id.input);

        button0.setOnClickListener(this::setValue);
        button1.setOnClickListener(this::setValue);
        button2.setOnClickListener(this::setValue);
        button3.setOnClickListener(this::setValue);
        button4.setOnClickListener(this::setValue);
        button5.setOnClickListener(this::setValue);
        button6.setOnClickListener(this::setValue);
        button7.setOnClickListener(this::setValue);
        button8.setOnClickListener(this::setValue);
        button9.setOnClickListener(this::setValue);
        buttondot.setOnClickListener(this::setValue);

        buttonadd.setOnClickListener(this::setOperator);
        buttonsub.setOnClickListener(this::setOperator);
        buttonmul.setOnClickListener(this::setOperator);
        buttondiv.setOnClickListener(this::setOperator);

        buttonc.setOnClickListener(this::clear);

        buttoneq.setOnClickListener(this::evaluate);
    }




    private void setValue(View v) {
        CharSequence text = ((Button)v).getText();
        if(OPERATOR==""){
            operator1 = operator1 + text;
        }
        else{
            operator2 = operator2 + text;
        }
        input.setText(input.getText() + "" + text);
    }

    private void setOperator(View v) {
        CharSequence btn =((Button)v).getText();
        if(operator1 !="" && operator2 =="" && OPERATOR ==""){
            OPERATOR = btn.toString();
            input.setText(input.getText()+""+btn);
        }
    }
    private void clear(View view) {
        OPERATOR="";
        operator1="";
        operator2="";
        input.setText("");
    }
    private void evaluate(View view) {
        if(OPERATOR=="")
            return;
        double result = 0;
        double op1 = Double.parseDouble(operator1);
        double op2 = Double.parseDouble(operator2);
        boolean f= true;
        String val ="";

        switch (OPERATOR){
            case "+":
                result=op1+op2;
                break;
            case "-":
                result = op1 - op2;
            case "*":
                result = op1 * op2;
            case "/":
                if(op1==0){
                    f = false;
                    break;
                }
                result = op1 / op2;
                break;
        }
        val = String.valueOf(((int)result));
//        if (f == true) {
//            val = ((result % 1 != 0)) ? String.valueOf(input) : String.valueOf(((int) result));
//        } else {
//            val = "Can't divide by 0";
//        }
        input.setText(val);
        OPERATOR="";
        operator1="";
        operator2="";

        }
    }


