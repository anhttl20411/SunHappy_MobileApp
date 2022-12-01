package com.example.sunhappy.functions.payments;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.sunhappy.R;
import com.example.sunhappy.databinding.ActivityMainBinding;
import com.example.sunhappy.databinding.ActivityPaymentBinding;

public class PaymentActivity extends AppCompatActivity {


    ActivityPaymentBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_payment);
        binding = ActivityPaymentBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

    }
}