package com.example.sunhappy.adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.sunhappy.R;
import com.example.sunhappy.models.PreparingOrder;

import java.util.List;

public class OrderPreparingAdapter extends BaseAdapter {
    Activity activity;
    int item_layout;
    List<PreparingOrder> preparingOrders;

    public OrderPreparingAdapter(Activity activity, int item_layout, List<PreparingOrder> preparingOrders) {
        this.activity = activity;
        this.item_layout = item_layout;
        this.preparingOrders = preparingOrders;
    }

    @Override
    public int getCount() {
        return preparingOrders.size();
    }

    @Override
    public Object getItem(int i) {
        return preparingOrders.get(i);
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
            holder.imvPreparingImage = view.findViewById(R.id.img_ProductImagePreparing);
            holder.txtPreparingName = view.findViewById(R.id.txt_ProductNamePreparing);
            holder.txtPreparingPrice = view.findViewById(R.id.txt_ProductPricePreparing);

            view.setTag(holder);
        }else{
            holder = (ViewHolder) view.getTag();
        }
        PreparingOrder preOr = preparingOrders.get(i);
        holder.imvPreparingImage.setImageResource(preOr.getPreparingImage());
        holder.txtPreparingName.setText(preOr.getPreparingName());
        holder.txtPreparingPrice.setText(String.valueOf(preOr.getPreparingPrice()));
        return view;

    }
    public static class ViewHolder{
        ImageView imvPreparingImage;
        TextView txtPreparingName, txtPreparingPrice;
    }
}