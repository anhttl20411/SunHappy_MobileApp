package com.example.sunhappy.ui.home;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.sunhappy.R;
import com.example.sunhappy.databinding.FragmentAboutSunhappyBinding;

public class HomeFragment extends Fragment {

    //Button btnTest;


    FragmentAboutSunhappyBinding binding;

    //private HomeViewModel mViewModel;

//    public static HomeFragment newInstance() {
//        return new HomeFragment();
//    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home, container, false);
        //binding = FragmentAboutSunhappyBinding.inflate(getLayoutInflater());
    }

//    @Override
//    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
//        super.onActivityCreated(savedInstanceState);
//        mViewModel = new ViewModelProvider(this).get(HomeViewModel.class);
//        // TODO: Use the ViewModel
//    }



}