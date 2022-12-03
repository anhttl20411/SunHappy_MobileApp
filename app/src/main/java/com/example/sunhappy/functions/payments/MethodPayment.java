package com.example.sunhappy.functions.payments;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.sunhappy.R;
import com.example.sunhappy.databinding.ActivityMethodPaymentBinding;
import com.example.sunhappy.databinding.ActivityPaymentBinding;

public class MethodPayment extends AppCompatActivity {

    ActivityMethodPaymentBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMethodPaymentBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

    }
}