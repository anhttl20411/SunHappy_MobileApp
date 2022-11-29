package com.example.sunhappy.functions.payments;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Html;

import com.example.sunhappy.R;
import com.example.sunhappy.databinding.ActivityNewAdressBinding;

public class NewAdressActivity extends AppCompatActivity {
    ActivityNewAdressBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityNewAdressBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ActionBar actionBar = getSupportActionBar();
        //actionBar.setTitle("Thiết lập tài khoản");
        actionBar.setTitle(Html.fromHtml("<font color='#ffd24c'>Địa chỉ mới</font>"));
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setDisplayUseLogoEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_baseline_arrow_back_yellow);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}