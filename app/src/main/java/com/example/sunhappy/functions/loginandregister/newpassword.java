package com.example.sunhappy.functions.loginandregister;

import androidx.appcompat.app.AppCompatActivity;

import android.app.slice.SliceItem;
import android.content.Intent;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.sunhappy.R;
import com.example.sunhappy.adapters.TopProductAdapter;
import com.example.sunhappy.databinding.ActivityNewpasswordBinding;
import com.example.sunhappy.databinding.ActivityOtpBinding;

public class newpassword extends AppCompatActivity {
    ActivityNewpasswordBinding binding;
    EditText passwordnew, password;
    boolean passwordShow;
    private SliceItem event;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newpassword);
        binding = ActivityNewpasswordBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        addEvents();
        //ẩn hiện mk
        passwordnew= findViewById(R.id.edt_ResetPass);
        password=findViewById(R.id.edt_ConfirmPass);



        password.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                final int Right=2;
                if(event.getAction()==MotionEvent.ACTION_UP){
                    if (event.getRawX()>=password.getRight()-password.getCompoundDrawables()[Right].getBounds().width()){
                        int selection=password.getSelectionEnd();
                        if(passwordShow){
                            //set drawable img here
                            password.setCompoundDrawablesRelativeWithIntrinsicBounds(0,0, R.drawable.showpass, 0);
                            //for hide pass
                            password.setTransformationMethod(PasswordTransformationMethod.getInstance());
                            passwordShow=false;
                        }else {
                            //set drawable img here
                            password.setCompoundDrawablesRelativeWithIntrinsicBounds(0,0, R.drawable.hidepass, 0);
                            //for show pass
                            password.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                            passwordShow=true;

                        }
                        password.setSelection(selection);
                        return true;


                    }
                }
                return false;
            }
        });
        passwordnew.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                final int Right=2;
                if(event.getAction()==MotionEvent.ACTION_UP){
                    if (event.getRawX()>=passwordnew.getRight()-passwordnew.getCompoundDrawables()[Right].getBounds().width()){
                        int selection=passwordnew.getSelectionEnd();
                        if(passwordShow){
                            //set drawable img here
                            passwordnew.setCompoundDrawablesRelativeWithIntrinsicBounds(0,0, R.drawable.showpass, 0);
                            //for hide pass
                            passwordnew.setTransformationMethod(PasswordTransformationMethod.getInstance());
                            passwordShow=false;
                        }else {
                            //set drawable img here
                            passwordnew.setCompoundDrawablesRelativeWithIntrinsicBounds(0,0, R.drawable.hidepass, 0);
                            //for show pass
                            passwordnew.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                            passwordShow=true;

                        }
                        passwordnew.setSelection(selection);
                        return true;


                    }
                }
                return false;
            }
        });
    }
    private void addEvents() {
        //ẩn hiện mật khẩu chưa làm
        //định dạng mk là số
        //ấn vào k nhận đc mã thì dẫn đến màn hình hướng dẫn
        binding.txtResetPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(newpassword.this, login.class);
                startActivity(intent);
            }
        });
        binding.btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(newpassword.this, "Cập nhật thành công!\n Vui lòng đăng nhập lại!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(newpassword.this, login.class);
                startActivity(intent);
            }
        });
    }
}