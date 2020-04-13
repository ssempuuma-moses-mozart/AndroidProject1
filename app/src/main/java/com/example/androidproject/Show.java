package com.example.androidproject;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.InputStream;

import static android.os.Build.VERSION_CODES.M;

public class Show extends AppCompatActivity {
Button btn;
TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);
        textView=findViewById(R.id.textV);

        btn=(Button)findViewById(R.id.buttonc);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text="";

                try{
                    InputStream input=getAssets().open("CProgram.c");
                    int size=input.available();
                    byte[] buffer=new byte[size];
                    input.read(buffer);
                    input.close();

                    text = new String(buffer);

                }catch (Exception ex){
        ex.printStackTrace();

                }
                textView.setText((CharSequence) text);

            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.mymenu,menu);
        return super.onCreateOptionsMenu(menu);
    }
    @RequiresApi(api = M)
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id=item.getItemId();
        switch (id){
            case R.id.callPhone:
                Intent intentDial =new Intent(Intent.ACTION_DIAL);
                intentDial.setData(Uri.parse("tel:"+"0775218489"));
                if (Build.VERSION.SDK_INT >= M) {
                    if (getApplicationContext().checkSelfPermission(Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED){
                        ActivityCompat.requestPermissions(Show.this,new String[]{Manifest.permission.CALL_PHONE},100);;
                    }
                }
                intentDial.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intentDial);


                return true;
            case R.id.showgallery:
                startActivity(new Intent(getApplicationContext(),UserRecycler.class));
                return true;
            case  R.id.showmusic:
                startActivity(new Intent(this, Screen.class));
                Intent intent=new Intent(Intent.ACTION_SEND);
                intent.setData(Uri.parse("mailto"));
                String to []={"ssempuumamosesm@gmail.com,bvicxbax@gmail.com,michaelajnew@gmail.com,tmbonimpa@gmail.com"};
                intent.putExtra(Intent.EXTRA_EMAIL,to);
                intent.putExtra(Intent.EXTRA_SUBJECT,"hey");
                intent.putExtra(Intent.EXTRA_TEXT,"design");
                intent.setType("message/rfc822");
                startActivity(intent);

                //takes you to the website
                // Intent intentObj = new Intent(Intent.ACTION_VIEW);
                //intentObj.setData(Uri.parse("https://www.abhiandroid.com"));
                //  startActivity(intentObj);
                return true;
            case R.id.show:
                startActivity(new Intent(this, ListViewActivity.class));
                return true;
            case R.id.phone:
                startActivity(new Intent(this,Display.class));
            default:
                return false;
        }
    }
}
