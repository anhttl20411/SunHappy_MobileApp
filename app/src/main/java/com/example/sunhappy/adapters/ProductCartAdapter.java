package com.example.sunhappy.adapters;

import static java.lang.String.valueOf;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sunhappy.R;
import com.example.sunhappy.functions.viewcart.ProductCartActivity;
import com.example.sunhappy.models.ProductCart;

import java.util.List;

public class ProductCartAdapter extends BaseAdapter {
    ProductCartActivity activity;
    int layout;
    List<ProductCart> productCarts ;
    Boolean isSelected = false;


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

            holder.imvThumbProduct = view.findViewById(R.id.imv_ThumbProduct);
            holder.txtName = view.findViewById(R.id.txt_NameProduct);
            holder.txtDescription = view.findViewById(R.id.txt_DescriptionProduct);
            holder.txtPrice = view.findViewById(R.id.txt_Price);
            holder.btnExpand = view.findViewById(R.id.btn_Expand);
            holder.btnMinus = view.findViewById(R.id.btn_Minus);
            holder.btnPlus = view.findViewById(R.id.btn_Plus);
            holder.txtValues = view.findViewById(R.id.txt_Values);
            holder.imvDelete = view.findViewById(R.id.imv_Delete);
            holder.chkSelect = view.findViewById(R.id.chk_Select);

            view.setTag(holder);
            holder.btnPlus.setTag(holder);
        }else {
            holder = (ViewHolder) view.getTag();
        }


        ProductCart p = productCarts.get(i);

        holder.imvThumbProduct.setImageResource(p.getProductThumb());
        holder.txtName.setText(p.getProductName());
        holder.txtDescription.setText(p.getProductDescription());
        holder.txtPrice.setText(valueOf(p.getProductPrice()));
        holder.txtValues.setText(p.getProductAmount()+"");
        ((CheckBox)holder.chkSelect).setChecked(p.isSelected());

        holder.btnExpand.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                activity.openDialogUpdateColor(p);
            }
        });

        holder.btnPlus .setOnClickListener(v-> {
            int currAmount = p.getProductAmount();
            int newAmount = (currAmount + 1);
            p.setProductAmount(newAmount);
            p.setProductPrice(p.getProductPrice() * newAmount / currAmount);

            this.notifyDataSetChanged();
        });
        holder.btnMinus.setOnClickListener(v -> {
            if(p.getProductAmount() <= 1) return;
            int currAmount = p.getProductAmount();
            int newAmount = (currAmount - 1);
            p.setProductAmount(newAmount);
            p.setProductPrice(p.getProductPrice() * newAmount / currAmount);

            this.notifyDataSetChanged();
        });

        holder.imvDelete.setOnClickListener(v -> {
           productCarts.remove(p);
            this.notifyDataSetChanged();
        });



        return view;
    }

   public void setShirtPro(ProductCart p ,String color,String size){
        p.setProductDescription("Mau "+ color + ", size "+ size);
        this.notifyDataSetChanged();
   }

    public void selectAll(){
        this.productCarts.stream().forEach( p -> p.setSelected(!isSelected));
        isSelected = !isSelected;
        this.notifyDataSetChanged();
    }

    public static class ViewHolder{
        public View  chkSelect;
        public View imvDelete;
        public AdapterView<Adapter> txtDescriptionProduct;

        ImageButton btnMinus, btnPlus, btnExpand;
        ImageView imvThumbProduct;
        TextView txtName,txtDescription,txtValues, txtPrice;
    }

}
