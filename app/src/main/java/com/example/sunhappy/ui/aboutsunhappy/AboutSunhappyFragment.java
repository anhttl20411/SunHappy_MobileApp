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
import com.example.sunhappy.functions.viewproduct.ViewDetailProductActivity;

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

        btnShowMoreAboutUs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if ((btnShowMoreAboutUs.getTag() == null) || (btnShowMoreAboutUs.getTag() == "collapse")) // để mặc định là collapse
                {
                    txtAboutUs.setVisibility(View.VISIBLE);
                    txtAboutUs.setHeight(200);
                    btnShowMoreAboutUs.setTag("expand");
                    // settag dùng để đánh dấu

                }
                else
                {
                    txtAboutUs.setVisibility(View.INVISIBLE);
                    txtAboutUs.setHeight(0);
                    btnShowMoreAboutUs.setTag("collapse");
                }
            }
        });

        btnShowMoreSecurity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if ((btnShowMoreSecurity.getTag() == null) || (btnShowMoreSecurity.getTag() == "collapse")) // để mặc định là collapse
                {
                    txtSecurity.setVisibility(View.VISIBLE);
                    txtSecurity.setHeight(200);
                    btnShowMoreSecurity.setTag("expand");
                    // settag dùng để đánh dấu

                }
                else
                {
                    txtSecurity.setVisibility(View.INVISIBLE);
                    txtSecurity.setHeight(0);
                    btnShowMoreSecurity.setTag("collapse");
                }
            }
        });

        btnShowMoreService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if ((btnShowMoreService.getTag() == null) || (btnShowMoreService.getTag() == "collapse")) // để mặc định là collapse
                {
                    txtService.setVisibility(View.VISIBLE);
                    txtService.setHeight(200);
                    btnShowMoreService.setTag("expand");
                    // settag dùng để đánh dấu

                }
                else
                {
                    txtService.setVisibility(View.INVISIBLE);
                    txtService.setHeight(0);
                    btnShowMoreService.setTag("collapse");
                }
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