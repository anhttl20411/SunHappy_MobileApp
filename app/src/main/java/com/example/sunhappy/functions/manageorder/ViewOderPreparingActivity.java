package com.example.sunhappy.functions.manageorder;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;

import com.example.sunhappy.R;
import com.example.sunhappy.adapters.ManageorderAdapter;
import com.example.sunhappy.databinding.ActivityViewOderPreparingBinding;
import com.example.sunhappy.models.OrderPreparing;

import java.util.ArrayList;

public class ViewOderPreparingActivity extends AppCompatActivity {
    ActivityViewOderPreparingBinding binding;
    ArrayList<OrderPreparing> arrayOrderPreparing;
    ManageorderAdapter orderPreparingAdapter;
//kb mảng dữ liệu
     String ProductNamePreparing[] ={"Áo polo nam","Áo polo kiểu mới"};
     String ProductClassifyPreparing[] ={"Đen","Xám"};
     String ProductSizePreparing[] ={"M","XL"};
     Integer ProductAmountPreparing[]={1,2};
     Integer ProductPricePreparing[]={189000,159000};
     int ProductImage[]={R.drawable.img_product_polo1,R.drawable.imv_product_polo2};




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityViewOderPreparingBinding.inflate(getLayoutInflater());

        setContentView(binding.getRoot());
        arrayOrderPreparing = new ArrayList<>(); //tạo mới mảng rỗng
//add mảng con vào mảng chính
        for( int i = 0;i <ProductNamePreparing.length;i++)
        {
            arrayOrderPreparing.add(new OrderPreparing(ProductNamePreparing[i], ProductClassifyPreparing[i],ProductSizePreparing[i],ProductAmountPreparing[i],ProductPricePreparing[i], ProductImage[i]));
//kb tạo mới adapter
        }
        orderPreparingAdapter = new ManageorderAdapter(ViewOderPreparingActivity.this, R.layout.item_list_preparing_order,arrayOrderPreparing);

        binding.lvOderPreparing.setAdapter(orderPreparingAdapter);
//xử lý click
        binding.lvOderPreparing.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(ViewOderPreparingActivity.this,ViewDetailPreparingActivity.class);
                intent.putExtra("name",ProductNamePreparing[i]);
                intent.putExtra("total",ProductPricePreparing[i]);
                intent.putExtra("classify",ProductClassifyPreparing[i]);
                intent.putExtra("image",ProductImage[i]);
                intent.putExtra("amount",ProductAmountPreparing[i]);
                intent.putExtra("size",ProductSizePreparing[i]);
                startActivity(intent);
            }
        });



    }
}