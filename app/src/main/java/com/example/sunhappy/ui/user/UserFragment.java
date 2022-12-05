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
import android.widget.LinearLayout;

import com.example.sunhappy.MainActivity;
import com.example.sunhappy.R;
import com.example.sunhappy.adapters.FavoriteAdapter;
import com.example.sunhappy.adapters.TopProductAdapter;
import com.example.sunhappy.databinding.FragmentUserBinding;
import com.example.sunhappy.functions.manageorder.ViewOderCancelledActivity;
import com.example.sunhappy.functions.manageorder.ViewOderDeliveredActivity;
import com.example.sunhappy.functions.manageorder.ViewOderDeliveringActivity;
import com.example.sunhappy.functions.manageorder.ViewOderPreparingActivity;
import com.example.sunhappy.functions.setting.SettingActivity;
import com.example.sunhappy.functions.viewnotification.NotificationActivity;
import com.example.sunhappy.models.ProductFavorite;
import com.example.sunhappy.models.TopProduct;

import java.util.ArrayList;

public class UserFragment extends Fragment {
    FragmentUserBinding binding;
    FavoriteAdapter adapter;
    ArrayList<ProductFavorite> favoritelist;
    View view;

    private UserViewModel mViewModel;

    public static UserFragment newInstance() {
        return new UserFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
    binding = FragmentUserBinding.inflate(getLayoutInflater());
    view = binding.getRoot();

    //View view = inflater.inflate(R.layout.fragment_user, container, false);
    loadDatauserfragment();
    addEvents();

    return  view;
    }

    private void addEvents() {
        ImageButton btnSettingAcount = (ImageButton) view.findViewById(R.id.btn_SettingAccount);
        btnSettingAcount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), SettingActivity.class);
                startActivity(intent);
            }
        });
       // LinearLayout lnPreparing = (LinearLayout) view.findViewById(R.id.ln_Preparing) ;
        binding.lnPreparing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), ViewOderPreparingActivity.class);
                startActivity(intent);
            }
        });
        binding.lnDelivering.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), ViewOderDeliveringActivity.class);
                startActivity(intent);
            }
        });
        binding.lnDelivered.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), ViewOderDeliveredActivity.class);
                startActivity(intent);
            }
        });
        binding.lnCancelled.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), ViewOderCancelledActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(UserViewModel.class);
        // TODO: Use the ViewModel
    }

    private void loadDatauserfragment() {
        favoritelist = new ArrayList<>();
        favoritelist.add(new ProductFavorite(R.drawable.img_dai_4, "Polo White Span", 190000.0));
        favoritelist.add(new ProductFavorite(R.drawable.img_polo_8, "Polo White Span", 190000.0));
        favoritelist.add(new ProductFavorite(R.drawable.img_short_3, "Polo White Span", 190000.0));
        favoritelist.add(new ProductFavorite(R.drawable.imv_white_polo, "Polo White Span", 190000.0));
        favoritelist.add(new ProductFavorite(R.drawable.img_polo_3, "Polo White Span", 190000.0));
        favoritelist.add(new ProductFavorite(R.drawable.img_thun_2, "Polo White Span", 190000.0));

        adapter =  new FavoriteAdapter(this,R.layout.item_list_favorite,favoritelist);
        binding.gvDanhsachyeuthich.setAdapter(adapter);

    }

}