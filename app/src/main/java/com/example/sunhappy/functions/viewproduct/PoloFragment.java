package com.example.sunhappy.functions.viewproduct;

import android.database.Cursor;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.sunhappy.R;
import com.example.sunhappy.adapters.PoloAdapter;
import com.example.sunhappy.adapters.TopProductAdapter;
import com.example.sunhappy.data.DatabaseHelper;
import com.example.sunhappy.databinding.FragmentHomeBinding;
import com.example.sunhappy.databinding.FragmentPoloBinding;
import com.example.sunhappy.models.Polo;
import com.example.sunhappy.models.TopProduct;

import java.util.ArrayList;


public class PoloFragment extends Fragment {

    FragmentPoloBinding binding;
    PoloAdapter adapter;
    ArrayList<Polo> poloArrayList;
    View view;
    DatabaseHelper db;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //View view = inflater.inflate(R.layout.fragment_polo, container, false);

        //return view;
        binding = FragmentPoloBinding.inflate(getLayoutInflater());
        view = binding.getRoot();

        createDB();
        loadData();
        return view;

    }

    private void loadData() {
        poloArrayList = new ArrayList<>();
        Cursor c = db.getData("SELECT * FROM " + DatabaseHelper.TBL_NAME_PRODUCT + " WHERE " + DatabaseHelper.COL_CATEGORY_PRODUCT + " ='Áo polo'");
        while (c.moveToNext()) {
            poloArrayList.add(new Polo(c.getInt(2), c.getString(1), c.getDouble(3)));
        }
        c.close();
        adapter = new PoloAdapter(this, R.layout.item_list_product, poloArrayList);
        binding.gvPolo.setAdapter(adapter);

    }

    private void createDB() {
        db = new DatabaseHelper(getActivity());
        db.createData();
    }
}