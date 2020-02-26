package com.example.androidproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);




        setContentView(R.layout.activity_main);
        Button musi =(Button)findViewById(R.id.button);
        musi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,Aspire.class);
                startActivity(intent);
            }
        });
        Button listviewbutton=(Button)findViewById(R.id.listviewbtn);
        listviewbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,ListViewActivity.class);
                startActivity(intent);
            }
        });
        Button C=(Button)findViewById(R.id.cprogrambtn);

     C.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent intent = new Intent(MainActivity.this,Show.class);
        startActivity(intent);
    }
});

      Button ryclebutton=(Button)findViewById(R.id.rycle);
     ryclebutton.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
             Intent intent=new Intent(MainActivity.this,RecyclerViewActivity.class);
             startActivity(intent);
         }
     });
    }


    public void sendMessage (View view) {
        EditText message = (EditText) findViewById(R.id.message);
        Intent intent = new Intent(MainActivity.this, DisplayMessageActivity.class);
        intent.putExtra("MESSAGE", message.getText().toString());
        startActivity(intent);
        message.setText("");


    }

        public boolean onCreateOptionsMenu(Menu menu){
            MenuInflater inflater=getMenuInflater();
            inflater.inflate(R.menu.mymenu,menu);

            return true;
        }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {



            switch (item.getItemId()) {

                case R.id.showmusic:
                    startActivity(new Intent(this, Display.class));
                    return true;

                case R.id.showgallery:
                    startActivity(new Intent(this, Screen.class));
                    return true;


                default:

                    return super.onOptionsItemSelected(item);

        }




    }
}



          /*  int id = item.getItemId();
            if (id == R.id.showmusic) {

                Intent myintent=new Intent(MainActivity.this,Display.class);

                startActivity(myintent);
                return true;
            }


            if (id == R.id.showgallery) {

                Intent myintent=new Intent(MainActivity.this,Show.class);

                startActivity(myintent);
                return true;
            }

            return super.onContextItemSelected(item);
        }*/


