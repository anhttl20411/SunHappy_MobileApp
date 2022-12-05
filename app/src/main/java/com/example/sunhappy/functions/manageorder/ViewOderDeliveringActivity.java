package com.example.sunhappy.functions.manageorder;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;

import com.example.sunhappy.R;
import com.example.sunhappy.adapters.OrderDeliveringAdapter;
import com.example.sunhappy.adapters.OrderPreparingAdapter;
import com.example.sunhappy.databinding.ActivityViewOderDeliveringBinding;
import com.example.sunhappy.databinding.ActivityViewOderPreparingBinding;
import com.example.sunhappy.models.DeliveringOrder;
import com.example.sunhappy.models.PreparingOrder;

import java.util.ArrayList;

public class ViewOderDeliveringActivity extends AppCompatActivity {

    ActivityViewOderDeliveringBinding binding;
    OrderDeliveringAdapter adapter;
    ArrayList<DeliveringOrder> deliveringOrderArrayList;
    DeliveringOrder selectedPreOrDelivering = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_view_oder_preparing);
        binding = ActivityViewOderDeliveringBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        loadData();
        addEvents();
    }

    private void addEvents() {
        binding.lvOderDelivering.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(ViewOderDeliveringActivity.this, ViewDetailDeliveringActivity.class);
                selectedPreOrDelivering = deliveringOrderArrayList.get(i);
                intent.putExtra("image", selectedPreOrDelivering.getDeliveringImage());
                intent.putExtra("name", selectedPreOrDelivering.getDeliveringName());
                intent.putExtra("price", selectedPreOrDelivering.getDeliveringPrice());
                startActivity(intent);
            }
        });
    }

    private void loadData() {
        deliveringOrderArrayList = new ArrayList<>();
        deliveringOrderArrayList.add(new DeliveringOrder(R.drawable.img_polo_2, "Áo polo 2", 11000));
        deliveringOrderArrayList.add(new DeliveringOrder(R.drawable.img_dai_2, "Quần dài 2", 21000));
        deliveringOrderArrayList.add(new DeliveringOrder(R.drawable.img_thun_2, "Áo thun 2", 31000));
        deliveringOrderArrayList.add(new DeliveringOrder(R.drawable.img_short_2, "Quần đùi 2", 41000));
        adapter = new OrderDeliveringAdapter(ViewOderDeliveringActivity.this, R.layout.item_list_delivering_oder, deliveringOrderArrayList);
        binding.lvOderDelivering.setAdapter(adapter);
    }
}