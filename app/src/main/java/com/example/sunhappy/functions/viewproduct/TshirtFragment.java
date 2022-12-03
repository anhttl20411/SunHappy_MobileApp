package com.example.sunhappy.functions.viewproduct;

import android.database.Cursor;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.sunhappy.R;
import com.example.sunhappy.adapters.TshirtAdapter;
import com.example.sunhappy.data.DatabaseHelper;
import com.example.sunhappy.databinding.FragmentTshirtBinding;
import com.example.sunhappy.models.Tshirt;

import java.util.ArrayList;

public class TshirtFragment extends Fragment {

    FragmentTshirtBinding binding;
    TshirtAdapter adapter;
    ArrayList<Tshirt> tshirtArrayList;
    View view;
    DatabaseHelper db;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_tshirt, container, false);
        binding = FragmentTshirtBinding.inflate(getLayoutInflater());
        view = binding.getRoot();

        createDB();
        loadData();
        return view;
    }

    private void loadData() {
        tshirtArrayList = new ArrayList<>();
        Cursor c = db.getData("SELECT * FROM " + DatabaseHelper.TBL_NAME_PRODUCT + " WHERE " + DatabaseHelper.COL_CATEGORY_PRODUCT + " ='Áo thun'");
        while (c.moveToNext()) {
            tshirtArrayList.add(new Tshirt(c.getInt(2), c.getString(1), c.getDouble(3)));
        }
        c.close();
        adapter = new TshirtAdapter(this, R.layout.item_list_product, tshirtArrayList);
        binding.gvTshirt.setAdapter(adapter);
    }

    private void createDB() {
        db = new DatabaseHelper(getActivity());
        db.createData();
    }
}