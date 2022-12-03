package com.example.sunhappy.functions.viewproduct;

import android.database.Cursor;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.sunhappy.R;
import com.example.sunhappy.adapters.ShirtAdapter;
import com.example.sunhappy.adapters.ShortAdapter;
import com.example.sunhappy.data.DatabaseHelper;
import com.example.sunhappy.databinding.FragmentShortBinding;
import com.example.sunhappy.models.Shirt;
import com.example.sunhappy.models.Short;

import java.util.ArrayList;


public class ShortFragment extends Fragment {

    FragmentShortBinding binding;
    ShortAdapter adapter;
    ArrayList<Short> shortArrayList;
    View view;
    DatabaseHelper db;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_short, container, false);

        binding = FragmentShortBinding.inflate(getLayoutInflater());
        view = binding.getRoot();

        createDB();
        loadData();
        return view;
    }

    private void loadData() {
        shortArrayList = new ArrayList<>();
        Cursor c = db.getData("SELECT * FROM " + DatabaseHelper.TBL_NAME_PRODUCT + " WHERE " + DatabaseHelper.COL_CATEGORY_PRODUCT + " ='Quần short'");
        while (c.moveToNext()) {
            shortArrayList.add(new Short(c.getInt(2), c.getString(1), c.getDouble(3)));
        }
        c.close();
        adapter = new ShortAdapter(this, R.layout.item_list_product, shortArrayList);
        binding.gvShort.setAdapter(adapter);
    }

    private void createDB() {
        db = new DatabaseHelper(getActivity());
        db.createData();
    }
}