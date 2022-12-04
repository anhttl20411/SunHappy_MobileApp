package com.example.sunhappy.functions.setting;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.MenuItem;
import android.view.View;

import com.example.sunhappy.R;
import com.example.sunhappy.databinding.ActivityLoginBinding;
import com.example.sunhappy.databinding.ActivitySettingAccountBinding;
import com.example.sunhappy.databinding.ActivitySettingBinding;
import com.example.sunhappy.functions.loginandregister.FlashscreenActivity;
import com.example.sunhappy.functions.payments.UpdateAddress;

public class SettingActivity extends AppCompatActivity {

    ActivitySettingBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySettingBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // setting actionbar
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle(Html.fromHtml("<font color='#ffd24c'>Thiết lập tài khoản</font>"));
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setDisplayUseLogoEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_baseline_arrow_back_yellow);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        addEvents();

    }

    // set events back action for actionbar
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    // navigation to SettingAccountActivity
    private void addEvents() {
        binding.hosocuatui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SettingActivity.this, SettingAccountActivity.class);
                startActivity(intent);
            }
        });
        // event when click on logout button
        binding.btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent = new Intent(SettingActivity.this,.class);
//                startActivity(intent);
            }
        });
        // event for change password
        binding.txtThaydoimatkhau.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(SettingActivity.this, ChangePasswordActivity.class);
                startActivity(intent1);
            }
        });
        //enavigation to updateAdressActivity
        binding.ln3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(SettingActivity.this, UpdateAddress.class);
                startActivity(intent1);
            }
        });


    }
}