package com.example.androidproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

public class InternalAndExternalStorage extends AppCompatActivity {
    EditText etname;
    Button btcreate,btopen;
    String name;
    Button btnsave, btnload;
    EditText etinput;
    TextView tvload;
    String filename="";
    String filepath="";
    String filecontent="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_internal_and_external_storage);
        btnsave=findViewById(R.id.btnsave);
        btnload=findViewById(R.id.btnload);
        etinput=findViewById(R.id.etinput);
        tvload=findViewById(R.id.tvload);
        filename="myFile.text";
        filepath="MyFileDir";
        if(isExternalStorageAvailableForRW()){
            btnsave.setEnabled(true);
        }
        btnsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvload.setText("");
                filecontent=etinput.getText().toString().trim();
                if (!filecontent.equals("")){
                    File myExternalFile=new File(getExternalFilesDir(filepath),filename);
                    FileOutputStream fos=null;
                    try {
                        fos=new FileOutputStream(myExternalFile);
                        fos.write(filecontent.getBytes());
                    }catch (FileNotFoundException e){
                        e.printStackTrace();

                    }catch (IOException e){
                        e.printStackTrace();
                    }
                    etinput.setText("");
                    Toast.makeText(getApplicationContext(),"information saved on the sd card",Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(getApplicationContext(),"Text field can't be empty",Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FileReader fr=null;
                File myExternalfile = new File(getExternalFilesDir(filepath), filename);
                StringBuilder stringBuilder =new StringBuilder();
                try{
                    fr= new FileReader(myExternalfile);
                    BufferedReader br=new BufferedReader(fr);
                    String line=br.readLine();
                    while (line != null){
                        stringBuilder.append(line).append('\n');
                        line= br.readLine();
                    }

                }catch (FileNotFoundException e){
                    e.printStackTrace();
                }catch (IOException e){
                    e.printStackTrace();
                }finally {
                    String fileContents="File contents \n" + stringBuilder.toString();
                    tvload.setText(fileContents);

                }

            }
        });
        etname=findViewById(R.id.etname);
        btcreate=findViewById(R.id.btcreate);
        btopen=findViewById(R.id.btopen);
        btcreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //get folder name from edit text
                name=etname.getText().toString().trim();
                //check condition
                if(ActivityCompat.checkSelfPermission(InternalAndExternalStorage.this, Manifest.permission.WRITE_EXTERNAL_STORAGE)==
                        getPackageManager().PERMISSION_GRANTED){
                    //when permission granted
                    // call method
                    CreateFolder();
                }else {
                    //when permission is not granted
                    //request permission
                    ActivityCompat.requestPermissions(InternalAndExternalStorage.this,new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},
                            100);
                }

            }
        });
        btopen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //get name from edit text
                name=etname.getText().toString().trim();
                //initialize uri
                Uri uri=Uri.parse(Environment.getExternalStorageDirectory() + "/" + name + "/");
                //open file manager
                startActivity(new Intent(Intent.ACTION_GET_CONTENT).setDataAndType(uri,"*/*"));
            }
        });
    }

    private boolean isExternalStorageAvailableForRW() {
        String extStorageState= Environment.getExternalStorageState();
        if (extStorageState.equals(Environment.MEDIA_MOUNTED)){
            return true;
        }
        return false;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        //check condition
        if(requestCode == 100 && (grantResults.length > 0) && (grantResults[0]== PackageManager.PERMISSION_GRANTED)){
            //when permission is granted
            //call method
            CreateFolder();
        }else {
            //when permission is denied
            //display toast
            Toast.makeText(getApplicationContext(),"Permission Denied",Toast.LENGTH_SHORT).show();
        }
    }

    private void CreateFolder(){
        //initialize file
//        File file=new File(Environment.getDownloadCacheDirectory(),name);
//        one example
//        File mediaStorageDir = new File(Environment.getExternalStorageDirectory(), "MyDirName");
//
//        if (!mediaStorageDir.exists()) {
//            if (!mediaStorageDir.mkdirs()) {
//                Log.d("App", "failed to create directory");
//            }
//        }else{
//            Toast.makeText(getApplicationContext(),"Directory created successfully",Toast.LENGTH_SHORT).show();
//        }
        //second example
        File Med=new File(Environment.getExternalStorageDirectory(),"myDirName");
        if (!Med.exists()) {
            if (Med.mkdir()) {
                Toast.makeText(this, "Directory Created", Toast.LENGTH_SHORT).show();
            } else {
                Log.d("App", "Err");
            }
        }
        //check condition
        // if(file.exists()){
        //when directory is already exist
        //display toast
        //  Toast.makeText(getApplicationContext(),"Directory already exist",Toast.LENGTH_SHORT).show();

        // }else {
        //when directory is not exist
        //create new directory
        // file.mkdirs();
        //check condition
        //  if(file.isDirectory()){
        //when directory is created
        Toast.makeText(getApplicationContext(),"Directory created successfully",Toast.LENGTH_SHORT).show();

        // }else{
        //when directory is not created
        //Display alert dialog
//                AlertDialog.Builder builder=new AlertDialog.Builder(InternalAndExtenalStorage.this);
//                String smassage="Message:failed to create directory"+"\nPath :"+ Environment.getExternalStorageDirectory()+ "\nmkdirs :"+
//                        file.mkdirs();
//                builder.setMessage(smassage);
//                builder.show();
//            }
//        }
    }
    public void gotoservice(View view) {
        Intent intent=new Intent(InternalAndExternalStorage.this,ForegroundServiceActivity.class);
        startActivity(intent);
    }
}


