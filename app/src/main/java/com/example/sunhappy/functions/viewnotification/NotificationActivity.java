package com.example.sunhappy.functions.viewnotification;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.example.sunhappy.R;
import com.example.sunhappy.adapters.NotificationAdapter;
import com.example.sunhappy.databinding.ActivityMainBinding;
import com.example.sunhappy.databinding.ActivityNotificationBinding;
import com.example.sunhappy.functions.viewcart.ProductCartActivity;
import com.example.sunhappy.functions.viewproduct.ViewDetailProductActivity;
import com.example.sunhappy.models.Notification;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class NotificationActivity extends AppCompatActivity {

    ActivityNotificationBinding binding;
    NotificationAdapter adapter;
    ArrayList<Notification> notifications;
    String date;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_notification);
        binding = ActivityNotificationBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setLogo(R.drawable.logo_horizontal_color);
        actionBar.setDisplayUseLogoEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_baseline_arrow_back_24);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        loadData();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.cart_option_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId())
        {
            case android.R.id.home:
                onBackPressed();
                return true;
            default:break;

        }
        if (item.getItemId() == R.id.mn_Cart) {
            Intent intent = new Intent(NotificationActivity.this, ProductCartActivity.class);
            startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }

    private void loadData() { // tiếp bước 4
        notifications = new ArrayList<>();
        Date currentTime = Calendar.getInstance().getTime();
        String date = currentTime.toString();
        notifications.add(new Notification("Gửi bạn mã giảm giá", "Mã đã có sẵn trong kho voucher của bạn. Hy vọng món quà nhỏ này sẽ mang lại cho bạn một ngày tuyệt vời!", date));
        notifications.add(new Notification("Chào bạn!", "Cảm ơn bạn đã tin tưởng sử dụng SunHappy. SunHappy tặng bạn mã giảm giá 50K cho đơn đầu tiên. Chúc bạn lựa chọn được những trang phục đẹp nhất khiến bạn tự tin nhất!", date));
        adapter = new NotificationAdapter(NotificationActivity.this, R.layout.item_notification_list, notifications);
        binding.lvNotification.setAdapter(adapter);
    }
}