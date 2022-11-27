package com.example.sunhappy.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.sunhappy.R;
import com.example.sunhappy.functions.viewcart.ViewDetailCartActivity;
import com.example.sunhappy.models.Cart;

import java.util.ArrayList;
import java.util.List;

public class CartAdapter extends BaseAdapter {
    ViewDetailCartActivity viewDetailCartActivity;
    int item_layout;
    List<com.example.sunhappy.models.Cart>cart;
    public CartAdapter(ViewDetailCartActivity viewDetailCartActivity, int item_layout, ArrayList<Cart> cartList) {
        this.viewDetailCartActivity = viewDetailCartActivity;
        this.item_layout = item_layout;
        this.cart = cart;
    }

    @Override
    public int getCount()
    {
        return cart.size();
    }

    @Override
    public Object getItem(int i)
    {
       return  cart.get(i);

    }

    @Override
    public long getItemId(int i) {

        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup)
    {
        ViewHolder holder;

        if(view == null){
            holder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) viewDetailCartActivity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(item_layout, null);
            holder.imvThumb = view.findViewById(R.id.imvThumb);
            holder.txtName = view.findViewById(R.id.txt_Name);
            holder.txtPrice = view.findViewById(R.id.txt_Price);
            view.setTag(holder);
        }else {
            holder = (ViewHolder)  view.getTag();
        }
        Cart c= cart.get(i);
        holder.imvThumb.setImageResource(c.getProductThumb());
        holder.txtName.setText(c.getProductName());
        holder.txtPrice.setText(String.valueOf(c.getProductPrice()));

        return view;
    }
    public static class ViewHolder{
        ImageView imvThumb;
        TextView txtName, txtPrice;
    }
    }


