package com.example.sunhappy.adapters;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.sunhappy.MainActivity;
import com.example.sunhappy.R;
import com.example.sunhappy.models.ProductAll;

import java.util.List;

public class ProductAllAdapter extends BaseAdapter {
    MainActivity activity;
    int item_layout;
    List<ProductAll> productAlls;

    //constructor

    public ProductAllAdapter(MainActivity activity, int item_layout, List<ProductAll> productAlls) {
        this.activity = activity;
        this.item_layout = item_layout;
        this.productAlls = productAlls;
    }

    //implement methods

    @Override
    public int getCount() {
        //return 0;
        return productAlls.size();
    }

    @Override
    public Object getItem(int i) {
        //return null;
        return productAlls.get(i);
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
            holder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(item_layout, null);

            holder.imvProductImage = view.findViewById(R.id.imv_ProductImage);
            holder.txtProductName = view.findViewById(R.id.txt_ProductName);
            holder.txtProductPrice = view.findViewById(R.id.txt_ProductPrice);

            view.setTag(holder);
        }else{
            holder = (ProductAllAdapter.ViewHolder) view.getTag();
        }
        ProductAll p = productAlls.get(i);
        //holder.imvProductImage.setImageResource(p.getProductImage());
        holder.txtProductPrice.setText(p.getProductName());
        //holder.txtProductPrice.setText(toString(productAll.getProductPrice()));

        return view;


    }
    public static class ViewHolder{
        ImageView imvProductImage;
        TextView txtProductName, txtProductPrice;
    }
}
