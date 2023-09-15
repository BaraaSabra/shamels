package com.example.shamels;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.SharedPreferences;
import android.os.Bundle;

import com.example.shamels.databinding.ActivityMainBinding;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    ArrayList<Dataclass>arrayList;
    Adapter adapter;
    ApiService retrofitInstance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());



        retrofitInstance=ApiService.Retrofice.RetroficeInestans();
        retrofitInstance.getAll().enqueue(new Callback<Respons>() {
            @Override
            public void onResponse(Call<Respons> call, Response<Respons> response) {
                Respons respons=response.body();
                ArrayList<Respons.UserData> userDataArrayList=respons.getUserDataArrayList();
//                Adapter usersAdapter2 = new Adapter(getApplicationContext(),userDataArrayList,null);
                binding.RecyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(), RecyclerView.VERTICAL,false));
//                binding.RecyclerView.setAdapter(usersAdapter2);
            }

            @Override
            public void onFailure(Call<Respons> call, Throwable t) {
                t.getStackTrace();

            }
        });




        arrayList=new ArrayList<>();
        adapter=new Adapter(arrayList,MainActivity.this);

        binding.RecyclerView.setAdapter(adapter);
        binding.RecyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this,
                RecyclerView.VERTICAL,false));




    }
}