package com.github.ivanmaria.hoaxify;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        int val = SharedPrefManager.getInstance(getApplicationContext()).getInt("login");

        if (val == 1) {
            new Handler().postDelayed(new Runnable() {

                @Override
                public void run() {
                    // This method will be executed once the timer is over
                    // Start your app main activity
                    Intent i = new Intent(SplashScreen.this, MainActivity.class);
                    startActivity(i);

                    // close this activity
                    finish();
                }
            }, 500);
        }
    else
    {
        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                // This method will be executed once the timer is over
                // Start your app main activity
                Intent i = new Intent(SplashScreen.this, Login.class);
                startActivity(i);

                // close this activity
                finish();
            }
        }, 500);
    }
}
}