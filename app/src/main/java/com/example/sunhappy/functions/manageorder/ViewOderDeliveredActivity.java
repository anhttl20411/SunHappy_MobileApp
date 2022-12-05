package com.example.sunhappy.functions.manageorder;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.MenuItem;
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
    DeliveredOrder selectedDlvedOr = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_view_oder_preparing);
        binding = ActivityViewOderDeliveredBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle(Html.fromHtml("<font color='#ffd24c'>Đơn hàng đã giao</font>"));
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setDisplayUseLogoEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_baseline_arrow_back_24);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        loadData();
        addEvents();
    }

    private void addEvents() {
        binding.lvOderDelivered.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(ViewOderDeliveredActivity.this, ViewDetailDeliveredActivity.class);
                selectedDlvedOr = deliveredOrderArrayList.get(i);
                intent.putExtra("image", selectedDlvedOr.getDeliveredImage());
                intent.putExtra("name", selectedDlvedOr.getDeliveredName());
                intent.putExtra("price", selectedDlvedOr.getDeliveredPrice());
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
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
            default:
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}