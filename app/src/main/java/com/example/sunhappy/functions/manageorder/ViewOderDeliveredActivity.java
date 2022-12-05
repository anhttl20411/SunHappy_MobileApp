package com.example.sunhappy.functions.manageorder;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;

import com.example.sunhappy.R;
import com.example.sunhappy.adapters.OrderDeliveredAdapter;
import com.example.sunhappy.adapters.OrderDeliveredAdapter;
import com.example.sunhappy.databinding.ActivityViewOderDeliveredBinding;

import com.example.sunhappy.models.DeliveredOrder;
import com.example.sunhappy.models.DeliveringOrder;

import java.util.ArrayList;

public class ViewOderDeliveredActivity extends AppCompatActivity {

    ActivityViewOderDeliveredBinding binding;
    OrderDeliveredAdapter adapter;
    ArrayList<DeliveredOrder> deliveredOrderArrayList;
    DeliveredOrder selectedPreOrDelivered = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_view_oder_preparing);
        binding = ActivityViewOderDeliveredBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        loadData();
        addEvents();
    }

    private void addEvents() {
        binding.lvOderDelivered.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(ViewOderDeliveredActivity.this, ViewDetailDeliveredActivity.class);
                selectedPreOrDelivered = deliveredOrderArrayList.get(i);
                intent.putExtra("image", selectedPreOrDelivered.getDeliveredImage());
                intent.putExtra("name", selectedPreOrDelivered.getDeliveredName());
                intent.putExtra("price", selectedPreOrDelivered.getDeliveredPrice());
                startActivity(intent);
            }
        });
    }

    private void loadData() {
        deliveredOrderArrayList = new ArrayList<>();
        deliveredOrderArrayList.add(new DeliveredOrder(R.drawable.img_polo_3, "Áo polo 3", 13000));
        deliveredOrderArrayList.add(new DeliveredOrder(R.drawable.img_dai_3, "Quần dài 3", 23000));
        deliveredOrderArrayList.add(new DeliveredOrder(R.drawable.img_thun_3, "Áo thun 3", 33000));
        deliveredOrderArrayList.add(new DeliveredOrder(R.drawable.img_short_3, "Quần đùi 3", 43000));
        adapter = new OrderDeliveredAdapter(ViewOderDeliveredActivity.this, R.layout.item_list_delivered_oder, deliveredOrderArrayList);
        binding.lvOderDelivered.setAdapter(adapter);
    }
}