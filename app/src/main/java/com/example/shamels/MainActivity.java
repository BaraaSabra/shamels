package com.example.shamels;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.SharedPreferences;
import android.os.Bundle;

import com.example.shamels.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    ArrayList<Dataclass>arrayList;
    Adapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());








        arrayList=new ArrayList<>();
        adapter=new Adapter(arrayList,MainActivity.this);

        binding.RecyclerView.setAdapter(adapter);
        binding.RecyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this,
                RecyclerView.VERTICAL,false));




    }
}