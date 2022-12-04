package com.example.sunhappy.functions.viewcart;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.sunhappy.adapters.ProductCartAdapter;
import com.example.sunhappy.databinding.ActivityProductCartBinding;
import com.example.sunhappy.databinding.DialogUpdateSizeColorBinding;

public class SelectedProduct extends AppCompatActivity {
    DialogUpdateSizeColorBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DialogUpdateSizeColorBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        addEvents();
        showData();
    }

    //lấy thông tin sp từ list
    private void showData() {
        Intent intent = getIntent();
        int selectedProduct = intent.getIntExtra("selected_product",0);
        String selectedName = intent.getStringExtra("selected_name");
        String selectedPrice = String.valueOf(Double.valueOf(intent.getStringExtra("selected_price")));


        binding.imvProductImage.setImageResource(selectedProduct);
        binding.txtProductName.setText(selectedName);
        binding.txtProductPrice.setText(selectedPrice);

    }
    private void addEvents() {
        binding.btnUpdateToCartConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(SelectedProduct.this, ProductCartAdapter.class);
                startActivity(intent);
            }
        });
    }

}

