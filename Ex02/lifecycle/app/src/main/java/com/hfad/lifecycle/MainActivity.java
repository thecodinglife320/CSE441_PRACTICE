package com.hfad.lifecycle;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.hfad.lifecycle.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());

        binding.go.setOnClickListener(v->{
            Intent intent = new Intent(this, SubActivity.class);
            startActivity(intent);
        });

        setContentView(binding.getRoot());
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(this,"CR424 - on Destroy()",Toast.LENGTH_SHORT).show();
    }
    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(this," CR424 - onPause", Toast.LENGTH_SHORT).show();
    }
    @Override
    protected void onRestart() {
        super.onRestart();
        Toast.makeText(this," CR424 - onRestart", Toast.LENGTH_SHORT).show();
    }
    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(this," CR424 - onResume", Toast.LENGTH_SHORT).show();
    }
    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(this," CR424 - onStart", Toast.LENGTH_SHORT).show();
    }
    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(this," CR424 - onStop", Toast.LENGTH_SHORT).show();
    }
}
