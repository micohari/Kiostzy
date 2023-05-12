package com.kiostzy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import com.airbnb.lottie.LottieAnimationView;

public class splash extends AppCompatActivity {
    ImageView background;
    LottieAnimationView lottieAnimationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        background = findViewById(R.id.background);
        lottieAnimationView = findViewById(R.id.lottie);




        Thread thread = new Thread(){
            public void run() {
                try {
                    sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();

                } finally {
                    startActivity(new Intent(splash.this, MainActivity.class));
                    finish();
                }
            }
        };
        thread.start();
    }
}