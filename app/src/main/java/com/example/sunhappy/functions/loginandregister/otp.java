package com.example.sunhappy.functions.loginandregister;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.sunhappy.R;
import com.example.sunhappy.databinding.ActivityForgotpassBinding;
import com.example.sunhappy.databinding.ActivityOtpBinding;

public class otp extends AppCompatActivity {
 ActivityOtpBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otp);
        binding = ActivityOtpBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        addEvents();
    }
    private void addEvents() {
        //ấn vào k nhận đc mã thì dẫn đến màn hình hướng dẫn
        binding.txtHelp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(otp.this, help.class);
                startActivity(intent2);
            }
        });
        //đém được thời gian để gửi lại otp chưa làm
        //ấn vào xác nhận otp chuyển sang update mật khẩu
        binding.btnConfirmOTP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            Intent intent1 = new Intent(otp.this, newpassword.class);
             startActivity(intent1);
            }
        });
    }
}