package com.example.sunhappy.functions.manageorder;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.sunhappy.R;
import com.example.sunhappy.adapters.OrderPreparingAdapter;
import com.example.sunhappy.databinding.ActivityViewOderPreparingBinding;
import com.example.sunhappy.functions.viewproduct.ViewDetailProductActivity;
import com.example.sunhappy.models.PreparingOrder;

import java.util.ArrayList;

public class ViewOderPreparingActivity extends AppCompatActivity {

    ActivityViewOderPreparingBinding binding;
    OrderPreparingAdapter adapter;
    ArrayList<PreparingOrder> preparingOrderArrayList;
    PreparingOrder selectedPreOr = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_view_oder_preparing);
        binding = ActivityViewOderPreparingBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        loadData();
        addEvents();
    }

    private void addEvents() {
        binding.lvOderPreparing.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(ViewOderPreparingActivity.this, ViewDetailPreparingActivity.class);
                selectedPreOr = preparingOrderArrayList.get(i);
                intent.putExtra("image", selectedPreOr.getPreparingImage());
                intent.putExtra("name", selectedPreOr.getPreparingName());
                intent.putExtra("price", selectedPreOr.getPreparingPrice());
                startActivity(intent);
            }
        });
        //binding.lvOderPreparing.set
    }

    private void loadData() {
        preparingOrderArrayList = new ArrayList<>();
        preparingOrderArrayList.add(new PreparingOrder(R.drawable.img_polo_1, "Áo polo 1", 11000));
        preparingOrderArrayList.add(new PreparingOrder(R.drawable.img_dai_1, "Quần dài 1", 21000));
        preparingOrderArrayList.add(new PreparingOrder(R.drawable.img_thun_1, "Áo thun 1", 31000));
        preparingOrderArrayList.add(new PreparingOrder(R.drawable.img_short_1, "Quần đùi 1", 41000));
        adapter = new OrderPreparingAdapter(ViewOderPreparingActivity.this, R.layout.item_list_preparing_order, preparingOrderArrayList);
        binding.lvOderPreparing.setAdapter(adapter);
    }
}