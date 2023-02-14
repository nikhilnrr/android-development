package com.example.mycalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.BreakIterator;

public class MainActivity extends AppCompatActivity {
    Button button0, button1, button2, button3, button4, button5, button6, button7, button8, button9, buttonadd, buttonsub, buttonmul, buttondiv, buttondot, buttoneq, buttonc;
    TextView input;
    String operand1 = "", operand2 = "";
    String OPERATOR = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button0 = (Button) findViewById(R.id.button0);
        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);
        button4 = (Button) findViewById(R.id.button4);
        button5 = (Button) findViewById(R.id.button5);
        button6 = (Button) findViewById(R.id.button6);
        button7 = (Button) findViewById(R.id.button7);
        button8 = (Button) findViewById(R.id.button8);
        button9 = (Button) findViewById(R.id.button9);
        buttondot = (Button) findViewById(R.id.buttondot);
        buttonadd = (Button) findViewById(R.id.buttonadd);
        buttonsub = (Button) findViewById(R.id.buttonsub);
        buttonmul = (Button) findViewById(R.id.buttonmul);
        buttondiv = (Button) findViewById(R.id.buttondiv);
        buttonc = (Button) findViewById(R.id.buttonc);
        buttoneq = (Button) findViewById(R.id.buttoneq);

        input = (TextView) findViewById(R.id.input);


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
        CharSequence text = ((Button) v).getText();
        if (OPERATOR.equals("")) {
            operand1 = operand1 + text;
        } else {
            operand2 = operand2 + text;
        }
        input.setText(input.getText() + "" + text);
    }

    private void setOperator(View v) {
        CharSequence btn = ((Button) v).getText();
        if ((operand1 != "") && operand2 == "" && OPERATOR == "") {
            OPERATOR = btn.toString();
            input.setText(input.getText() + "" + btn);
        }
    }

    private void clear(View view) {
        OPERATOR = "";
        operand1 = "";
        operand2 = "";
        input.setText("");
    }

    private void evaluate(View view) {
        if (OPERATOR.equals(""))
            return;
        double result = 0.0;
        double o1 = Double.parseDouble(operand1);
        double o2 = Double.parseDouble(operand2);
        boolean f = true;
        String val = "";
        switch (OPERATOR) {
            case "+":
                result = o1 + o2;
                break;
            case "-":
                result= o1 - o2;
                break;
            case "*":
                result = o1 *  o2;
                break;
            case "/":
                if ( o1 == 0) {
                    f = false;
                    break;
                }
                result = o1 /  o2;
                break;
        }
        val = String.valueOf(((int)result));
//        if (f == true) {
//            val = ((result % 1 != 0)) ? String.valueOf(input) : String.valueOf(((int) result));
//        } else {
//            val = "Can't divide by 0";
//        }

        input.setText(val);
        OPERATOR = "";
        operand1 = "";
        operand2 = "";
    }
}

