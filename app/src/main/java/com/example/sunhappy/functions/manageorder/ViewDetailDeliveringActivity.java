package com.example.sunhappy.functions.manageorder;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.sunhappy.R;
import com.example.sunhappy.databinding.ActivityViewDetailDeliveringBinding;

public class ViewDetailDeliveringActivity extends AppCompatActivity {
    ActivityViewDetailDeliveringBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_view_detail_delivering);
        binding= ActivityViewDetailDeliveringBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        loadData();

    }
    private void loadData() {
        Intent intent = getIntent();
        //Receive data
        binding.imgSubProductImageDelivering.setImageResource(intent.getIntExtra("image", R.drawable.img_polo_1));
        binding.txtSubProductNameDelivering.setText(intent.getStringExtra("name"));
        binding.txtSubTotalDelivering.setText(String.valueOf(intent.getDoubleExtra("price", 20000)));
    }

}