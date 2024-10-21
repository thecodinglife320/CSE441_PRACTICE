package com.hfad.lifecycle;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.hfad.lifecycle.databinding.ActivitySubBinding;

public class SubActivity extends AppCompatActivity {

    ActivitySubBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySubBinding.inflate(getLayoutInflater());

        binding.btnok.setOnClickListener(v->
            finish()
        );

        setContentView(binding.getRoot());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "sub destroy", Toast.LENGTH_SHORT).show();
    }
}