package com.example.sunhappy.adapters;

import static java.lang.String.valueOf;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sunhappy.R;
import com.example.sunhappy.databinding.DialogUpdateSizeColorBinding;
import com.example.sunhappy.functions.manageorder.ViewOderPreparingActivity;
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
//            holder.chkSelect = view.findViewById(R.id.chk_Select);
//            holder.imvMinus = view.findViewById(R.id.imv_Minus);
//            holder.imvPlus = view.findViewById(R.id.imv_Plus);
//            holder.txtValues = view.findViewById(R.id.txt_Values);

            view.setTag(holder);
        }else {
            holder = (ViewHolder) view.getTag();
        }
        ProductCart p = productCarts.get(i);

        holder.imvThumb.setImageResource(p.getProductThumb());
        holder.txtName.setText(p.getProductName());
        holder.txtDescription.setText(p.getProductDescription());
        holder.txtPrice.setText(String.valueOf(p.getProductPrice()));
// điều kiện ẩn hiện button khi nó vượt quá hoặc thấp
//        int sl;
//        ViewHolder viewHolder = new ViewHolder();
//        sl = Integer.parseInt(viewHolder.txtValues.getText().toString());
//        if (sl >10){
//            viewHolder.imvPlus.setVisibility(View.INVISIBLE);
//            ViewHolder.imvMinus.setVisibility(View.VISIBLE);
//        }else if(sl<=1){
//            ViewHolder.imvMinus.setVisibility(View.INVISIBLE);
//        }else if (sl>=1){
//            viewHolder.imvPlus.setVisibility(View.INVISIBLE);
//            viewHolder.imvMinus.setVisibility(View.INVISIBLE);
//        }
//        viewHolder.imvPlus.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                int update= Integer.parseInt(viewHolder.txtValues.getText().toString() + 1);
//            }
//        });

        holder.imvExpand.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                activity.openDialogUpdateColor(p);
            }
        });
//        holder.imvDelete.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                activity.openDialogDelete(p);
//            }
//        });

        return view;
    }
    public static class ViewHolder{
        public View chkSelect;
        public View imvDelete;
        public AdapterView<Adapter> txtDescriptionProduct;

        ImageView imvThumb;
        ImageView imvExpand;
        static ImageView imvMinus;
        ImageView imvPlus ;
        TextView txtName,txtDescription,txtValues,  txtPrice;
    }
}
