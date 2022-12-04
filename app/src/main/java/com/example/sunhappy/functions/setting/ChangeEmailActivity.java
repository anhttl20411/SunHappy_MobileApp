package com.example.sunhappy.functions.setting;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.MenuItem;
import android.view.View;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.example.sunhappy.R;
import com.example.sunhappy.databinding.ActivityChangeEmailBinding;

public class ChangeEmailActivity extends AppCompatActivity {
ActivityChangeEmailBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_change_phone);
        binding = ActivityChangeEmailBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        //set actionbar
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle(Html.fromHtml("<font color='#ffd24c'>Thay đổi email</font>"));
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setDisplayUseLogoEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_baseline_arrow_back_yellow);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

//        getData();
        addEvent();
    }
    // set events for actionbar
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

    private void addEvent() {
        binding.btnLuu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(ChangeEmailActivity.this, SettingAccountActivity.class);
                String newemail = binding.edtNewemail.getText().toString();
                intent.putExtra("newemail",newemail);
                startActivity(intent);

            }
        });
    }
}