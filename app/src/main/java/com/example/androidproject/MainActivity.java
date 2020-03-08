package com.example.androidproject;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import static android.os.Build.VERSION_CODES.M;

public class MainActivity extends AppCompatActivity {


    BroadcastReceiver myreciever=new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            int y=intent.getIntExtra("level",0);
            ProgressBar prog=(ProgressBar)findViewById(R.id.progressbar);
            prog.setProgress(y);
            TextView view=(TextView)findViewById(R.id.edittextprogressbar);
            view.setText("Battery level is :"+ Integer.toString(y)+"%");
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        registerReceiver(myreciever,new IntentFilter(Intent.ACTION_BATTERY_CHANGED));


        setContentView(R.layout.activity_main);
        Button musi = (Button) findViewById(R.id.button);
        musi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Aspire.class);
                startActivity(intent);
            }
        });

        Button C = (Button) findViewById(R.id.cprogrambtn);

        C.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Show.class);
                startActivity(intent);
            }
        });

    }



    public void sendMessage(View view) {
        EditText message = (EditText) findViewById(R.id.message);

        Intent intent = new Intent(MainActivity.this, DisplayMessageActivity.class);
        intent.putExtra("MESSAGE", message.getText().toString());
        startActivity(intent);
        message.setText("");


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
                        ActivityCompat.requestPermissions(MainActivity.this,new String[]{Manifest.permission.CALL_PHONE},100);;
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
                default:
                    return false;
        }
    }
}
