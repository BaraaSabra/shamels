package com.example.shamels;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;

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
    private static final int JOB_ID = 123;


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


    private void scheduleJob() {
        JobScheduler jobScheduler = (JobScheduler) getSystemService(Context.JOB_SCHEDULER_SERVICE);
        ComponentName componentName = new ComponentName(this, YourJobService.class);

        JobInfo jobInfo = new JobInfo.Builder(JOB_ID, componentName)
                .setPeriodic(5000)  // Job will be run every 5 seconds
                .build();

        int resultCode = jobScheduler.schedule(jobInfo);
        if (resultCode == JobScheduler.RESULT_SUCCESS) {
            Log.i("MainActivity", "Job scheduled successfully!");
        } else {
            Log.e("MainActivity", "Job scheduling failed");
        }
    }
}








