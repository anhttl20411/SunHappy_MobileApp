package com.example.sunhappy.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.sunhappy.R;
import com.example.sunhappy.functions.viewproduct.ShirtFragment;
import com.example.sunhappy.models.Shirt;

import java.util.List;

public class ShirtAdapter extends BaseAdapter {
    ShirtFragment fragment;
    int item_layout;
    List<Shirt> shirts;

    //constructor

    public ShirtAdapter(ShirtFragment fragment, int item_layout, List<Shirt> shirts) {
        this.fragment = fragment;
        this.item_layout = item_layout;
        this.shirts = shirts;
    }

    //implement methods

    @Override
    public int getCount() {
        return shirts.size();
    }

    @Override
    public Object getItem(int i) {
        return shirts.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        //return null;
        ShirtAdapter.ViewHolder holder = null;
        if (view == null){ // nếu khi mới tạo chưa hiển thị gì
            LayoutInflater inflater = LayoutInflater.from(fragment.getContext());
            view = inflater.inflate(item_layout, null);
            holder = new ShirtAdapter.ViewHolder();
            holder.imvProductImage = view.findViewById(R.id.imv_ProductImage);
            holder.txtProductName = view.findViewById(R.id.txt_ProductName);
            holder.txtProductPrice = view.findViewById(R.id.txt_ProductPrice);

            view.setTag(holder);
        }else{
            holder = (ShirtAdapter.ViewHolder) view.getTag();
        }
        Shirt shirt = shirts.get(i);
        holder.imvProductImage.setImageResource(shirt.getShirtImage());
        holder.txtProductName.setText(shirt.getShirtName());
        holder.txtProductPrice.setText(String.valueOf(shirt.getShirtPrice()));
        return view;
    }
    public static class ViewHolder{
        ImageView imvProductImage;
        TextView txtProductName, txtProductPrice;
    }
}
