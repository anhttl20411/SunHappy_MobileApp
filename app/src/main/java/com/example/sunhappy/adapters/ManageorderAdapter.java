package com.example.sunhappy.adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.sunhappy.R;
import com.example.sunhappy.models.OrderPreparing;

import java.util.ArrayList;

public class ManageorderAdapter extends ArrayAdapter<OrderPreparing> {
    //khai báo 3 biến đặc trưng cho 3 tham số của adapter
    Activity context;
    int layout;
    ArrayList<OrderPreparing> list;

//tạo constructor
    public ManageorderAdapter( Activity context, int layout, ArrayList<OrderPreparing> list) {
        super(context, layout,list);
        this.context = context;
        this.layout = layout;
        this.list = list;
    }
//gọi hàm getView để sắp xếp dữ liệu
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
//tạo đế chứa layout
        LayoutInflater layoutInflater = context.getLayoutInflater();
        //đặt layout lên đế
        convertView = layoutInflater.inflate(layout,null);
//lấy từng phần tử trong mảng
        OrderPreparing orderPreparing = list.get(position);
//KB tham chiếu id và hiển thị
        ImageView img = convertView.findViewById(R.id.img_ProductImagePreparing);
        img.setImageResource(orderPreparing.ProductImage);

        TextView txtName = convertView.findViewById(R.id.txt_ProductNamePreparing);
        txtName.setText(orderPreparing.ProductNamePreparing);

        TextView txtPrice = convertView.findViewById(R.id.txt_ProductPricePreparing);
        txtPrice.setText(orderPreparing.ProductPricePreparing +"");

        TextView txtClassify = convertView.findViewById(R.id.txt_ProductClassifyPreparing);
        txtClassify.setText(orderPreparing.ProductClassifyPreparing);

        TextView txtAmount = convertView.findViewById(R.id.txt_ProductAmountPreparing);
        txtAmount.setText(orderPreparing.ProductAmountPreparing +"");

        TextView txtSize = convertView.findViewById(R.id.txt_ProductSizePreparing);
        txtSize.setText(orderPreparing.ProductSizePreparing);

        return convertView;
    }
}
