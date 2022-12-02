package com.example.sunhappy.functions.viewcart;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.sunhappy.R;
import com.example.sunhappy.adapters.ProductCartAdapter;
import com.example.sunhappy.databinding.ActivityProductCartBinding;
import com.example.sunhappy.functions.payments.PaymentActivity;
import com.example.sunhappy.models.ProductCart;

import java.util.ArrayList;

public class ProductCartActivity extends AppCompatActivity {

    ActivityProductCartBinding binding;
    ProductCartAdapter adapter;
    ArrayList<ProductCart> productCartArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
      //  setContentView(R.layout.activity_product_cart);
        binding = ActivityProductCartBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        loadData();
        addEvents();
    }

    public void openDialogChooseColor(ProductCart p) {
        Dialog dialog = new Dialog(ProductCartActivity.this);
        dialog.setContentView(R.layout.dialog_choose_size_color);
        dialog.show();
    }

    private void loadData(){
        productCartArrayList = new ArrayList<>();
        productCartArrayList.add(new ProductCart(R.drawable.imv_white_polo, "Áo polo nam", "Aó polo màu đen",180000));
        productCartArrayList.add(new ProductCart(R.drawable.imv_white_polo, "Áo polo nam", "Aó polo màu đen",180000));

        adapter = new ProductCartAdapter(ProductCartActivity.this, R.layout.activity_product_cart_list,productCartArrayList);
        binding.lvProduct.setAdapter(adapter);
    }
    private void addEvents(){
        binding.btnBuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ProductCartActivity.this, PaymentActivity.class);
                startActivity(intent);
            }
        });
    }

}