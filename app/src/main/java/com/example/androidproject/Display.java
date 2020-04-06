package com.example.androidproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class Display extends AppCompatActivity {


    private static final int REQUEST_CAL=1;
    private EditText mEditTextNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);


        mEditTextNumber=findViewById(R.id.calledit);
        ImageView imagecall=findViewById(R.id.phoneimage);
        imagecall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                makePhoneCall();
            }
        });
    }
    private void makePhoneCall(){
        String number=mEditTextNumber.getText().toString();
        if(number.trim().length()>0){
            if(ContextCompat.checkSelfPermission(Display.this, Manifest.permission.CALL_PHONE)!= PackageManager.PERMISSION_GRANTED){

                ActivityCompat.requestPermissions(Display.this,new String[] {Manifest.permission.CALL_PHONE},REQUEST_CAL);
            } else {

                String dial="tel:"+number;
                startActivity(new Intent(Intent.ACTION_CALL, Uri.parse(dial)));
            }

        }
        else{

            Toast.makeText(Display.this,"Enter the phone number",Toast.LENGTH_LONG).show();
        }

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if(requestCode ==REQUEST_CAL){

            if(grantResults.length > 0 && grantResults[0] ==PackageManager.PERMISSION_GRANTED){
                makePhoneCall();
            }else {
                Toast.makeText(this,"Permission Denied",Toast.LENGTH_LONG).show();
            }
        }
    }

    public void cancel(View view) {

        Intent intent= new Intent(getApplicationContext(),Display.class);
        startActivity(intent);
    }
}
