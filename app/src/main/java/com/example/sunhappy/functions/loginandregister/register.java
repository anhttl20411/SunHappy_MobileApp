package com.example.sunhappy.functions.loginandregister;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.slice.SliceItem;
import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.text.TextUtils;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.util.Patterns;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sunhappy.MainActivity;
import com.example.sunhappy.R;
import com.example.sunhappy.databinding.ActivityLoginBinding;
import com.example.sunhappy.databinding.ActivityRegisterBinding;
import com.google.android.material.button.MaterialButton;

public class register extends AppCompatActivity {
    ActivityRegisterBinding binding;
    EditText email, password;
    Button signup;
    boolean passwordShow;
    private SliceItem event;
    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_login);
        binding = ActivityRegisterBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        addEvents();
        //định dạng email
        email = findViewById(R.id.edt_Emaill);
        signup = findViewById(R.id.btn_Signup);
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String getEmailID = email.getText().toString();
                if (!isEmailValid(getEmailID)){
                    email.setError("Bạn cần nhập đúng định dạng email!");
                } else{
                    binding.btnSignup.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Intent intent = new Intent(register.this, MainActivity.class);
                            startActivity(intent);
                        }
                    });

                }
            }
        });
        //ẩn hiện mk
        password = findViewById(R.id.edt_Passwordd);
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
    boolean isEmailValid(CharSequence email){
        return Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }
//ấn vào đăng nhập ngay thì hiện màn hình đn
    private void addEvents() {
        binding.txtLoginNow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(register.this,login.class);
                startActivity(intent);
            }
        });
        ///chưa code điều kiện cho email và mật khẩu
        //chưa code toast thông báo
        //ấn đăng ký chưa dẫn tới màn hình trang chủ - done

    }


}