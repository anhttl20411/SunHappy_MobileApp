package com.example.sunhappy.functions.viewcart;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Toast;

import com.example.sunhappy.R;
import com.example.sunhappy.adapters.ProductCartAdapter;
import com.example.sunhappy.databinding.ActivityProductCartBinding;
import com.example.sunhappy.functions.manageorder.ViewOderPreparingActivity;
import com.example.sunhappy.functions.payments.PaymentActivity;
import com.example.sunhappy.models.ProductCart;

import java.util.ArrayList;

public class ProductCartActivity extends AppCompatActivity {

    ActivityProductCartBinding binding;
    ProductCartAdapter adapter;
    ArrayList<ProductCart> productCartArrayList;
    private ProductCart p;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //  setContentView(R.layout.activity_product_cart);
        binding = ActivityProductCartBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        loadData();
// nhấn nút buy để chuyển sang trang trạng thái mua hàng
        binding.btnBuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ProductCartActivity.this, PaymentActivity.class);
                startActivity(intent);
            }
        });
        binding.chkSelectAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(ProductCartActivity.this, "Bạn đã chọn tất cả các sản phẩm", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void openDialogUpdateColor(ProductCart p) {
        Dialog dialog = new Dialog(ProductCartActivity.this);
        dialog.setContentView(R.layout.dialog_update_size_color);
        dialog.show();
        // nhấn nút xác nhận khi thay đổi
        Button btn_UpdateToCartConfirm;
        btn_UpdateToCartConfirm = dialog.findViewById(R.id.btn_UpdateToCartConfirm);
        btn_UpdateToCartConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(ProductCartActivity.this, "Bạn đã cập nhật màu và size  sản phẩm", Toast.LENGTH_SHORT).show();
                // chèn sự kiện chọn cái radio cho nó cập nhật qua bên kia
                Intent intent = new Intent(ProductCartActivity.this,ProductCartAdapter.class);
                startActivity(intent);
            }
        });
        View imvClose = dialog.findViewById(R.id.imv_Close);
        imvClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
        dialog.show();
    }
    private void loadData(){
        productCartArrayList = new ArrayList<>();
        productCartArrayList.add(new ProductCart(R.drawable.imv_white_polo, "Áo polo nam", "Aó polo màu đen",180000));
        productCartArrayList.add(new ProductCart(R.drawable.imv_white_polo, "Áo polo nam", "Aó polo màu đen",180000));

        adapter = new ProductCartAdapter(ProductCartActivity.this, R.layout.activity_product_cart_list,productCartArrayList);
        binding.lvProduct.setAdapter(adapter);
    }

//    public void openDialogDelete(ProductCart p) {
//        Intent intent = new Intent(ProductCartActivity.this,ProductCartAdapter.class);
//        startActivity(intent);
//
////        Button  btnCancel;
////
////        btnCancel = dialog.findViewById(R.id.btn_cancel);
////        btnCancel.setOnClickListener(new View.OnClickListener() {
////            @Override
////            public void onClick(View view) {
////                dialog.dismiss();
////            }
////        });
////        dialog.show();
//
//    }
}
