package com.example.sunhappy.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.sunhappy.R;
import com.example.sunhappy.functions.viewproduct.ShortFragment;
import com.example.sunhappy.models.Short;

import java.util.List;

public class ShortAdapter extends BaseAdapter {
    ShortFragment fragment;
    int item_layout;
    List<Short> shorts;

    //constructor

    public ShortAdapter(ShortFragment fragment, int item_layout, List<Short> shorts) {
        this.fragment = fragment;
        this.item_layout = item_layout;
        this.shorts = shorts;
    }

    //implement methods

    @Override
    public int getCount() {
        return shorts.size();
    }

    @Override
    public Object getItem(int i) {
        return shorts.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        //return null;
        ShortAdapter.ViewHolder holder = null;
        if (view == null){ // nếu khi mới tạo chưa hiển thị gì
            LayoutInflater inflater = LayoutInflater.from(fragment.getContext());
            view = inflater.inflate(item_layout, null);
            holder = new ShortAdapter.ViewHolder();
            holder.imvProductImage = view.findViewById(R.id.imv_ProductImage);
            holder.txtProductName = view.findViewById(R.id.txt_ProductName);
            holder.txtProductPrice = view.findViewById(R.id.txt_ProductPrice);

            view.setTag(holder);
        }else{
            holder = (ShortAdapter.ViewHolder) view.getTag();
        }
        Short sh = shorts.get(i);
        holder.imvProductImage.setImageResource((sh.getShortImage()));
        holder.txtProductName.setText(sh.getShortName());
        holder.txtProductPrice.setText(String.valueOf(sh.getShortPrice()));
        return view;
    }
    public static class ViewHolder{
        ImageView imvProductImage;
        TextView txtProductName, txtProductPrice;
    }

}
