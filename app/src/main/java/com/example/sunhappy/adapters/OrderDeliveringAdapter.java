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
import com.example.sunhappy.functions.manageorder.ViewDetailPreparingActivity;
import com.example.sunhappy.functions.manageorder.ViewOderCancelledActivity;
import com.example.sunhappy.functions.manageorder.ViewOderDeliveredActivity;
import com.example.sunhappy.models.DeliveringOrder;
import com.example.sunhappy.models.PreparingOrder;

import java.util.List;

public class OrderDeliveringAdapter extends BaseAdapter {

    Activity activity;
    int item_layout;
    List<DeliveringOrder> deliveringOrders;

    public OrderDeliveringAdapter(Activity activity, int item_layout, List<DeliveringOrder> deliveringOrders) {
        this.activity = activity;
        this.item_layout = item_layout;
        this.deliveringOrders = deliveringOrders;
    }

    @Override
    public int getCount() {
        return deliveringOrders.size();
    }

    @Override
    public Object getItem(int i) {
        return deliveringOrders.get(i);
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
                holder.imvDeliveringImage = view.findViewById(R.id.img_ProductImageDelivering);
                holder.txtDeliveringName = view.findViewById(R.id.txt_ProductNameDelivering);
                holder.txtDeliveringPrice = view.findViewById(R.id.txt_ProductPriceDelivering);
                holder.btnReceived = view.findViewById(R.id.btn_Received);

                view.setTag(holder);
            }else{
                holder = (OrderDeliveringAdapter.ViewHolder) view.getTag();
            }
            DeliveringOrder dlvringOr = deliveringOrders.get(i);
            holder.imvDeliveringImage.setImageResource(dlvringOr.getDeliveringImage());
            holder.txtDeliveringName.setText(dlvringOr.getDeliveringName());
            holder.txtDeliveringPrice.setText(String.valueOf(dlvringOr.getDeliveringPrice()));

            holder.btnReceived.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(activity, "Đã nhận hàng thành công", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(activity, ViewOderDeliveredActivity.class);
                    intent.putExtra("image", R.drawable.img_polo_1);
                    activity.startActivity(intent);

                }
            });

        return view;

    }
    public static class ViewHolder{
        ImageView imvDeliveringImage;
        TextView txtDeliveringName, txtDeliveringPrice;
        Button btnReceived;
        TextView txtSubProductNameDelivering,txtProductPriceDeliveringDetail ;
    }
}
