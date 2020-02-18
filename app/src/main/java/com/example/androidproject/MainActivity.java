package com.example.androidproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

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

        }
    public void sendMessage (View view) {
        EditText message = (EditText)findViewById(R.id.message);
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        intent.putExtra("MESSAGE", message.getText().toString());
        startActivity(intent); message.setText(""); }


        public boolean onCreateOptionsMenu(Menu menu){
            MenuInflater inflater=getMenuInflater();
            inflater.inflate(R.menu.mymenu,menu);

            return true;
        }
        public boolean onOPtionsItemSelected(MenuItem item){

        switch (item.getItemId()){

            case R.id.showmusic:
                startActivity(new Intent(this,Aspire.class));
            return true;

            case R.id.showgallery:
                startActivity(new Intent(this,Show.class));
                return true;

                default:
                    return super.onContextItemSelected(item);
        }
        }




}
