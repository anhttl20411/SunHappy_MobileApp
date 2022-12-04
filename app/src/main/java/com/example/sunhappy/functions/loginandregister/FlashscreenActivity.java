package com.example.sunhappy.functions.loginandregister;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.sunhappy.R;
import com.example.sunhappy.databinding.ActivityFlashscreenBinding;

public class FlashscreenActivity extends AppCompatActivity {
//chờ 5s
    ActivityFlashscreenBinding binding;
    private static int SPLASH_TIME_OUT=5000;
    //public static String PREFS_NAME="WELCOME" check 1stuse

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityFlashscreenBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(FlashscreenActivity.this,login.class);
                startActivity(intent);
            }
        }, SPLASH_TIME_OUT);
    }
}