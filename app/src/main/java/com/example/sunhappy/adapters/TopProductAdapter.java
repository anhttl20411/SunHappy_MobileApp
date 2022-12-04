package com.example.sunhappy.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import com.example.sunhappy.R;
import com.example.sunhappy.models.TopProduct;
import com.example.sunhappy.ui.home.HomeFragment;

import java.util.List;

public class TopProductAdapter extends BaseAdapter {
    //Activity activity;
    HomeFragment fragment;
    int item_layout;
    List<TopProduct> topProducts;
    
    //constructor

    public TopProductAdapter(HomeFragment fragment, int item_layout, List<TopProduct> topProducts) {
        this.fragment = fragment;
        this.item_layout = item_layout;
        this.topProducts = topProducts;
    }


    //implement methods

    @Override
    public int getCount() {
        return topProducts.size();
    }

    @Override
    public Object getItem(int i) {
        return topProducts.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        //return null;
        ViewHolder holder = null;
        if (view == null){ // nếu khi mới tạo chưa hiển thị gì
            LayoutInflater inflater = LayoutInflater.from(fragment.getContext());
            view = inflater.inflate(item_layout, null);
            holder = new TopProductAdapter.ViewHolder();
            //LayoutInflater inflater = (LayoutInflater) fragment.getLayoutInflater(); // sửa
            //view = inflater.inflate(item_layout, null);
            holder.imvTopProductImage = view.findViewById(R.id.imv_ProductImage);
            holder.txtTopProductName = view.findViewById(R.id.txt_ProductName);
            holder.txtTopProductPrice = view.findViewById(R.id.txt_ProductPrice);
            view.setTag(holder);
        }else{
            holder = (TopProductAdapter.ViewHolder) view.getTag();
        }
        TopProduct tp = topProducts.get(i);
        holder.imvTopProductImage.setImageResource(tp.getTopProductImage());
        holder.txtTopProductName.setText(tp.getTopProductName());
        holder.txtTopProductPrice.setText(String.valueOf(tp.getTopProductPrice()));
        return view;
    }
    public static class ViewHolder{
        ImageView imvTopProductImage;
        TextView txtTopProductName, txtTopProductPrice;
    }
}
