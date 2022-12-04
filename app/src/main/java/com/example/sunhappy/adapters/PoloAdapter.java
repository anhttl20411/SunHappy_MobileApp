package com.example.sunhappy.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.sunhappy.R;
import com.example.sunhappy.functions.viewproduct.PoloFragment;
import com.example.sunhappy.models.Polo;

import java.util.List;

public class PoloAdapter extends BaseAdapter {
    //Activity activity;
    PoloFragment fragment;
    int item_layout;
    List<Polo> polos;

    //constructor

    public PoloAdapter(PoloFragment fragment, int item_layout, List<Polo> polos) {
        this.fragment = fragment;
        this.item_layout = item_layout;
        this.polos = polos;
    }


    //implement methods


    @Override
    public int getCount() {
        return polos.size();
    }

    @Override
    public Object getItem(int i) {
        return polos.get(i);
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
            holder = new ViewHolder();
            holder.imvProductImage = view.findViewById(R.id.imv_ProductImage);
            holder.txtProductName = view.findViewById(R.id.txt_ProductName);
            holder.txtProductPrice = view.findViewById(R.id.txt_ProductPrice);

            view.setTag(holder);
        }else{
            holder = (ViewHolder) view.getTag();
        }
        Polo polo = polos.get(i);
        holder.imvProductImage.setImageResource(polo.getPoloImage());
        holder.txtProductName.setText(polo.getPoloName());
        holder.txtProductPrice.setText(String.valueOf(polo.getPoloPrice()));
        return view;
    }
    public static class ViewHolder{
        ImageView imvProductImage;
        TextView txtProductName, txtProductPrice;
    }



}
