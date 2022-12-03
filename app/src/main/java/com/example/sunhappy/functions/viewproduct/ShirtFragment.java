package com.example.sunhappy.functions.viewproduct;

import android.database.Cursor;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.sunhappy.R;
import com.example.sunhappy.adapters.ShirtAdapter;
import com.example.sunhappy.data.DatabaseHelper;
import com.example.sunhappy.databinding.FragmentShirtBinding;
import com.example.sunhappy.models.Shirt;

import java.util.ArrayList;


public class ShirtFragment extends Fragment {

    FragmentShirtBinding binding;
    ShirtAdapter adapter;
    ArrayList<Shirt> shirtArrayList;
    View view;
    DatabaseHelper db;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_shirt, container, false);
        binding = FragmentShirtBinding.inflate(getLayoutInflater());
        view = binding.getRoot();

        createDB();
        loadData();
        return view;
    }

    private void loadData() {
        shirtArrayList = new ArrayList<>();
        Cursor c = db.getData("SELECT * FROM " + DatabaseHelper.TBL_NAME_PRODUCT + " WHERE " + DatabaseHelper.COL_CATEGORY_PRODUCT + " ='Áo sơ mi'");
        while (c.moveToNext()) {
            shirtArrayList.add(new Shirt(c.getInt(2), c.getString(1), c.getDouble(3)));
        }
        c.close();
        adapter = new ShirtAdapter(this, R.layout.item_list_product, shirtArrayList);
        binding.gvShirt.setAdapter(adapter);
    }

    private void createDB() {
        db = new DatabaseHelper(getActivity());
        db.createData();
    }
}