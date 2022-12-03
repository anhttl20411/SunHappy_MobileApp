package com.example.sunhappy.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.sunhappy.R;
import com.example.sunhappy.functions.viewnotification.NotificationActivity;
import com.example.sunhappy.models.Notification;

import java.util.List;

public class NotificationAdapter extends BaseAdapter {
    NotificationActivity activity;
    int item_layout;
    List<Notification> notifications;

    //constructor

    public NotificationAdapter(NotificationActivity activity, int item_layout, List<Notification> notifications) {
        this.activity = activity;
        this.item_layout = item_layout;
        this.notifications = notifications;
    }


    //implement methods

    @Override
    public int getCount() {
        //return 0;
        return notifications.size();
    }

    @Override
    public Object getItem(int i) {
        //return null;
        return notifications.get(i);
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

            holder.txtNotificationTitle = view.findViewById(R.id.txt_notificationTitle);
            holder.txtNotificationContent = view.findViewById(R.id.txt_notificationContent);
            holder.txtNotificationTime = view.findViewById(R.id.txt_notificationTime);

            view.setTag(holder);
        }else{
            holder = (ViewHolder) view.getTag();
        }
        Notification p = notifications.get(i);
        holder.txtNotificationTitle.setText("Hi");
        holder.txtNotificationContent.setText("Hê sờ lô");
        holder.txtNotificationTime.setText("01-21");
        return view;
    }
    public static class ViewHolder{
        TextView txtNotificationTitle, txtNotificationContent, txtNotificationTime;
    }
}
