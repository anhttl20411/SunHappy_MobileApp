package com.example.sunhappy.functions.payments;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.example.sunhappy.R;
import com.example.sunhappy.adapters.AddressAdapter;
import com.example.sunhappy.models.Address;

import java.util.ArrayList;

public class UpdateAddress extends AppCompatActivity {


    ArrayList<Address> list;
    ListView listView;
    AddressAdapter addressAdapter;

    String Ten[] = {"Thịnh","Vương"};
    Integer SDT[] = {032234442,23848232};
    String Tinh[] = {"Tỉnh 1", " Tỉnh 2"};
    String Huyen[] = {"Huyện 1", " Huyện 2"};
    String Xa[] = {"Xã 1", " Xã 2"};
    String Duong[] = {"Đường 1", " Đường 2"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_address);

        list = new ArrayList<>();

        for( int i = 0;i < Ten.length;i++)
        {
//

            list.add(new Address(Ten[i],SDT[i],Tinh[i],Huyen[i],Xa[i],Duong[i] ));
//
        }
        addressAdapter = new AddressAdapter(UpdateAddress.this, R.layout.list_address_item,list);
        listView.setAdapter(addressAdapter);




    }
}