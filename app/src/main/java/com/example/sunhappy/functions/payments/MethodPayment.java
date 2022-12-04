package com.example.sunhappy.functions.payments;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

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


        binding.btnPaymentAccept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MethodPayment.this, PaymentActivity.class);
                startActivity(intent);
            }
        });
    }
}