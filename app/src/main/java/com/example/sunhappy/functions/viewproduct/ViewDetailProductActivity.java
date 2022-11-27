package com.example.sunhappy.functions.viewproduct;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.sunhappy.R;
import com.example.sunhappy.databinding.ActivityViewDetailProductBinding;

public class ViewDetailProductActivity extends AppCompatActivity {

    ActivityViewDetailProductBinding binding;
    ImageButton btnAddFavorite;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_view_detail_product);
        binding = ActivityViewDetailProductBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ActionBar actionBar = getSupportActionBar();

        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setLogo(R.drawable.logo_horizontal_color);    //Icon muốn hiện thị
        actionBar.setDisplayUseLogoEnabled(true);

        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_baseline_arrow_back_24);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        addEvents();
    }

    private void addEvents() {
        binding.btnAddFavorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //((ImageButton) view).setImageResource(R.drawable.ic_favorite);
                //Toast.makeText(ViewDetailProductActivity.this, "Đã thêm sản phẩm vào danh sách yêu thích", Toast.LENGTH_SHORT).show();

                if ((binding.btnAddFavorite.getTag() == null) || (binding.btnAddFavorite.getTag() == "no_favorite")) // để mặc định là no_favorite
                {
                    binding.btnAddFavorite.setImageResource(R.drawable.ic_favorite); // cách 1
                    //((ImageButton) view).setImageResource(R.drawable.ic_favorite);
                    Toast.makeText(ViewDetailProductActivity.this, "Đã thêm vào danh sách yêu thích", Toast.LENGTH_SHORT).show();
                    binding.btnAddFavorite.setTag("favorite"); // settag dùng để đánh dấu
                }
                else
                {
                    //btnAddFavorite.setImageResource(R.drawable.ic_favorite_border);
                    ((ImageButton) view).setImageResource(R.drawable.ic_favorite_border); // cách 2
                    Toast.makeText(ViewDetailProductActivity.this, "Đã xóa khỏi danh sách yêu thích", Toast.LENGTH_SHORT).show();
                    binding.btnAddFavorite.setTag("no_favorite");
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.cart_option_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }





}