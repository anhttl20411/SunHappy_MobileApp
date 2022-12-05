package com.example.sunhappy.functions.chat;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageButton;

import com.example.sunhappy.MainActivity;
import com.example.sunhappy.R;
import com.example.sunhappy.databinding.ActivityChatBinding;
import com.example.sunhappy.functions.viewcart.ProductCartActivity;
import com.example.sunhappy.functions.viewnotification.NotificationActivity;

public class ChatActivity extends AppCompatActivity {
    ActivityChatBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // setContentView(R.layout.activity_chat);
        binding = ActivityChatBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowHomeEnabled(false);
        actionBar.setDisplayShowTitleEnabled(false);
        LayoutInflater li = LayoutInflater.from(this);
        View customView = li.inflate(R.layout.menu_home_cart, null);
        actionBar.setCustomView(customView);
        actionBar.setDisplayShowCustomEnabled(true);


        ImageButton btnChatHome = (ImageButton) customView.findViewById(R.id.mn_Chat_Home);
        btnChatHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // mở thông báo

                Intent intent = new Intent(ChatActivity.this, MainActivity.class);
                startActivity(intent);

            }
        });

        ImageButton btnChatCart = (ImageButton) customView.findViewById(R.id.mn_Chat_Cart);
        btnChatCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // mở giỏ hàng

                Intent intent = new Intent(ChatActivity.this, ProductCartActivity.class);
                startActivity(intent);
            }
        });

    }

}