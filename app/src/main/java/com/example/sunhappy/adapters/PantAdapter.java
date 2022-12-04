package com.example.sunhappy.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.sunhappy.R;
import com.example.sunhappy.functions.viewproduct.PantFragment;
import com.example.sunhappy.models.Pant;

import java.util.List;

public class PantAdapter extends BaseAdapter {
    PantFragment fragment;
    int item_layout;
    List<Pant> pants;

    //constructor

    public PantAdapter(PantFragment fragment, int item_layout, List<Pant> pants) {
        this.fragment = fragment;
        this.item_layout = item_layout;
        this.pants = pants;
    }

    //implement methhods

    @Override
    public int getCount() {
        return pants.size();
    }

    @Override
    public Object getItem(int i) {
        return pants.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        //return null;
        PantAdapter.ViewHolder holder = null;
        if (view == null){ // nếu khi mới tạo chưa hiển thị gì
            LayoutInflater inflater = LayoutInflater.from(fragment.getContext());
            view = inflater.inflate(item_layout, null);
            holder = new PantAdapter.ViewHolder();
            holder.imvProductImage = view.findViewById(R.id.imv_ProductImage);
            holder.txtProductName = view.findViewById(R.id.txt_ProductName);
            holder.txtProductPrice = view.findViewById(R.id.txt_ProductPrice);

            view.setTag(holder);
        }else{
            holder = (PantAdapter.ViewHolder) view.getTag();
        }
        Pant pant = pants.get(i);
        holder.imvProductImage.setImageResource(pant.getPantImage());
        holder.txtProductName.setText(pant.getPantName());
        holder.txtProductPrice.setText(String.valueOf(pant.getPantPrice()));
        return view;
    }
    public static class ViewHolder{
        ImageView imvProductImage;
        TextView txtProductName, txtProductPrice;
    }
}
