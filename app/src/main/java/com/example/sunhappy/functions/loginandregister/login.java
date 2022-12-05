package com.example.sunhappy.functions.loginandregister;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.slice.SliceItem;
import android.content.Intent;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.util.Patterns;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.sunhappy.MainActivity;
import com.example.sunhappy.R;
import com.example.sunhappy.databinding.ActivityLoginBinding;


public class login extends AppCompatActivity {
 //ActivityLoginBinding binding;
  //  ActivityLoginBinding binding;
    ActivityLoginBinding binding;
   //ẩn hiện mk
    EditText email, password;
    boolean passwordShow;
    private SliceItem event;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        addEvents();
        //ẩn hiện mk
        email=findViewById(R.id.edt_Email);
        password=findViewById(R.id.edt_Password);
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
    }
    //ấn vào đk ngay hiện ra màn hình đăng ký
    private void addEvents() {
        binding.txtSignUpNow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(login.this, register.class);
                startActivity(intent);
            }
        });
        //ấn vào quên mật khẩu thì hiện màn hình quên mk

        binding.txtForgotpass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(login.this, forgotpass.class);
                startActivity(intent);
            }
        });
        binding.btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(login.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
    private  boolean validateEmailAddress (EditText email){
        String emailInput = email.getText().toString();
        if (!emailInput.isEmpty()&& !Patterns.EMAIL_ADDRESS.matcher(emailInput).matches()) {
            return  true;

        }else {
            Toast.makeText(this, "Email không đúng định dạng", Toast.LENGTH_SHORT).show();
            return  false;
        }
    }
    ///chưa code điều kiện cho email và mật khẩu
    //chưa code toast thông báo đăng nhập thành công?? cái này có cần không?
    //ấn đăng nhập chưa dẫn tới màn hình trang chủ
}