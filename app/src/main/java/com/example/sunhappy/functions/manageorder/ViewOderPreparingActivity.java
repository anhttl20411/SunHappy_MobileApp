package com.example.sunhappy.functions.manageorder;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
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
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle(Html.fromHtml("<font color='#ffd24c'>Đơn hàng đang chuẩn bị</font>"));
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setDisplayUseLogoEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_baseline_arrow_back_24);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


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
        preparingOrderArrayList.add(new PreparingOrder(R.drawable.img_polo_1, "Áo polo phối sọc", 11000));
        preparingOrderArrayList.add(new PreparingOrder(R.drawable.img_dai_1, "Quần dài kaki", 21000));
        preparingOrderArrayList.add(new PreparingOrder(R.drawable.img_thun_1, "Áo thun gấu", 31000));
        preparingOrderArrayList.add(new PreparingOrder(R.drawable.img_short_1, "Quần đùi phối túi", 41000));
        adapter = new OrderPreparingAdapter(ViewOderPreparingActivity.this, R.layout.item_list_preparing_order, preparingOrderArrayList);
        binding.lvOderPreparing.setAdapter(adapter);
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