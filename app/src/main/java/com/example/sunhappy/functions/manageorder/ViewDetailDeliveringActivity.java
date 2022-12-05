package com.example.sunhappy.functions.manageorder;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.MenuItem;

import com.example.sunhappy.R;
import com.example.sunhappy.databinding.ActivityViewDetailDeliveringBinding;

public class ViewDetailDeliveringActivity extends AppCompatActivity {
    ActivityViewDetailDeliveringBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_view_detail_delivering);
        binding= ActivityViewDetailDeliveringBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle(Html.fromHtml("<font color='#ffd24c'>Chi tiết đơn hàng</font>"));
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setDisplayUseLogoEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_baseline_arrow_back_24);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        loadData();

    }
    private void loadData() {
        Intent intent = getIntent();
        //Receive data
        binding.imgSubProductImageDelivering.setImageResource(intent.getIntExtra("image", R.drawable.img_polo_1));
        binding.txtSubProductNameDelivering.setText(intent.getStringExtra("name"));
        binding.txtSubTotalDelivering.setText(String.valueOf(intent.getDoubleExtra("price", 20000)));
    }
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                Intent intent = new Intent(ViewDetailDeliveringActivity.this, ViewOderDeliveringActivity.class);
                startActivity(intent);
                return true;
            default:
                break;
        }

        return super.onOptionsItemSelected(item);
    }

}