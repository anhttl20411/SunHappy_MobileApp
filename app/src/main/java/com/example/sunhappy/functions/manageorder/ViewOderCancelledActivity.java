package com.example.sunhappy.functions.manageorder;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.sunhappy.databinding.ActivityViewDetailPreparingBinding;
import com.example.sunhappy.databinding.ActivityViewOderCancelledBinding;

public class ViewOderCancelledActivity extends AppCompatActivity {
    ActivityViewOderCancelledBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_view_oder_cancelled);
        binding= ActivityViewOderCancelledBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }
}