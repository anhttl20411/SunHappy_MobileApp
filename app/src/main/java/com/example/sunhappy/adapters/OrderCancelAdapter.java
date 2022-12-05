package com.example.sunhappy.adapters;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sunhappy.R;
import com.example.sunhappy.functions.manageorder.ViewOderCancelledActivity;
import com.example.sunhappy.functions.manageorder.ViewOderDeliveredActivity;
import com.example.sunhappy.functions.viewcart.ProductCartActivity;
import com.example.sunhappy.models.CancelOrder;

import java.util.List;

public class OrderCancelAdapter extends BaseAdapter {
    //ViewOderCancelledActivity cancelAct;
    Activity activity;
    int item_layout;
    List<CancelOrder> cancelOrders;
    private Context context;

    public OrderCancelAdapter(Activity activity, int item_layout, List<CancelOrder> cancelOrders) {
        this.activity = activity;
        this.item_layout = item_layout;
        this.cancelOrders = cancelOrders;
    }

    @Override
    public int getCount() {
        return cancelOrders.size();
    }

    @Override
    public Object getItem(int i) {
        return cancelOrders.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        //return null;
        ViewHolder holder = null;
        if (view == null){ //
            holder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(item_layout, null);

            //ánh xạ
            holder.imvCancelImage = view.findViewById(R.id.img_ProductImageCancelled);
            holder.txtCancelName = view.findViewById(R.id.txt_ProductNameCancelled);
            holder.txtCancelPrice = view.findViewById(R.id.txt_ProductPriceCancelled);
            holder.btnBuyAgain = view.findViewById(R.id.btn_BuyAgain);

            view.setTag(holder);
        }else{
            holder = (ViewHolder) view.getTag();
        }
        CancelOrder cancelOr = cancelOrders.get(i);
        holder.imvCancelImage.setImageResource(cancelOr.getCancelImage());
        holder.txtCancelName.setText(cancelOr.getCancelName());
        holder.txtCancelPrice.setText(String.valueOf(cancelOr.getCancelPrice()));
        holder.btnBuyAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //cancelAct.buyAgain(cancelOr);
                Toast.makeText(activity, "Mua lại", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(activity, ProductCartActivity.class);
                activity.startActivity(intent);
            }
        });
        return view;
    }
    public static class ViewHolder{
        ImageView imvCancelImage;
        TextView txtCancelName, txtCancelPrice;
        Button btnBuyAgain;
    }
}
