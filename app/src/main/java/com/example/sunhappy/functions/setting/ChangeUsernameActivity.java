package com.example.sunhappy.functions.setting;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.sunhappy.R;
import com.example.sunhappy.databinding.ActivityChangeUsernameBinding;
import com.example.sunhappy.databinding.ActivityNameChangeBinding;

public class ChangeUsernameActivity extends AppCompatActivity {
    ActivityChangeUsernameBinding binding;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_change_username);
        binding = ActivityChangeUsernameBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        //set actionbar
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle(Html.fromHtml("<font color='#ffd24c'>Thay đổi tên tài khoản</font>"));
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setDisplayUseLogoEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_baseline_arrow_back_24);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

//        getData();
        addEvent();
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

    //set event for btnLuu
    private void addEvent() {
        binding.btnLuu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //trả lại username mới
                Intent intent = new Intent(ChangeUsernameActivity.this, SettingAccountActivity.class);
                String newusername = binding.edtNewusername.getText().toString();
                intent.putExtra("newusername", newusername);
                startActivity(intent);
            }
        });
    }
}