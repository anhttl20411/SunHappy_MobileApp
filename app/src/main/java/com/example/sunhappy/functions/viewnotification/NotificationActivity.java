package com.example.sunhappy.functions.viewnotification;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.sunhappy.R;
import com.example.sunhappy.adapters.NotificationAdapter;
import com.example.sunhappy.databinding.ActivityMainBinding;
import com.example.sunhappy.databinding.ActivityNotificationBinding;
import com.example.sunhappy.models.Notification;

import java.util.ArrayList;

public class NotificationActivity extends AppCompatActivity {

    ActivityNotificationBinding binding;
    NotificationAdapter adapter;
    ArrayList<Notification> notifications;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_notification);
        binding = ActivityNotificationBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        loadData();
    }

    private void loadData() { // tiếp bước 4
        notifications = new ArrayList<>();
        notifications.add(new Notification("Hi", "Hi there", "010202"));
        notifications.add(new Notification("Hello", "Hê sờ lô","284738"));
        adapter = new NotificationAdapter(NotificationActivity.this, R.layout.item_notification_list, notifications);
        binding.lvNotification.setAdapter(adapter);
    }
}