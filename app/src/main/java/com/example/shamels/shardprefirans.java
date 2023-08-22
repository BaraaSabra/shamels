package com.example.shamels;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;

import com.example.shamels.databinding.ActivityShardprefiransBinding;

public class shardprefirans extends AppCompatActivity {
    ActivityShardprefiransBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityShardprefiransBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        SharedPreferences sp= getSharedPreferences("register",MODE_PRIVATE) ;//الملف الافتراضي للمشروع باكمله
        SharedPreferences.Editor edit=sp.edit();//موشر ع كلاس التعديل الخاص بالملف ه
        String Fullname = binding.name.getText().toString();
        String age = binding.ages.getText().toString();
//        String username = binding.etLoginUsername.getText().toString();
//        String password = binding.etLoginPassword.getText().toString();
//        String repassword = binding.etLoginRePassword.getText().toString();
//        String bithedate = binding.etLoginBirthdate.getText().toString();
//        String spiner = binding.spinner.getSelectedItem().toString();



        edit.putString("name",Fullname);
        edit.putString("emali",age);
//        edit.putString("birthdate",bithedate);
//        edit.putString("username",username);
//        edit.putString("password",password);
//        edit.putString("repassword",repassword);
//        edit.putString("country",spiner);
//        edit.apply();

    }
////هان لما اعمل git في الشيرد
    SharedPreferences sp= getSharedPreferences("register",MODE_PRIVATE) ;//الملف الافتراضي للمشروع باكمله
    SharedPreferences.Editor edit=sp.edit();
    String username = sp.getString("username", "");
    String password = sp.getString("password", "");

//    String usernamea = binding.etLoginUsername.getText().toString();
//    String passworde = binding.etLoginPassword.getText().toString();
}