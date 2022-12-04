package com.example.sunhappy.functions.payments;

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
import android.widget.EditText;

import com.example.sunhappy.MainActivity;
import com.example.sunhappy.R;
import com.example.sunhappy.databinding.ActivityPaymentBinding;
import com.example.sunhappy.functions.manageorder.ViewOderPreparingActivity;

public class PaymentActivity extends AppCompatActivity {

    ActivityPaymentBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityPaymentBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle(Html.fromHtml("<font color='#ffd24c'>Thay đổi email</font>"));
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setDisplayUseLogoEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_baseline_arrow_back_yellow);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        binding.linerAddress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PaymentActivity.this, UpdateAddress.class);
                startActivity(intent);
            }
        });
        binding.linerPayment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PaymentActivity.this, MethodPayment.class);
                startActivity(intent);

            }

        });
        binding.linerLuuY.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                OpenDialog1(Gravity.CENTER);
            }
        });

        binding.btnDatHang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                OpenDialog(Gravity.CENTER);
            }
        });
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

        return super.onOptionsItemSelected(item);
    }
    private void OpenDialog(int gravity)
    {
//        Khai báo và chèn thuộc tính cho diglog + window chứa nó
        final Dialog dialog = new Dialog(PaymentActivity.this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_thongbao_dathang);

        Window window = dialog.getWindow();
        if (window == null){
            return;
        }


        window.setLayout(WindowManager.LayoutParams.MATCH_PARENT,WindowManager.LayoutParams.WRAP_CONTENT);
        window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        WindowManager.LayoutParams windowAttributes = window.getAttributes();
        windowAttributes.gravity = gravity;
        window.setAttributes(windowAttributes);

        dialog.setCancelable(true);

        //khai báo
        Button btnBackToHome, btnViewDoneOrder;
        //ánh xạ
        btnBackToHome = dialog.findViewById(R.id.btn_BackToHome);
        btnViewDoneOrder = dialog.findViewById(R.id.btn_ViewDoneOrder);
        //chèn sự kiện
        btnBackToHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PaymentActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        btnViewDoneOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PaymentActivity.this, ViewOderPreparingActivity.class);
                startActivity(intent);
            }
        });

        dialog.show();

    }
    private void OpenDialog1(int gravity)
    {
//        Khai báo và chèn thuộc tính cho diglog + window chứa nó
        final Dialog dialog = new Dialog(PaymentActivity.this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_luuy);

        Window window = dialog.getWindow();
        if (window == null){
            return;
        }


        window.setLayout(WindowManager.LayoutParams.MATCH_PARENT,WindowManager.LayoutParams.WRAP_CONTENT);
        window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        WindowManager.LayoutParams windowAttributes = window.getAttributes();
        windowAttributes.gravity = gravity;
        window.setAttributes(windowAttributes);

        dialog.setCancelable(true);

        //khai báo
       EditText editText = dialog.findViewById(R.id.edt_luuy);
       Button btn = dialog.findViewById(R.id.btn_luuy);
        //ánh xạ

        //chèn sự kiện
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               String s = editText.getText().toString();
               binding.paymentLuuy.setText(s);
            }
        });


        dialog.show();

    }
}