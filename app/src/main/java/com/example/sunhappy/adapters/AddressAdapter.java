package com.example.sunhappy.adapters;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.sunhappy.R;
import com.example.sunhappy.models.Address;

import java.util.ArrayList;

public class AddressAdapter extends ArrayAdapter<Address> {

    Activity context;
    int layout;
    ArrayList<Address> list;

    public AddressAdapter(Activity context, int layout, ArrayList<Address> list) {
        super(context, layout,list);
        this.context = context;
        this.layout = layout;
        this.list = list;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {


        LayoutInflater layoutInflater = context.getLayoutInflater();
        convertView = layoutInflater.inflate(layout,null);

        Address address =list.get(position);

        Button buttonsua = convertView.findViewById(R.id.btn_AddressUpdate);
        CheckBox chkadd = convertView.findViewById(R.id.chk_Address);
        TextView txt1 = convertView.findViewById(R.id.txt_AddressLine1);
        TextView txt2 = convertView.findViewById(R.id.txt_AddressLine2);
        txt1.setText(address.getTen() + " | " + address.getSDT());
        txt2.setText(address.getDuong() +"," + address.getXa()+"," +address.getHuyen() +"," +address.getTinh());

        buttonsua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context,"Sửa", Toast.LENGTH_LONG).show();
            }
        });







        return convertView;
    }
}
