package com.example.sunhappy.functions.setting;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.MenuItem;
import android.view.View;

import com.example.sunhappy.R;
import com.example.sunhappy.databinding.ActivitySettingAccountBinding;
import com.example.sunhappy.databinding.ActivitySettingBinding;

public class SettingActivity extends AppCompatActivity {

    ActivitySettingBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySettingBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ActionBar actionBar = getSupportActionBar();
        //actionBar.setTitle("Thiết lập tài khoản");
        actionBar.setTitle(Html.fromHtml("<font color='#ffd24c'>Thiết lập tài khoản</font>"));
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setDisplayUseLogoEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_baseline_arrow_back_yellow);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        addEvents();

    }

    private void addEvents() {
        binding.imvHosocuatoi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SettingActivity.this, SettingAccountActivity.class);
                startActivity(intent);
            }
        });
    }

//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        switch (item.getItemId())
//        {
//            case android.R.id.home:
//                onBackPressed();
//                return true;
//
//            default:break;
//        }
//
//        return super.onOptionsItemSelected(item);
//    }
}