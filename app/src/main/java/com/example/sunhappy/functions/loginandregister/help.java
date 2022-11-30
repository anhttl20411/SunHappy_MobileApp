package com.example.sunhappy.functions.loginandregister;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.sunhappy.R;
import com.example.sunhappy.databinding.ActivityHelpBinding;
import com.example.sunhappy.databinding.ActivityOtpBinding;

public class help extends AppCompatActivity {
ActivityHelpBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);
        binding = ActivityHelpBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        addEvents();
    }
    private void addEvents() {
        //ấn vào  button gửi lại otp thì ra màn hình otp
        binding.btnResentOtp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent6 = new Intent(help.this, otp.class);
                startActivity(intent6);
            }
        });
}}