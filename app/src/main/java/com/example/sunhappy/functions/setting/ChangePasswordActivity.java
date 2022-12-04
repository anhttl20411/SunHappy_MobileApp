package com.example.sunhappy.functions.setting;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.renderscript.ScriptGroup;
import android.text.Html;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.sunhappy.R;
import com.example.sunhappy.databinding.ActivityChangePasswordBinding;
import com.example.sunhappy.databinding.ActivitySettingAccountBinding;

public class ChangePasswordActivity extends AppCompatActivity {
    ActivityChangePasswordBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_change_password);
        binding = ActivityChangePasswordBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ActionBar actionBar = getSupportActionBar();
        //actionBar.setTitle("Thiết lập tài khoản");
        actionBar.setTitle(Html.fromHtml("<font color='#ffd24c'>Đổi mật khẩu</font>"));
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setDisplayUseLogoEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_baseline_arrow_back_yellow);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        addEvents();

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
   //set event for confirm change password button
    private void addEvents() {
        binding.btnConfirmchangepass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(binding.edtOldpass.getText().toString().length() == 0){
                    Toast.makeText(ChangePasswordActivity.this,
                            "Vui lòng nhập đầy đủ thông tin yêu cầu !",
                            Toast.LENGTH_LONG).show();
                }else if(binding.edtNewpass.getText().toString().length()==0){
                    Toast.makeText(ChangePasswordActivity.this,
                            "Vui lòng nhập đầy đủ thông tin yêu cầu !",
                            Toast.LENGTH_LONG).show();
                }else if(binding.edtConfirmnewpass.getText().toString().length()==0){
                    Toast.makeText(ChangePasswordActivity.this,
                            "Vui lòng nhập đầy đủ thông tin yêu cầu !",
                            Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(ChangePasswordActivity.this,
                        "Thay đổi mật khẩu thành công",
                        Toast.LENGTH_LONG).show();

                    Intent intent = new Intent(ChangePasswordActivity.this,SettingActivity.class);
                    startActivity(intent);
                }
            }
        });
    }

}