package com.example.androidproject;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class Aspire extends AppCompatActivity {

    MediaPlayer player;
    Button btnplay, btnpause;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aspire);

        btnplay = (Button) findViewById(R.id.playbtn);
        btnplay.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                player = MediaPlayer.create(getApplicationContext(), R.raw.stuck_on_u);
                player.start();
            }
        });
        btnpause = (Button) findViewById(R.id.pausebtn);
        btnpause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (player != null && player.isPlaying()) {
                    player.stop();
                }
            }
        });

    }


}