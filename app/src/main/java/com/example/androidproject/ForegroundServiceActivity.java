package com.example.androidproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.view.View;

public class ForegroundServiceActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_foreground_service);
    }
    public void start(View v) {
        if (isMyServiceRunning(MyService.class)) return;
        Intent startIntent = new Intent(this, MyService.class);
        startIntent.setAction("start");
        startService(startIntent);
    }

    public void stop(View v) {
        if (!isMyServiceRunning(MyService.class)) return;
        Intent stopIntent = new Intent(this, MyService.class);
        stopIntent.setAction("stop");
        startService(stopIntent);
    }

    // проверка, запущен ли сервис
    private boolean isMyServiceRunning(Class<?> serviceClass) {
        ActivityManager manager = (ActivityManager) getSystemService(Context.ACTIVITY_SERVICE);
        for (ActivityManager.RunningServiceInfo service : manager.getRunningServices(Integer.MAX_VALUE)) {
            if (serviceClass.getName().equals(service.service.getClassName())) {
                return true;
            }
        }
        return false;
    }
}
