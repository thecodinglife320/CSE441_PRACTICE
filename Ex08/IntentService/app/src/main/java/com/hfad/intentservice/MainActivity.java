package com.hfad.intentservice;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.hfad.intentservice.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    Boolean flag=true;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //inflate layout
        ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());

        //event handel
        binding.btnPlay.setOnClickListener(v->{

            Intent intent = new Intent(this, MyService.class);
            startService(intent);
        });

        binding.btnStop.setOnClickListener(v->{
            stopService(new Intent(this, MyService.class));
        });

        //set layout
        setContentView(binding.getRoot());
    }
}
