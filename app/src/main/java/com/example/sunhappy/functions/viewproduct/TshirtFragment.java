package com.example.sunhappy.functions.viewproduct;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

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

    Tshirt selectedTshirt = null;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_tshirt, container, false);
        binding = FragmentTshirtBinding.inflate(getLayoutInflater());
        view = binding.getRoot();

        createDB();
        loadData();
        addEvents();
        return view;
    }

    private void addEvents() {
        binding.gvTshirt.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getActivity(), ViewDetailProductActivity.class);
                selectedTshirt = tshirtArrayList.get(i);
                //Attach data
//                intent.putExtra("image", R.drawable.img_product_polo1);
//                intent.putExtra("name", "Sản phẩm SunHappy");
//                intent.putExtra("price", 200000);
//                startActivity(intent);


                intent.putExtra("image", selectedTshirt.getTshirtImage());
                intent.putExtra("name", selectedTshirt.getTshirtName());
                intent.putExtra("price", selectedTshirt.getTshirtPrice());
                startActivity(intent);
            }
        });
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