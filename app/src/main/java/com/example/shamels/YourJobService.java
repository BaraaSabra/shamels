package com.example.shamels;

import android.app.job.JobInfo;
import android.app.job.JobParameters;
import android.app.job.JobScheduler;
import android.app.job.JobService;
import android.content.ComponentName;
import android.content.Context;
import android.util.Log;

import java.util.Timer;
import java.util.TimerTask;

public class YourJobService extends JobService {
    private static final String TAG = "TimerJobService";
    private Timer timer;

    @Override
    public boolean onStartJob(JobParameters params) {
        Log.i(TAG, "Job started");

        // Create a TimerTask to perform the background work
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                // Perform your background work here
                Log.i(TAG, "Background work is being done");
            }
        };

        // Schedule the TimerTask to run every 5 seconds
        timer = new Timer();
        timer.schedule(task, 0, 5000);

        // Job is ongoing until explicitly stopped
        return true;
    }

    @Override
    public boolean onStopJob(JobParameters params) {
        Log.i(TAG, "Job stopped");
        // Stop the ongoing job
        if (timer != null) {
            timer.cancel();
        }
        return false;
    }
}

