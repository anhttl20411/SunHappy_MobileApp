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
import android.widget.LinearLayout;
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
        LinearLayout lnAboutUs = (LinearLayout) view.findViewById(R.id.ln_AboutUs);

        TextView txtSecurity = (TextView) view.findViewById(R.id.txt_Security);
        LinearLayout lnSecurity = (LinearLayout) view.findViewById(R.id.ln_Security);

        TextView txtService = (TextView) view.findViewById(R.id.txt_Service);
        LinearLayout lnService = (LinearLayout) view.findViewById(R.id.ln_Service);

        lnAboutUs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if ((lnAboutUs.getTag() == null) || (lnAboutUs.getTag() == "collapse")) // để mặc định là collapse
                {
                    txtAboutUs.setVisibility(View.VISIBLE);
                    txtAboutUs.setHeight(300);
                    lnAboutUs.setTag("expand");
                    // settag dùng để đánh dấu

                }
                else
                {
                    txtAboutUs.setVisibility(View.INVISIBLE);
                    txtAboutUs.setHeight(0);
                    lnAboutUs.setTag("collapse");
                }
            }
        });

        lnSecurity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if ((lnSecurity.getTag() == null) || (lnSecurity.getTag() == "collapse")) // để mặc định là collapse
                {
                    txtSecurity.setVisibility(View.VISIBLE);
                    txtSecurity.setHeight(300);
                    lnSecurity.setTag("expand");
                    // settag dùng để đánh dấu

                }
                else
                {
                    txtSecurity.setVisibility(View.INVISIBLE);
                    txtSecurity.setHeight(0);
                    lnSecurity.setTag("collapse");
                }
            }
        });

        lnService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if ((lnService.getTag() == null) || (lnService.getTag() == "collapse")) // để mặc định là collapse
                {
                    txtService.setVisibility(View.VISIBLE);
                    txtService.setHeight(300);
                    lnService.setTag("expand");
                    // settag dùng để đánh dấu

                }
                else
                {
                    txtService.setVisibility(View.INVISIBLE);
                    txtService.setHeight(0);
                    lnService.setTag("collapse");
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