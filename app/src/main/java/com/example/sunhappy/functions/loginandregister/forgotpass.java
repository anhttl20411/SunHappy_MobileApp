package com.example.sunhappy.functions.loginandregister;

import static com.example.sunhappy.databinding.ActivityForgotpassBinding.bind;
import static com.example.sunhappy.databinding.ActivityForgotpassBinding.inflate;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;

import com.example.sunhappy.R;
import com.example.sunhappy.databinding.ActivityForgotpassBinding;
import com.example.sunhappy.databinding.ActivityLoginBinding;

public class forgotpass extends AppCompatActivity {
 ActivityForgotpassBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityForgotpassBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        addEvents();

    }
    //ấn vào gửi otp ra màn hình otp
    private void addEvents() {
        binding.btnOTP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(forgotpass.this, otp.class);
                startActivity(intent);
            }
        });
        //định dạng số điện thoại là số
// chưa có chức năng đếm ngược thời gian để gửi lại mã
    }
}