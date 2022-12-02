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
import com.google.android.material.tabs.TabLayout;

public class CategoryFragment extends Fragment {

    TabLayout tabLayout;
    ViewPager viewPager;
    View view;



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
        return view;
    }

//    @Override
//    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
//        super.onActivityCreated(savedInstanceState);
//        mViewModel = new ViewModelProvider(this).get(CategoryViewModel.class);
//        // TODO: Use the ViewModel
//    }



}