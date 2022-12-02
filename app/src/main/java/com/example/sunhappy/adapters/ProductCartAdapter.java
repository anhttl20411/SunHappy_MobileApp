package com.example.sunhappy.adapters;

import static java.lang.String.valueOf;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.sunhappy.R;
import com.example.sunhappy.functions.viewcart.ProductCartActivity;
import com.example.sunhappy.models.ProductCart;

import java.util.List;

public class ProductCartAdapter extends BaseAdapter {
    ProductCartActivity activity;
    int layout;
    List<ProductCart> productCarts ;

    public ProductCartAdapter(ProductCartActivity activity, int layout, List<ProductCart> productCarts) {
        this.activity = activity;
        this.layout = layout;
        this.productCarts = productCarts;
    }

    @Override
    public int getCount() {
        return productCarts.size();
    }

    @Override
    public Object getItem(int i) {
        return productCarts.get(i);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder = null;
        if (view == null) {
            holder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(layout, null);

            holder.imvThumb = view.findViewById(R.id.imv_ThumbProduct);
            holder.txtName = view.findViewById(R.id.txt_NameProduct);
            holder.txtDescription = view.findViewById(R.id.txt_DescriptionProduct);
            holder.txtPrice = view.findViewById(R.id.txt_Price);
            holder.imvExpand = view.findViewById(R.id.imv_Expand);

            view.setTag(holder);
        }else {
            holder = (ViewHolder) view.getTag();
        }
        ProductCart p = productCarts.get(i);

        holder.imvThumb.setImageResource(p.getProductThumb());
        holder.txtName.setText(p.getProductName());
        holder.txtDescription.setText(p.getProductDescription());
        holder.txtPrice.setText(String.valueOf(p.getProductPrice()));
        holder.imvExpand.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                activity.openDialogChooseColor(p);
            }
        });

        return view;
    }
    public static class ViewHolder{
        ImageView imvThumb, imvExpand ;
        TextView txtName,txtDescription, txtPrice;
    }
}
