package com.example.sunhappy.ui.aboutsunhappy;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sunhappy.MainActivity;
import com.example.sunhappy.R;

public class AboutSunhappyFragment extends Fragment {

    private AboutSunhappyViewModel mViewModel;

    public static AboutSunhappyFragment newInstance() {
        return new AboutSunhappyFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_about_sunhappy, container, false);

        TextView txtAboutUs = (TextView) view.findViewById(R.id.txt_AboutUs);
        ImageButton btnShowMoreAboutUs = (ImageButton) view.findViewById(R.id.btn_ShowMoreAboutUs);

        TextView txtSecurity = (TextView) view.findViewById(R.id.txt_Security);
        ImageButton btnShowMoreSecurity = (ImageButton) view.findViewById(R.id.btn_ShowMoreSecurity);

        TextView txtService = (TextView) view.findViewById(R.id.txt_Service);
        ImageButton btnShowMoreService = (ImageButton) view.findViewById(R.id.btn_ShowMoreService);

        //chỉ mới code để mở ra, chưa code để đóng lại
        btnShowMoreAboutUs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtAboutUs.setVisibility(View.VISIBLE);
            }
        });

        btnShowMoreSecurity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtSecurity.setVisibility(View.VISIBLE);
            }
        });

        btnShowMoreService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtService.setVisibility(View.VISIBLE);
            }
        });

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(AboutSunhappyViewModel.class);
        // TODO: Use the ViewModel
    }

}