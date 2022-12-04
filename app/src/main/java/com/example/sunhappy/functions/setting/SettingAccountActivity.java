package com.example.sunhappy.functions.setting;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
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

        // setting actionbar
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle(Html.fromHtml("<font color='#ffd24c'>Hồ sơ của bạn</font>"));
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setDisplayUseLogoEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_baseline_arrow_back_24);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        addEvents();
    }

    // set events back action for actionbar
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
        // change avatar
        binding.txtThayavatar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent,REQUEST_CODE );
            }
        });
        // change name account
        binding.ln1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(SettingAccountActivity.this, NameChangeActivity.class);
                startActivity(intent1);
            }
        });
        //get newname
        Intent getnewname = getIntent();
        binding.txtOldname.setText(getnewname.getStringExtra("newname"));
        //change username
        binding.ln2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // lấy username cũ gửi qua
                Intent intent = new Intent(SettingAccountActivity.this, ChangeUsernameActivity.class);
                //intent.putExtra("oldusername",binding.txtNewusername.getText().toString());
                startActivity(intent);
            }
        });
        //get new username
        Intent getnewuser = getIntent();
        binding.txtNewusername.setText(getnewuser.getStringExtra("newusername"));
        //Change phone
        binding.ln4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // lấy phonenumber cũ gửi qua
                Intent intent = new Intent(SettingAccountActivity.this, ChangePhoneActivity.class);
                //intent.putExtra("oldphone",binding.txtPhone.getText().toString());
                startActivity(intent);
            }
        });
        //get new phone
        Intent getnewphone = getIntent();
        binding.txtPhone.setText(getnewphone.getStringExtra("newphone"));
        // Change Email
        binding.ln5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // lấy email cũ gửi qua
                Intent intent = new Intent(SettingAccountActivity.this, ChangeEmailActivity.class);
                //intent.putExtra("oldemail",binding.txtEmail.getText().toString());
                startActivity(intent);
            }
        });
        //get newemail
        Intent getnewemail = getIntent();
        binding.txtEmail.setText(getnewemail.getStringExtra("newemail"));
    }

    // received image return by funtion onActivityResult()
    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==REQUEST_CODE && resultCode==RESULT_OK && data!=null){
            Bitmap hinhanh = (Bitmap) data.getExtras().get("data");
            // rescaled avatar to fill frame Avatar
            Drawable newdrawable = new BitmapDrawable(getResources(),
                    Bitmap.createScaledBitmap(hinhanh,960 , 960, false));
            binding.imvAvatar.setImageDrawable(newdrawable);
        }
    }
}