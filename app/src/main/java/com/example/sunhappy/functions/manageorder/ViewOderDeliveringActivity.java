package com.example.sunhappy.functions.manageorder;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import com.example.sunhappy.R;
import com.example.sunhappy.adapters.OrderDeliveringAdapter;
import com.example.sunhappy.databinding.ActivityViewOderDeliveringBinding;
import com.example.sunhappy.models.DeliveringOrder;

import java.util.ArrayList;

public class ViewOderDeliveringActivity extends AppCompatActivity {

    ActivityViewOderDeliveringBinding binding;
    OrderDeliveringAdapter adapter;
    ArrayList<DeliveringOrder> deliveringOrderArrayList;
    DeliveringOrder selectedDlvedOr = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_view_oder_preparing);
        binding = ActivityViewOderDeliveringBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle(Html.fromHtml("<font color='#ffd24c'>Đơn hàng đang giao</font>"));
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setDisplayUseLogoEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_baseline_arrow_back_24);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        loadData();
        addEvents();
    }

    private void addEvents() {
        binding.lvOderDelivering.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(ViewOderDeliveringActivity.this, ViewDetailDeliveringActivity.class);
                selectedDlvedOr = deliveringOrderArrayList.get(i);
                intent.putExtra("image", selectedDlvedOr.getDeliveringImage());
                intent.putExtra("name", selectedDlvedOr.getDeliveringName());
                intent.putExtra("price", selectedDlvedOr.getDeliveringPrice());
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