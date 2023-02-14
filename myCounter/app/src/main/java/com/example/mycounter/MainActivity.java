package com.example.mycounter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button start, stop;
    TextView output;
    int cvalue = 0;
    Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        output =(TextView) findViewById(R.id.cvalue);
        start = findViewById(R.id.start);
        stop = findViewById(R.id.stop);
        handler = new Handler();

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                handler.postDelayed(runnable, 0);
            }
        });

        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                handler.removeCallbacks(runnable);
            }
        });
    }
    public Runnable runnable = new Runnable() {
        @Override
        public void run() {
            cvalue++;
            output.setText(String.format("%d", cvalue));
            handler.postDelayed(runnable, 100);

        }
    };
}
