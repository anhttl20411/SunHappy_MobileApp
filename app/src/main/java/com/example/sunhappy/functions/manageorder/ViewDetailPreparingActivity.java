package com.example.sunhappy.functions.manageorder;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.sunhappy.R;
import com.example.sunhappy.databinding.ActivityViewDetailOderBinding;
import com.example.sunhappy.databinding.ActivityViewDetailPreparingBinding;

public class ViewDetailPreparingActivity extends AppCompatActivity {
    ActivityViewDetailPreparingBinding binding;
    ImageView image;
    TextView name, total, classify, amount, size;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_view_detail_preparing);
        binding= ActivityViewDetailPreparingBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        Button btnCancel = findViewById(R.id.btn_CancelOder);
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openCancelDialog(Gravity.CENTER);

            }
        });
        name = findViewById(R.id.txt_SubProductNamePreparing);
        total =findViewById(R.id.txt_SubTotalPreparing);
        amount =findViewById(R.id.txt_SubProductAmountPreparing);
        image =findViewById(R.id.img_SubProductImagePreparing);
        classify=findViewById(R.id.txt_SubProductClassifyPreparing);
        size = findViewById(R.id.txt_SubProductSizePreparing);
        Intent intent = getIntent();
        String nameProduct= intent.getStringExtra("name");
        name.setText(nameProduct);
        String classifyProduct=intent.getStringExtra("classify");
        classify.setText(classifyProduct);
        String sizeProduct=intent.getStringExtra("size");
        size.setText(sizeProduct);
        int totalProduct=intent.getIntExtra("total", 0);
        total.setText(""+ totalProduct);
        int amountProduct=intent.getIntExtra("amount", 0);
        amount.setText(""+ amountProduct);
        int imgProduct=intent.getIntExtra("image", 0);
        image.setImageResource(imgProduct);
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
        Button btnConfirm = dialog.findViewById(R.id.btn_ConfirmCancel);
        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                dialog.dismiss();
            }
        });
        dialog.show();

    }
}