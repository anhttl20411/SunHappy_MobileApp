package com.example.sunhappy.ui.user;

import static android.content.Context.SEARCH_SERVICE;
import static android.content.Context.WINDOW_SERVICE;

import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.example.sunhappy.MainActivity;
import com.example.sunhappy.R;
import com.example.sunhappy.adapters.FavoriteAdapter;
import com.example.sunhappy.adapters.TopProductAdapter;
import com.example.sunhappy.databinding.FragmentUserBinding;
import com.example.sunhappy.functions.setting.SettingActivity;
import com.example.sunhappy.functions.viewnotification.NotificationActivity;
import com.example.sunhappy.models.ProductFavorite;
import com.example.sunhappy.models.TopProduct;

import java.util.ArrayList;

public class UserFragment extends Fragment {
//    FavoriteAdapter adapter;
//    ArrayList<ProductFavorite> favoritelist;
//    View view;

    private UserViewModel mViewModel;

    public static UserFragment newInstance() {
        return new UserFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
//    binding = FragmentUserBinding.inflate(getLayoutInflater());
//    return view;
    View view = inflater.inflate(R.layout.fragment_user, container, false);

        ImageButton btnSettingAcount = (ImageButton) view.findViewById(R.id.btn_SettingAccount);


        btnSettingAcount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), SettingActivity.class);
                startActivity(intent);
            }
        });

    return  view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(UserViewModel.class);
        // TODO: Use the ViewModel
    }

//    private void loadDatauserfragment() {
//        favoritelist = new ArrayList<>();
//        favoritelist.add(new ProductFavorite(R.drawable.imv_white_polo, "Polo White Span", 190000.0));
//        favoritelist.add(new ProductFavorite(R.drawable.imv_white_polo, "Polo White Span", 190000.0));
//        favoritelist.add(new ProductFavorite(R.drawable.imv_white_polo, "Polo White Span", 190000.0));
//
//        adapter =  new FavoriteAdapter(this,R.layout.item_list_favorite,favoritelist);
//        binding.gvDanhsachyeuthich.setAdapter(adapter);
//
//    }

}