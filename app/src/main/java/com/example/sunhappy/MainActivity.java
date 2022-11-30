package com.example.sunhappy;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.sunhappy.databinding.ActivityMainBinding;
import com.example.sunhappy.databinding.ActivityViewDetailProductBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

//        ActionBar actionBar = getSupportActionBar();
//        actionBar.setDisplayShowHomeEnabled(true);
//        actionBar.setLogo(R.drawable.logo_horizontal_color);    //Icon muốn hiện thị
//        actionBar.setDisplayUseLogoEnabled(true);

        //điều hưỡng bottom menu
        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_aboutsunhappy,
                R.id.navigation_home,
                R.id.navigation_category,
                R.id.navigation_user)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_main);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(binding.navView, navController);


        //custom thanh action bar có 2 menu 2 bên và logo ở giữa
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowHomeEnabled(false);
        actionBar.setDisplayShowTitleEnabled(false);
        LayoutInflater li = LayoutInflater.from(this);
        View customView = li.inflate(R.layout.menu_notification_cart, null);
        actionBar.setCustomView(customView);
        actionBar.setDisplayShowCustomEnabled(true);
        ImageButton addContent = (ImageButton)    customView.findViewById(R.id.mn_Notification);
        addContent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // mở thông báo
                Toast.makeText(MainActivity.this, "Code mở màn hình thông báo!", Toast.LENGTH_SHORT).show();
            }
        });

        ImageButton search = (ImageButton) customView.findViewById(R.id.mn_Cart);
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // mở giỏ hàng
                Toast.makeText(MainActivity.this, "Code mở màn hình giỏ hàng!", Toast.LENGTH_SHORT).show();
            }
        });

    }
}