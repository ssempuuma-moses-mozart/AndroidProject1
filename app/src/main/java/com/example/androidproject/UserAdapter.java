package com.example.androidproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class UserAdapter extends   RecyclerView.Adapter<UserAdapter.MyHolder> {

    Context context;
    List<UserDetails> userList;

    public UserAdapter(Context context , List<UserDetails> userList) {
        this.context = context;
        this.userList = userList;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup viewGroup , int i) {

//        inflate the layout
        View view= LayoutInflater.from ( context ).inflate ( R.layout.row_user,viewGroup,false );

        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder myHolder , int i) {
//get the data


        String name=userList.get ( i ).getName();
        String phone=userList.get ( i ).getPhone ();
        final String image=userList.get ( i ).getImage ();

        myHolder.userName.setText(name);
        myHolder.userphone.setText(phone);

        try{
            Glide.with(context)
                    .load(image)
                    .into(myHolder.img);

        }
        catch (Exception e){
            e.printStackTrace();
            Toast.makeText(context, ""+e.getMessage(), Toast.LENGTH_SHORT).show();
        }

        myHolder.img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, ""+image, Toast.LENGTH_SHORT).show();
            }
        });




    }

    @Override
    public int getItemCount() {
        return userList.size ();
    }




    class  MyHolder extends RecyclerView.ViewHolder{

        //        View from the row post.xml

        TextView userName,userphone;
        CircleImageView img;



        public MyHolder(@NonNull View itemView) {
            super ( itemView );

//            initialize views
            userName=itemView.findViewById(R.id.usernameg);
            userphone=itemView.findViewById(R.id.userphone);
            img=itemView.findViewById(R.id.imgU);


        }
    }


}
