package com.example.sunhappy.functions.payments;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.MenuItem;
import android.view.View;

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
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_baseline_arrow_back_yellow);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        binding.btnAddressSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent intent = new Intent(AddNewAddressActivity.this,UpdateAddress.class);

                String Ten = binding.edtAddressName.getText().toString();
                int SDT = Integer.parseInt(binding.edtAddressSDT.getText().toString());
                String Tinh = binding.edtAddressTinh.getText().toString();
                String Huyen = binding.edtAddressHuyen.getText().toString();
                String Xa = binding.edtAddressXa.getText().toString();
                String Duong = binding.edtAddressDuong.getText().toString();

                Bundle bundle = new Bundle();

                bundle.putString("ten",Ten);
                bundle.putString("tinh",Tinh);
                bundle.putString("huyen",Huyen);
                bundle.putString("xa",Xa);
                bundle.putString("duong",Duong);
                bundle.putInt("sdt",SDT);

                intent.putExtra("pack",bundle);
                startActivity(intent);

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
}