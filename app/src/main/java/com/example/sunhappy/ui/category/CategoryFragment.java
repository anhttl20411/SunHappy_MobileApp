package com.example.sunhappy.ui.category;

import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import android.app.Dialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.Toast;

import com.example.sunhappy.R;
import com.example.sunhappy.adapters.CategoryAdapter;
import com.example.sunhappy.functions.viewproduct.PoloFragment;
import com.google.android.material.tabs.TabLayout;

public class CategoryFragment extends Fragment {

    TabLayout tabLayout;
    ViewPager viewPager;
    View view;

    ImageButton btnSort;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_category, container, false);
        tabLayout = view.findViewById(R.id.tablayout_category);
        viewPager = view.findViewById(R.id.vpg_Category);

        CategoryAdapter categoryAdapter = new CategoryAdapter(getChildFragmentManager(), FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        tabLayout.setupWithViewPager(viewPager);
        viewPager.setAdapter(categoryAdapter);

        ImageButton btnSort = (ImageButton) view.findViewById(R.id.btn_Sort);
        btnSort.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Dialog dialog = new Dialog(getContext());
                dialog.setContentView(R.layout.dialog_sort_product);

                //tạo sự kiện cho dialog hiện ra

                //ánh xạ
                Button btnApply = dialog.findViewById(R.id.btn_Apply);
                RadioButton radDescending = dialog.findViewById(R.id.rad_Descending);
                RadioButton radAscending = dialog.findViewById(R.id.rad_Ascending);

                //xử lý
                btnApply.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (radDescending.isChecked()){
//                            FragmentManager fm = getFragmentManager();
//                            PoloFragment poloFr = (PoloFragment) fm.findFragmentById(R.id.polo_fragment);
//                            poloFr.sortDataDescending();
                            Toast.makeText(getContext(), "Sắp xếp giá giảm dần", Toast.LENGTH_SHORT).show();
                            dialog.dismiss();
                        }else{
                            Toast.makeText(getContext(), "Sắp xếp giá tăng dần", Toast.LENGTH_SHORT).show();
                            dialog.dismiss();
                        }


                    }
                });

                dialog.show();
            }
        });
        return view;
    }
}
