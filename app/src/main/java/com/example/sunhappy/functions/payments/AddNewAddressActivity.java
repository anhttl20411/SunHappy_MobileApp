package com.example.sunhappy.functions.payments;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.sunhappy.R;
import com.example.sunhappy.databinding.ActivityAddNewAddressBinding;


public class AddNewAddressActivity extends AppCompatActivity {

   ActivityAddNewAddressBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAddNewAddressBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle(Html.fromHtml("<font color='#ffd24c'>Thêm địa chỉ mới</font>"));
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setDisplayUseLogoEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_baseline_arrow_back_24);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        binding.btnAddressSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                String Ten = binding.edtAddressName.getText().toString();
                String SDT = binding.edtAddressSDT.getText().toString();
                String Tinh = binding.edtAddressTinh.getText().toString();
                String Huyen = binding.edtAddressHuyen.getText().toString();
                String Xa = binding.edtAddressXa.getText().toString();
                String Duong = binding.edtAddressDuong.getText().toString();

                if (TextUtils.isEmpty(binding.edtAddressName.getText().toString()))
                {
                    binding.edtAddressName.setError("Bạn cần nhập Tên");
                    return;
                } else if (TextUtils.isEmpty(binding.edtAddressSDT.getText().toString()))
                {
                    binding.edtAddressSDT.setError("Bạn cần nhập SDT");
                    return;

                }
                else if (TextUtils.isEmpty(binding.edtAddressTinh.getText().toString()))
                {
                    binding.edtAddressTinh.setError("Bạn cần nhập Tỉnh");
                    return;

                }
                else if (TextUtils.isEmpty(binding.edtAddressHuyen.getText().toString()))
                {
                    binding.edtAddressHuyen.setError("Bạn cần nhập Huyện");
                    return;

                }
                else if (TextUtils.isEmpty(binding.edtAddressXa.getText().toString()))
                {
                    binding.edtAddressXa.setError("Bạn cần nhập Xã");
                    return;

                }
                else if (TextUtils.isEmpty(binding.edtAddressDuong.getText().toString()))
                {
                    binding.edtAddressDuong.setError("Bạn cần nhập Đường");
                    return;

                } else {
                    Intent intent = new Intent(AddNewAddressActivity.this,UpdateAddress.class);
                    Bundle bundle = new Bundle();

                    bundle.putString("ten",Ten);
                    bundle.putString("tinh",Tinh);
                    bundle.putString("huyen",Huyen);
                    bundle.putString("xa",Xa);
                    bundle.putString("duong",Duong);
                    bundle.putString("sdt",SDT);

                    intent.putExtra("pack",bundle);
                    startActivity(intent);
                }







            }


        });
    }



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

    private boolean KiemTra(String a,String b,String c,String d,String e,String f){
        if (a == "") {
             return false;

        }
        if (b == "") {
            Toast.makeText(AddNewAddressActivity.this,"Bạn chưa điền tên",Toast.LENGTH_SHORT);return false;

        }
        if (c == "") {
            return false;

        }
        if (d == "") {
            return false;

        }
        if (e == "") {
              return false;

        }
        if (f == "") {
             return false;

        }
        else {
            return true;
        }

    }

}