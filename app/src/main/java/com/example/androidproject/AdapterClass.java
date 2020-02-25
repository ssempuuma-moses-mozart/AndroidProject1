package com.example.androidproject;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class AdapterClass extends RecyclerView.Adapter<AdapterClass.ViewHolder>{

    private static final String TAG = "AdapterClass";

    private ArrayList<String> imagenames=new ArrayList<>();
    private ArrayList<String> mimages=new ArrayList<>();
    private Context mContext;

    public AdapterClass( Context mContext,ArrayList<String> imagenames, ArrayList<String> mimages) {
        this.imagenames = imagenames;
        this.mimages = mimages;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_list_view,parent,false);
        ViewHolder holder=new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        Log.d(TAG, "onBindViewHolder: called.");


    }

    @Override
    public int getItemCount() {
        return imagenames.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

         ImageView imageView;
         TextView textView;
         TextView textView2;

        public ViewHolder(View view){


            super(view);
            imageView=view.findViewById(R.id.imageView);
            textView=view.findViewById(R.id.textView);
            textView2=view.findViewById(R.id.textView2);


        }

//    private List<ModelClass> modelClassList;
//
//    public AdapterClass(List<ModelClass> modelClassList) {
//        this.modelClassList = modelClassList;
//    }
//
//    @NonNull
//    @Override
//    public Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        //View view= LayoutInflater.from(ViewGroup.getcontext()).inflate()
//        return null;
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull Viewholder holder, int position) {
//
//    }
//
//    @Override
//    public int getItemCount() {
//        return 0;
//    }
//
//    class Viewholder extends RecyclerView.ViewHolder{
//
//        private ImageView image_View;
//        private TextView textView;
//        private TextView textView2;
//
//
//        public Viewholder(View itemView){
//            super(itemView);
//
//            image_View=itemView.findViewById(R.id.imageView);
//            textView=itemView.findViewById(R.id.textView);
//             textView2=itemView.findViewById(R.id.textView2);
//
//
//        }
//        private void setDate(int imageView, String textView, String textView2){
//
//
//        }
//    }


    }
}