package com.example.androidproject;

import android.app.Application;

import com.google.firebase.database.FirebaseDatabase;


public class AndroidProject extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        FirebaseDatabase.getInstance().setPersistenceEnabled(true);
    }
}
