package com.example.androidproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SQLiteActivity extends AppCompatActivity {
    EditText name, course, regno;
    Button saveBtn;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sqlite);
        name = (EditText)findViewById(R.id.txtname);
        course = (EditText)findViewById(R.id.txtcourse);
        regno = (EditText)findViewById(R.id.txtregno);
        saveBtn = (Button)findViewById(R.id.btnSave);
        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String uname = name.getText().toString()+"\n";
                String cours = course.getText().toString();
                String registno = regno.getText().toString();
                if (uname.isEmpty()){
                    Toast.makeText(SQLiteActivity.this,"Enter Your Name",Toast.LENGTH_SHORT).show();
                }else if (cours.isEmpty()){
                    Toast.makeText(SQLiteActivity.this,"Enter the course your doing",Toast.LENGTH_SHORT).show();
                }else if (registno.isEmpty()){
                    Toast.makeText(SQLiteActivity.this,"Enter reg no",Toast.LENGTH_SHORT).show();
                }else{
                    //submit to database

                    DbHandler dbHandler = new DbHandler(SQLiteActivity.this);
                    dbHandler.insertUserDetails(uname,cours,registno);
                    intent = new Intent(SQLiteActivity.this,DetailsActivity.class);
                    startActivity(intent);
                    Toast.makeText(getApplicationContext(), "Details Inserted Successfully", Toast.LENGTH_SHORT).show();
                }

            }
        });

    }
}
