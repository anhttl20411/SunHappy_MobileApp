package com.example.sunhappy.functions.setting;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.Html;
import android.view.MenuItem;
import android.view.View;

import com.example.sunhappy.R;

import com.example.sunhappy.databinding.ActivitySettingAccountBinding;

public class SettingAccountActivity extends AppCompatActivity {
    ActivitySettingAccountBinding binding;
    public static final int REQUEST_CODE = 1;
    ActivityResultLauncher<Intent> launcher;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_setting_account);
        binding = ActivitySettingAccountBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ActionBar actionBar = getSupportActionBar();
        //actionBar.setTitle("Thiết lập tài khoản");
        actionBar.setTitle(Html.fromHtml("<font color='#ffd24c'>Hồ sơ của bạn</font>"));
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setDisplayUseLogoEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_baseline_arrow_back_yellow);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        addEvents();


        // nhan ket qua tra ve
        launcher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), result -> {
            if(result.getResultCode()==RESULT_OK && result.getData()!= null){
                String newname  = (String) result.getData().getExtras().get("newname");
                binding.txtOldname.setText(String.valueOf(newname));
            }
        });
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

    private void addEvents() {
        binding.txtThayavatar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent,REQUEST_CODE );
            }
        });

        binding.ln1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(SettingAccountActivity.this, NameChangeActivity.class);
                //intent1.putExtra("name", binding.txtOldname.getText().toString());

                startActivity(intent1);

                launcher.launch(intent1);
            }
        });
        binding.ln2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // lấy username cũ gửi qua
                Intent intent = new Intent(SettingAccountActivity.this, ChangeUsernameActivity.class);
                //intent.putExtra("oldusername",binding.txtNewusername.getText().toString());
                startActivity(intent);

                Intent intent1 = getIntent();
                binding.txtNewusername.setText(intent1.getStringExtra("newusername"));
            }
        });

        binding.ln4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // lấy phonenumber cũ gửi qua
                Intent intent = new Intent(SettingAccountActivity.this, ChangePhoneActivity.class);
                //intent.putExtra("oldphone",binding.txtPhone.getText().toString());
                startActivity(intent);

                Intent intent1 = getIntent();
                binding.txtPhone.setText(intent1.getStringExtra("newphone"));
            }
        });
        binding.ln5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // lấy email cũ gửi qua
                Intent intent = new Intent(SettingAccountActivity.this, ChangeEmailActivity.class);
                //intent.putExtra("oldemail",binding.txtEmail.getText().toString());
                startActivity(intent);

                Intent intent1 = getIntent();
                binding.txtEmail.setText(intent1 .getStringExtra("newemail"));
            }
        });
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==REQUEST_CODE && resultCode==RESULT_OK && data!=null){
            Bitmap bitmap = (Bitmap) data.getExtras().get("data");
            binding.imvAvatar.setImageBitmap(bitmap);
        }
    }
}