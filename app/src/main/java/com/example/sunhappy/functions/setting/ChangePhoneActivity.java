package com.example.sunhappy.functions.setting;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.MenuItem;
import android.view.View;

import com.example.sunhappy.R;
import com.example.sunhappy.databinding.ActivityChangePhoneBinding;
import com.example.sunhappy.databinding.ActivityChangeUsernameBinding;

public class ChangePhoneActivity extends AppCompatActivity {
ActivityChangePhoneBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_change_phone);
        binding = ActivityChangePhoneBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        //set actionbar
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle(Html.fromHtml("<font color='#ffd24c'>Thay đổi số điện thoại</font>"));
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setDisplayUseLogoEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_baseline_arrow_back_yellow);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

//        getData();
        addEvent();
    }
    // set events  back action for actionbar
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId())
        {
            case android.R.id.home:
                onBackPressed();
                return true;

            default:break;
        }

        return super.onOptionsItemSelected(item);
    }
    //set event for Luu button
    private void addEvent() {
        binding.btnLuu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //trả lại username mới
                Intent intent = new Intent(ChangePhoneActivity.this, SettingAccountActivity.class);
                String newphone = binding.edtNewphone.getText().toString();
                intent.putExtra("newphone",newphone);
                startActivity(intent);

            }
        });
    }
}