package com.example.sunhappy.functions.viewproduct;

import android.database.Cursor;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.sunhappy.R;
import com.example.sunhappy.adapters.PantAdapter;
import com.example.sunhappy.adapters.PoloAdapter;
import com.example.sunhappy.data.DatabaseHelper;
import com.example.sunhappy.databinding.FragmentPantBinding;
import com.example.sunhappy.models.Pant;
import com.example.sunhappy.models.Polo;

import java.util.ArrayList;

public class PantFragment extends Fragment {

    FragmentPantBinding binding;
    PantAdapter adapter;
    ArrayList<Pant> pantArrayList;
    View view;
    DatabaseHelper db;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_pant, container, false);
        binding = FragmentPantBinding.inflate(getLayoutInflater());
        view = binding.getRoot();

        createDB();
        loadData();
        return view;
    }

    private void loadData() {
        pantArrayList = new ArrayList<>();
        Cursor c = db.getData("SELECT * FROM " + DatabaseHelper.TBL_NAME_PRODUCT + " WHERE " + DatabaseHelper.COL_CATEGORY_PRODUCT + " ='Quần dài'");
        while (c.moveToNext()) {
            pantArrayList.add(new Pant(c.getInt(2), c.getString(1), c.getDouble(3)));
        }
        c.close();
        adapter = new PantAdapter(this, R.layout.item_list_product, pantArrayList);
        binding.gvPant.setAdapter(adapter);
    }

    private void createDB() {
        db = new DatabaseHelper(getActivity());
        db.createData();
    }
}