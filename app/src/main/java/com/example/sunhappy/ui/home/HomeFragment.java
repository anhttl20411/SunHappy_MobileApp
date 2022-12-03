package com.example.sunhappy.ui.home;

import androidx.lifecycle.ViewModelProvider;

import android.database.Cursor;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.sunhappy.MainActivity;
import com.example.sunhappy.R;
import com.example.sunhappy.adapters.TopProductAdapter;
import com.example.sunhappy.data.DatabaseHelper;
import com.example.sunhappy.databinding.FragmentHomeBinding;
import com.example.sunhappy.models.TopProduct;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    FragmentHomeBinding binding;
    TopProductAdapter adapter;
    ArrayList<TopProduct> topProductArrayList;
    View view;
    DatabaseHelper db;

    //private HomeViewModel mViewModel;

//    public static HomeFragment newInstance() {
//        return new HomeFragment();
//    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = FragmentHomeBinding.inflate(getLayoutInflater());
        view = binding.getRoot();

//        topProductArrayList = new ArrayList<>();
//        topProductArrayList.add(new TopProduct(R.drawable.img_product_redpolo, "Áo top polo 1", 250000));
//        topProductArrayList.add(new TopProduct(R.drawable.img_product_redpolo, "Áo top polo 1", 280000));
//        topProductArrayList.add(new TopProduct(R.drawable.img_product_redpolo, "Áo top polo 1", 150000));
//        adapter = new TopProductAdapter(this, R.layout.item_list_product, topProductArrayList);
//        binding.gvTopProduct.setAdapter(adapter);

        createDB();
        loadData();
        return view;
    }

    // COL_ID_PRODUCT + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
    // COL_NAME_PRODUCT + " VARCHAR(50), " +
    // COL_IMAGE_PRODUCT + " INTEGER, " +
    // COL_PRICE_PRODUCT + " REAL," +
    // COL_CATEGORY_PRODUCT + " VARCHAR(50))
    private void loadData() { // tiếp bước 4
        topProductArrayList = new ArrayList<>();
        Cursor c = db.getData("SELECT * FROM " + DatabaseHelper.TBL_NAME_PRODUCT);
        while (c.moveToNext()) {
            topProductArrayList.add(new TopProduct(c.getInt(2), c.getString(1), c.getDouble(3)));
        }
        c.close();
        adapter = new TopProductAdapter(this, R.layout.item_list_product, topProductArrayList);
        binding.gvTopProduct.setAdapter(adapter);
    }

    private void createDB() {
        db = new DatabaseHelper(getActivity());
        db.createData();
    }
}


//    @Override
//    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
//        super.onActivityCreated(savedInstanceState);
//        mViewModel = new ViewModelProvider(this).get(HomeViewModel.class);
//        // TODO: Use the ViewModel
//    }



