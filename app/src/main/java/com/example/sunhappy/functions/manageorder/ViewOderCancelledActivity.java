package com.example.sunhappy.functions.manageorder;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;

import com.example.sunhappy.R;
import com.example.sunhappy.adapters.OrderCancelAdapter;
import com.example.sunhappy.adapters.OrderPreparingAdapter;
import com.example.sunhappy.databinding.ActivityViewDetailPreparingBinding;
import com.example.sunhappy.databinding.ActivityViewOderCancelledBinding;
import com.example.sunhappy.functions.viewcart.ProductCartActivity;
import com.example.sunhappy.models.CancelOrder;
import com.example.sunhappy.models.DeliveredOrder;
import com.example.sunhappy.models.PreparingOrder;

import java.util.ArrayList;

public class ViewOderCancelledActivity extends AppCompatActivity {
    ActivityViewOderCancelledBinding binding;
    OrderCancelAdapter adapter;
    ArrayList<CancelOrder> cancelOrderArrayList;
    CancelOrder selectedCancelOr = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_view_oder_cancelled);
        binding= ActivityViewOderCancelledBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        loadData();
        addEvents();
    }

    private void addEvents() {
        binding.lvOderCancel.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(ViewOderCancelledActivity.this, ViewDetailCancelledActivity.class);
                selectedCancelOr = cancelOrderArrayList.get(i);
                intent.putExtra("image", selectedCancelOr.getCancelImage());
                intent.putExtra("name", selectedCancelOr.getCancelName());
                intent.putExtra("price", selectedCancelOr.getCancelPrice());
                startActivity(intent);
            }
        });
    }

    private void loadData() {
        Intent intent = getIntent();
        cancelOrderArrayList = new ArrayList<>();
        cancelOrderArrayList.add(new CancelOrder(R.drawable.img_polo_4, "Áo polo 4", 14000));
        cancelOrderArrayList.add(new CancelOrder(R.drawable.img_dai_4, "Quần dài 4", 23000));
        cancelOrderArrayList.add(new CancelOrder(intent.getIntExtra("image", R.drawable.img_polo_4), intent.getStringExtra("name"), intent.getDoubleExtra("price", 200000)));

        adapter = new OrderCancelAdapter(ViewOderCancelledActivity.this, R.layout.item_list_cancelled_oder, cancelOrderArrayList);
        binding.lvOderCancel.setAdapter(adapter);
    }
}