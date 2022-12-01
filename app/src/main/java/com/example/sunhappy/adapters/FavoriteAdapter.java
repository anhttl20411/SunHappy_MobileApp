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
import com.example.sunhappy.models.ProductFavorite;
import com.example.sunhappy.ui.user.UserFragment;

import java.util.List;

public class FavoriteAdapter extends BaseAdapter {
    UserFragment fragment;
    int item_layout;
    List<ProductFavorite> favorites;

    public FavoriteAdapter(UserFragment fragment, int item_layout, List<ProductFavorite> favorites) {
        this.fragment = fragment;
        this.item_layout = item_layout;
        this.favorites = favorites;
    }

    @Override
    public int getCount() {
        return favorites.size();
    }

    @Override
    public Object getItem(int position) {
        return favorites.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        FavoriteAdapter.ViewHolder holder;
        if(convertView==null){
            //linkview
            holder = new FavoriteAdapter.ViewHolder();
            LayoutInflater inflater = (LayoutInflater) fragment.getLayoutInflater();
            convertView = inflater.inflate(item_layout, null);
            holder.imvhinh = convertView.findViewById(R.id.imv_hinh);
            holder.txtName = convertView.findViewById(R.id.txt_tensp);
            holder.txtgia = convertView.findViewById(R.id.txt_giasp);

            convertView.setTag(holder);

        } else {
            holder = (ViewHolder)convertView.getTag();
        }
        ProductFavorite b = favorites.get(position);
        holder.imvhinh.setImageResource(b.getProductThumb());
        holder.txtName.setText(b.getProductName());
        holder.txtgia.setText(String.valueOf(b.getProductPrice()));


        return null;
    }

    public static class ViewHolder{
        ImageView imvhinh;
        TextView txtName,txtgia;
    }
}
