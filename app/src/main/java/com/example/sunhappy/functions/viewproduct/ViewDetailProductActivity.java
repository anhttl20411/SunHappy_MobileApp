package com.example.sunhappy.functions.viewproduct;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.sunhappy.R;
import com.example.sunhappy.data.DatabaseHelper;
import com.example.sunhappy.databinding.ActivityViewDetailProductBinding;
import com.example.sunhappy.functions.payments.PaymentActivity;
import com.example.sunhappy.functions.viewcart.ProductCartActivity;
import com.example.sunhappy.models.ProductDetail;

public class ViewDetailProductActivity extends AppCompatActivity {

    ActivityViewDetailProductBinding binding;
    ImageButton btnAddFavorite;
    DatabaseHelper db;
    ProductDetail p;

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

        showProduct();
        addEvents();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.cart_option_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId())
        {
            case android.R.id.home:
                onBackPressed();
                return true;
            default:break;

        }
        if (item.getItemId() == R.id.mn_Cart) {
            Intent intent = new Intent(ViewDetailProductActivity.this, ProductCartActivity.class);
            startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }


    private void showProduct() {
        Intent intent = getIntent();
        //Receive data

//        int numb = intent.getIntExtra("numb", 8);
//        float grades = intent.getFloatExtra("grades", 8.9f);
//       boolean checked = intent.getBooleanExtra("checked", false);
//        String say = intent.getStringExtra("say");
        binding.imvProductImageDetail.setImageResource(intent.getIntExtra("image", R.drawable.img_product_polo1));
        binding.txtProductNameDetail.setText(intent.getStringExtra("name"));
        binding.txtProductPriceDetail.setText(String.valueOf(intent.getDoubleExtra("price", 20000)));
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

                    //update fravorite column
//                    db.execSql("UPDATE " + DatabaseHelper.TBL_NAME_PRODUCT + " SET " +
//                            DatabaseHelper.COL_FAVORITE_PRODUCT + " = false" +
//                            " WHERE " + DatabaseHelper.COL_NAME_PRODUCT + "=" +
//                            p.getProductDetailName());
//                    // UPDATE Product SET ProductName='Tiger', ProductPrice=18000 WHERE ProductId=2
//                    //loadData();

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

        binding.btnAddToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Dialog dialog = new Dialog(ViewDetailProductActivity.this);
                dialog.setContentView(R.layout.dialog_choose_size_color);

                //tạo sự kiện cho dialog hiện ra
                Button btnAddToCartConfirm;

                btnAddToCartConfirm = dialog.findViewById(R.id.btn_AddToCartConfirm);
                btnAddToCartConfirm.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(ViewDetailProductActivity.this, "Đã thêm vào giỏ hàng", Toast.LENGTH_SHORT).show();
                        dialog.dismiss();
                    }
                });

                dialog.show();
            }
        });

        binding.btnBuyNow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ViewDetailProductActivity.this, PaymentActivity.class);

//                intent.putExtra("image", binding.imvProductImageDetail.getResources());
//                intent.putExtra("name", binding.txtProductNameDetail.getText().toString());
//                intent.putExtra("price", binding.txtProductNameDetail.getText().toString());
                startActivity(intent);

            }
        });
    }
}