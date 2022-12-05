package com.example.sunhappy.functions.manageorder;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Html;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sunhappy.R;
import com.example.sunhappy.databinding.ActivityViewDetailPreparingBinding;
import com.example.sunhappy.models.PreparingOrder;

import java.util.ArrayList;

public class ViewDetailPreparingActivity extends AppCompatActivity {
    ActivityViewDetailPreparingBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_view_detail_preparing);
        binding= ActivityViewDetailPreparingBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        //tạo nút back
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle(Html.fromHtml("<font color='#ffd24c'>Chi tiết đơn hàng</font>"));
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setDisplayUseLogoEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_baseline_arrow_back_24);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        loadData();
        addEvents();
    }

    private void loadData() {
        Intent intent = getIntent();
        //Receive data
        binding.imgSubProductImagePreparing.setImageResource(intent.getIntExtra("image", R.drawable.img_product_polo1));
        binding.txtSubProductNamePreparing.setText(intent.getStringExtra("name"));
        binding.txtProductPricePreparingDetail.setText(String.valueOf(intent.getDoubleExtra("price", 20000)));
    }

    private void addEvents() {
        Button btnCancel = findViewById(R.id.btn_CancelOder);
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openCancelDialog(Gravity.CENTER);
            }
        });
    }

    private void openCancelDialog(int gravity){
        //final
        final Dialog dialog = new Dialog(ViewDetailPreparingActivity.this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_choose_reason_cancel);
        Window window = dialog.getWindow();
        if(window == null){
            return;
        }
        // xử lý xác định vị trí của dialog
        window.setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
        window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        WindowManager.LayoutParams windowAttributes = window.getAttributes();
        windowAttributes.gravity = gravity;
        window.setAttributes(windowAttributes);
        // bấm ra ngoài không tắt dialog
        dialog.setCancelable(false);

        Button btnExit = dialog.findViewById(R.id.btn_ExitReason);
        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });

        Button btnConfirm = dialog.findViewById(R.id.btn_ConfirmCancel);
        btnConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
                Toast.makeText(ViewDetailPreparingActivity.this, "Đã hủy thành công!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(ViewDetailPreparingActivity.this, ViewOderCancelledActivity.class);

                intent.putExtra("image", R.drawable.img_polo_1);
                intent.putExtra("name", binding.txtSubProductNamePreparing.getText().toString());
                intent.putExtra("price", binding.txtProductPricePreparingDetail.getText());
                startActivity(intent);
            }
        });
        dialog.show();


    }
    //tạo sự kiện cho nút back
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