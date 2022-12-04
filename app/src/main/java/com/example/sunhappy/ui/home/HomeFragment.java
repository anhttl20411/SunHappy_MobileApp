package com.example.sunhappy.ui.home;

import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import com.example.sunhappy.MainActivity;
import com.example.sunhappy.R;
import com.example.sunhappy.adapters.SliderAdapter;
import com.example.sunhappy.adapters.TopProductAdapter;
import com.example.sunhappy.data.DatabaseHelper;
import com.example.sunhappy.databinding.FragmentHomeBinding;
import com.example.sunhappy.functions.viewproduct.ViewDetailProductActivity;
import com.example.sunhappy.models.TopProduct;
import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    private SliderView sliderView;
    int [] images = {
            R.drawable.img_sunhappy_banner_1,
            R.drawable.img_sunhappy_banner_2
    };

    FragmentHomeBinding binding;
    TopProductAdapter adapter;
    ArrayList<TopProduct> topProductArrayList;
    View view;
    TopProduct selectedTop;
    DatabaseHelper db;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = FragmentHomeBinding.inflate(getLayoutInflater());
        view = binding.getRoot();

        SliderView sliderView = (SliderView) view.findViewById(R.id.slv_banner);
        SliderAdapter sliderAdapter = new SliderAdapter(images);
        sliderView.setSliderAdapter(sliderAdapter);
        sliderView.setIndicatorAnimation(IndicatorAnimationType.WORM);
        sliderView.setSliderTransformAnimation(SliderAnimations.DEPTHTRANSFORMATION);
        sliderView.startAutoCycle();

        createDB();
        loadData();
        addEvents();
        return view;
    }

    private void addEvents() {
        binding.gvTopProduct.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getActivity(), ViewDetailProductActivity.class);
                selectedTop = topProductArrayList.get(i);
                //Attach data
//                intent.putExtra("image", R.drawable.img_product_polo1);
//                intent.putExtra("name", "Sản phẩm SunHappy");
//                intent.putExtra("price", 200000);
//                startActivity(intent);


                intent.putExtra("image", selectedTop.getTopProductImage());
                intent.putExtra("name", selectedTop.getTopProductName());
                intent.putExtra("price", selectedTop.getTopProductPrice());
                startActivity(intent);
            }
        });
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



