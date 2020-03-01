package com.example.androidproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class UserRecycler extends AppCompatActivity {

    RecyclerView recyclerView;
    List<UserDetails> userDetailsList;
    UserAdapter userAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_recycler);

        recyclerView=findViewById(R.id.recycler);

        LinearLayoutManager linearLayoutManager=new LinearLayoutManager (  UserRecycler.this );
        linearLayoutManager.setStackFromEnd ( true );
        linearLayoutManager.setReverseLayout ( true );

        recyclerView.setLayoutManager ( linearLayoutManager );

        userDetailsList=new ArrayList<>(  );
        loadAllUserPost();
    }

    private void loadAllUserPost() {
        DatabaseReference reference= FirebaseDatabase.getInstance ().getReference ("users");
        reference.keepSynced ( true );
        reference.addValueEventListener ( new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                for (DataSnapshot ds : dataSnapshot.getChildren ()){

                    UserDetails modelPosts=ds.getValue (UserDetails.class);
                    userDetailsList.add ( modelPosts );
                    userAdapter=new UserAdapter ( UserRecycler.this,userDetailsList );
                    recyclerView.setAdapter ( userAdapter );
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
//if there is an error
                Toast.makeText (  UserRecycler.this , "Error"+ databaseError.getMessage () , Toast.LENGTH_SHORT ).show ();

            }
        } );
    }
}
