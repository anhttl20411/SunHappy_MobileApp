package com.example.sunhappy.adapters;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sunhappy.R;
import com.example.sunhappy.functions.chat.ChatActivity;
import com.example.sunhappy.functions.viewcart.ProductCartActivity;
import com.example.sunhappy.models.DeliveredOrder;
import com.example.sunhappy.models.PreparingOrder;

import java.util.List;

public class OrderDeliveredAdapter extends BaseAdapter {
    Activity activity;
    int item_layout;
    List<DeliveredOrder> deliveredOrders;

    public OrderDeliveredAdapter(Activity activity, int item_layout, List<DeliveredOrder> deliveredOrders) {
        this.activity = activity;
        this.item_layout = item_layout;
        this.deliveredOrders = deliveredOrders;
    }

    @Override
    public int getCount() {
        return deliveredOrders.size();
    }

    @Override
    public Object getItem(int i) {
        return deliveredOrders.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        //return null;
        ViewHolder holder = null;
        if (view == null){ //
            holder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(item_layout, null);
            holder.imvDeliveredImage = view.findViewById(R.id.img_ProductImageDelivered);
            holder.txtDeliveredName = view.findViewById(R.id.txt_ProductNameDelivered);
            holder.txtDeliveredPrice = view.findViewById(R.id.txt_ProductPriceDelivered);
            holder.btnFeedback = view.findViewById(R.id.btn_Feedback);
            holder.btnRepurchase = view.findViewById(R.id.btn_Repurchase);

            view.setTag(holder);
        }else{
            holder = (ViewHolder) view.getTag();
        }
        DeliveredOrder dlvredOr = deliveredOrders.get(i);
        holder.imvDeliveredImage.setImageResource(dlvredOr.getDeliveredImage());
        holder.txtDeliveredName.setText(dlvredOr.getDeliveredName());
        holder.txtDeliveredPrice.setText(String.valueOf(dlvredOr.getDeliveredPrice()));
        holder.btnRepurchase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(activity, "Đã thêm sản phẩm vào giỏ hàng", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(activity, ProductCartActivity.class);
                activity.startActivity(intent);
            }
        });

        holder.btnFeedback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(activity, "Đã thêm sản phẩm vào giỏ hàng", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(activity, ChatActivity.class);
                activity.startActivity(intent);
            }
        });

        return view;

    }
    public static class ViewHolder{
        ImageView imvDeliveredImage;
        TextView txtDeliveredName, txtDeliveredPrice;
        Button btnFeedback, btnRepurchase;
    }
}
