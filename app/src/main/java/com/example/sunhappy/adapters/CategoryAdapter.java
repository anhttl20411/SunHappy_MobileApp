package com.example.sunhappy.adapters;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.sunhappy.functions.viewproduct.PantFragment;
import com.example.sunhappy.functions.viewproduct.PoloFragment;
import com.example.sunhappy.functions.viewproduct.ShirtFragment;
import com.example.sunhappy.functions.viewproduct.ShortFragment;
import com.example.sunhappy.functions.viewproduct.TshirtFragment;

public class CategoryAdapter extends FragmentStatePagerAdapter {


    public CategoryAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        //return null;
        switch (position){
            case 0: return new PoloFragment();
            case 1: return new TshirtFragment();
            case 2: return new ShirtFragment();
            case 3: return new ShortFragment();
            case 4: return new PantFragment();
            default: return new PoloFragment();
        }
    }

    @Override
    public int getCount() {
        //return 0;
        return 5;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        //return super.getPageTitle(position);
        switch (position){
            case 0: return "Áo polo";
            case 1: return "Áo thun";
            case 2: return "Áo sơ mi";
            case 3: return "Quần short";
            case 4: return "Quần dài";
            default: return "Áo polo";
        }
    }
}
