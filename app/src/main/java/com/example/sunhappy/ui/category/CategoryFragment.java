package com.example.sunhappy.ui.category;

import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.sunhappy.R;
import com.example.sunhappy.adapters.CategoryAdapter;
import com.example.sunhappy.adapters.NotificationAdapter;
import com.example.sunhappy.adapters.PoloAdapter;
import com.example.sunhappy.databinding.ActivityNotificationBinding;
import com.example.sunhappy.databinding.FragmentPoloBinding;
import com.example.sunhappy.models.Notification;
import com.example.sunhappy.models.Polo;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class CategoryFragment extends Fragment {

    TabLayout tabLayout;
    ViewPager viewPager;
    View view;
    FragmentPoloBinding binding;
    PoloAdapter adapter;
    ArrayList<Polo> poloArrayList;



    //private CategoryViewModel mViewModel;

//    public static CategoryFragment newInstance() {
//        //return new CategoryFragment();
//    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_category, container, false);
        tabLayout = view.findViewById(R.id.tablayout_category);
        viewPager = view.findViewById(R.id.vpg_Category);

        CategoryAdapter categoryAdapter = new CategoryAdapter(getChildFragmentManager(), FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        tabLayout.setupWithViewPager(viewPager);
        viewPager.setAdapter(categoryAdapter);
        loadData();
        return view;
    }

    private void loadData() {
        poloArrayList = new ArrayList<>();
        poloArrayList.add(new Polo(R.drawable.img_product_polo1, "Áo polo nè", 10000));
        binding.gvPolo.setAdapter(adapter);
    }

//    @Override
//    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
//        super.onActivityCreated(savedInstanceState);
//        mViewModel = new ViewModelProvider(this).get(CategoryViewModel.class);
//        // TODO: Use the ViewModel
//    }



}