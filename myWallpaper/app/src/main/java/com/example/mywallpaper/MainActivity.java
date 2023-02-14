package com.example.mywallpaper;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    Button button;
    View viewscreen;
    int[] back_images;
    Handler handler;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        back_images = new int[]{R.drawable.w1, R.drawable.w2, R.drawable.w3, R.drawable.w4, R.drawable.w5, R.drawable.w6, R.drawable.w7, R.drawable.w8, R.drawable.w9, R.drawable.w10};
        button=findViewById(R.id.button);
        viewscreen = findViewById(R.id.constraint_layout);
        handler = new Handler();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                handler.postDelayed(runnable, 0);
                button.setVisibility(View.GONE);
            }
        });
    }
            public Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    int array_length = back_images.length;
                    Random random = new Random();
                    int random_number = random.nextInt(array_length);
                    viewscreen.setBackground(ContextCompat.getDrawable(getApplicationContext(),back_images[random_number]));
                    handler.postDelayed(this, 300);
                }
            };
}
