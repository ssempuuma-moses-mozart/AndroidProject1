package com.example.androidproject;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class AdapterClass extends RecyclerView.Adapter<RecyclerView.ViewHolder> {


    private static final String TAG = "AdapterClass";
    private ArrayList<String> mimagenames=new ArrayList<>();
    private ArrayList<String> mimages=new ArrayList<>();
    private Context mContext;

    public AdapterClass( Context Context,ArrayList<String> imagenames, ArrayList<String> images) {
        this.mimagenames = imagenames;
        this.mimages = images;
        this.mContext = Context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_list_view,parent,false);
        ViewHolder holder=new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Log.d(TAG, "onBindViewHolder: called");
        Glide.with(mContext)
                .asBitmap()
                .load(mimages.get(position))
                //into
               ;



    }

    @Override
    public int getItemCount() {
        return mimagenames.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{

        CircleImageView image;
        TextView imagename;
        RelativeLayout relative;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            image=itemView.findViewById(R.id.image);
            imagename=itemView.findViewById(R.id.image_name);
            relative=itemView.findViewById(R.id.relative);

        }
    }



}