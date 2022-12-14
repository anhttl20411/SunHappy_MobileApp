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

    private void loadData() { // ti???p b?????c 4
        notifications = new ArrayList<>();
        Date currentTime = Calendar.getInstance().getTime();
        String date = currentTime.toString();
        notifications.add(new Notification("G???i b???n m?? gi???m gi??", "M?? ???? c?? s???n trong kho voucher c???a b???n. Hy v???ng m??n qu?? nh??? n??y s??? mang l???i cho b???n m???t ng??y tuy???t v???i!", date));
        notifications.add(new Notification("Ch??o b???n!", "C???m ??n b???n ???? tin t?????ng s??? d???ng SunHappy. SunHappy t???ng b???n m?? gi???m gi?? 50K cho ????n ?????u ti??n. Ch??c b???n l???a ch???n ???????c nh???ng trang ph???c ?????p nh???t khi???n b???n t??? tin nh???t!", date));
        adapter = new NotificationAdapter(NotificationActivity.this, R.layout.item_notification_list, notifications);
        binding.lvNotification.setAdapter(adapter);
    }
}