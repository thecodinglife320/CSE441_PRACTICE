package com.hfad.intentservice;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.hfad.intentservice.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    Boolean flag=true;
    private static final String AUDIO_URL =
            "https://www.soundhelix.com/examples/mp3/SoundHelix-Song-1.mp3";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //inflate layout
        ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());

        //event handel
        binding.btnPlay.setOnClickListener(v->{
            Intent intent = new Intent(MainActivity.this, MusicService.class);
            intent.putExtra("audioUrl", AUDIO_URL);
            startService(intent);
            binding.textView.setText("Đang phát: SoundHelix-Song-1.mp3");
        });

        binding.btnStop.setOnClickListener(v->{
            Intent intent = new Intent(MainActivity.this, MusicService.class);
            stopService(intent);
            binding.textView.setText("Dừng phát nhạc");
        });

        //set layout
        setContentView(binding.getRoot());
    }
}
