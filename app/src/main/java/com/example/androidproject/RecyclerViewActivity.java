package com.example.androidproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;

public class RecyclerViewActivity extends AppCompatActivity {

    private static final String TAG = "RecyclerViewActivity";
    private ArrayList<String> nName=new ArrayList<>();
    private ArrayList<String> mimageulrs=new ArrayList<>();



    private RecyclerView recycler_View;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Log.d(TAG, "onCreate: started");
        initImageBitmaps();

//        setContentView(R.layout.activity_recycler_view);
//
//        recycler_View=findViewById(R.id.recyclerview);
//        LinearLayoutManager layoutManager=new LinearLayoutManager(this);
//        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
//        recycler_View.setLayoutManager(layoutManager);
    }

    private void initImageBitmaps(){
        Log.d(TAG, "initImageBitmaps: preparing bitmaps");

        mimageulrs.add("https://c1.staticflicker.com/5/4636/25316407448_de5fbf183d_o.jpg");
        nName.add("Havasu Falls");
        initRecyclerView();

    }
    private void initRecyclerView(){

        Log.d(TAG, "initRecyclerView: init Recyclerview");
        RecyclerView recyclerView=findViewById(R.id.recyclerview);
        RecyclerViewActivity adapter=new RecyclerViewActivity();

    }
}
