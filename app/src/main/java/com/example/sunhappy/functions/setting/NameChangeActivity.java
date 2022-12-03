package com.example.sunhappy.functions.setting;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.MenuItem;
import android.view.View;

import com.example.sunhappy.R;
import com.example.sunhappy.databinding.ActivityNameChangeBinding;
import com.example.sunhappy.databinding.ActivitySettingBinding;

public class NameChangeActivity extends AppCompatActivity {
    ActivityNameChangeBinding binding;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_name_change);
        binding = ActivityNameChangeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ActionBar actionBar = getSupportActionBar();
        //actionBar.setTitle("Thiết lập tài khoản");
        actionBar.setTitle(Html.fromHtml("<font color='#ffd24c'>Sửa tên</font>"));
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setDisplayUseLogoEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_baseline_arrow_back_yellow);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
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
                //intent= new Intent(NameChangeActivity.this, SettingAccountActivity.class);
                String newname = binding.edtNewname.getText().toString();
                intent.putExtra("newname",newname);
                setResult(Activity.RESULT_OK, intent);
            }
        }
        );

    }

}