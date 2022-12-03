package com.example.sunhappy.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.sunhappy.R;
import com.example.sunhappy.functions.viewproduct.TshirtFragment;
import com.example.sunhappy.models.Tshirt;

import java.util.List;

public class TshirtAdapter extends BaseAdapter {
    TshirtFragment fragment;
    int item_layout;
    List<Tshirt> tshirts;

    //constructor

    public TshirtAdapter(TshirtFragment fragment, int item_layout, List<Tshirt> tshirts) {
        this.fragment = fragment;
        this.item_layout = item_layout;
        this.tshirts = tshirts;
    }

    //implement methods

    @Override
    public int getCount() {
        return tshirts.size();
    }

    @Override
    public Object getItem(int i) {
        return tshirts.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        //return null;
        TshirtAdapter.ViewHolder holder = null;
        if (view == null){ // nếu khi mới tạo chưa hiển thị gì
            LayoutInflater inflater = LayoutInflater.from(fragment.getContext());
            view = inflater.inflate(item_layout, null);
            holder = new TshirtAdapter.ViewHolder();
            holder.imvProductImage = view.findViewById(R.id.imv_ProductImage);
            holder.txtProductName = view.findViewById(R.id.txt_ProductName);
            holder.txtProductPrice = view.findViewById(R.id.txt_ProductPrice);

            view.setTag(holder);
        }else{
            holder = (TshirtAdapter.ViewHolder) view.getTag();
        }
        Tshirt tshirt = tshirts.get(i);
        holder.imvProductImage.setImageResource(tshirt.getTshirtImage());
        holder.txtProductName.setText(tshirt.getTshirtName());
        holder.txtProductPrice.setText(String.valueOf(tshirt.getTshirtPrice()));
        return view;
    }
    public static class ViewHolder{
        ImageView imvProductImage;
        TextView txtProductName, txtProductPrice;
    }
}
