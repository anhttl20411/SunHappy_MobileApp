package com.example.sunhappy.functions.payments;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import com.example.sunhappy.R;
import com.example.sunhappy.adapters.AddressAdapter;
import com.example.sunhappy.databinding.ActivitySettingAccountBinding;
import com.example.sunhappy.databinding.ActivityUpdateAddressBinding;
import com.example.sunhappy.models.Address;

import java.util.ArrayList;

public class UpdateAddress extends AppCompatActivity {

ActivityUpdateAddressBinding binding;
    ArrayList<Address> list;

    AddressAdapter addressAdapter;

    String Ten[] = {"Thịnh"};
    String SDT[] = {"032 848 7777"};
    String Tinh[] = {"Bình Dương"};
    String Huyen[] = {"Dĩ An"};
    String Xa[] = {"Tân Lập"};
    String Duong[] = {"Số 10,Đường Tân lập"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityUpdateAddressBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle(Html.fromHtml("<font color='#ffd24c'>Cập nhật địa chỉ</font>"));
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setDisplayUseLogoEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_baseline_arrow_back_yellow);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        list = new ArrayList<>();

        for( int i = 0;i < Ten.length;i++)
        {
//

            list.add(new Address(Ten[i],SDT[i],Tinh[i],Huyen[i],Xa[i],Duong[i] ));
//
        }
        addressAdapter = new AddressAdapter(UpdateAddress.this, R.layout.list_address_item,list);

       binding.lvAddress.setAdapter(addressAdapter);

       binding.btnAddNewAddress.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Intent intent = new Intent(UpdateAddress.this,AddNewAddressActivity.class);
               startActivity(intent);

           }
       });



       binding.btnAddressReup.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {

               if(getIntent().getExtras() == null) {
                   Toast.makeText(UpdateAddress.this,"Chưa có địa chỉ mới, vui lòng thêm địa chỉ và cập nhật",Toast.LENGTH_SHORT).show();

               } else  {
                   Intent intent = getIntent();
                   Bundle bundle = intent.getBundleExtra("pack");
                   String ten = bundle.getString("ten");
                   String sdt = bundle.getString("sdt");
                   String tinh = bundle.getString("tinh");
                   String huyen = bundle.getString("huyen");
                   String xa = bundle.getString("xa");
                   String duong = bundle.getString("duong");



                   list.add(new Address(ten,sdt,tinh,huyen,xa,duong));

                   addressAdapter.notifyDataSetChanged();

                   Toast.makeText(UpdateAddress.this,"Bạn đã thêm địa chỉ mới thành công",Toast.LENGTH_SHORT).show();
                   getIntent().removeExtra("pack");

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



}