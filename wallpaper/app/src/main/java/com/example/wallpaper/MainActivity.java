package com.example.wallpaper;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    Button button;
    View screenview;
    Handler handler;
    int[] back_images;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        back_images = new int[]{R.drawable.w1, R.drawable.w2, R.drawable.w3};
        button = findViewById(R.id.button);
        screenview=findViewById(R.id.constraint_layout);
        handler = new Handler();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                handler.postDelayed(runnable, 0);
                button.setVisibility(view.GONE);
            }
        });
    }
        public Runnable runnable = new Runnable() {
            @Override
            public void run() {
                int array_number = back_images.length;
                Random random = new Random();
                int random_number = random.nextInt(array_number);
                screenview.setBackground(ContextCompat.getDrawable(getApplicationContext(), back_images[random_number]));
                handler.postDelayed(this, 100);
            }



    };
}