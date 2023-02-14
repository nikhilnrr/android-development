package com.example.mytexttospeech;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;



import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    Button butspeak;
    EditText intext;
    TextToSpeech textToSpeech;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        butspeak.findViewById(R.id.buttspeak);
        intext.findViewById(R.id.text);

        textToSpeech = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if(status!=TextToSpeech.ERROR){
                    textToSpeech.setLanguage(Locale.US);
                }
                }
        });
        butspeak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textToSpeech.speak(intext.getText().toString(),TextToSpeech.QUEUE_FLUSH,null);
            }
        });

    }
}