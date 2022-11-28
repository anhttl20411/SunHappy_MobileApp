package com.example.sunhappy.functions.viewcart;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;

import com.example.sunhappy.R;
import com.example.sunhappy.adapters.CartAdapter;
import com.example.sunhappy.databinding.ActivityViewDetailCartBinding;
import com.example.sunhappy.databinding.ActivityViewDetailProductBinding;
import com.example.sunhappy.models.Cart;

import java.util.ArrayList;

public class ViewDetailCartActivity extends AppCompatActivity {
   ActivityViewDetailCartBinding binding;
    CartAdapter adapter;
    ArrayList<Cart> cartList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
      //  setContentView(R.layout.activity_view_detail_cart);
        setContentView(binding.getRoot());
        loadData();
    }
    private void loadData(){
        cartList = new ArrayList<>();
        cartList.add(new Cart(R.drawable.img_product_polo1,"Áo polo nam thu đông","200000"));
        cartList.add(new Cart(R.drawable.imv_product_polo2,"Áo polo nam xuân hè","190000"));
        cartList.add(new Cart(R.drawable.img_product_polo1,"Áo polo nam co dãn","200000"));
        cartList.add(new Cart(R.drawable.img_product_polo1,"Áo polo nam co dãn","200000"));
        adapter = new CartAdapter(ViewDetailCartActivity.this,R.layout.activity_list_view_detail_cart,cartList );

        binding.lvProduct.setAdapter(adapter);
    }
}