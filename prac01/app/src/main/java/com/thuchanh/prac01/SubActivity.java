package com.thuchanh.prac01;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.thuchanh.prac01.databinding.ActivitySubBinding;

public class SubActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //set layout
        ActivitySubBinding binding = ActivitySubBinding.inflate(getLayoutInflater());

        binding.button.setOnClickListener(v -> {
            Intent resultIntent = new Intent();

            // put your result data
            resultIntent.putExtra("name", binding.name.getText().toString());
            resultIntent.putExtra("gpa", binding.gpa.getText().toString());
            setResult(Activity.RESULT_OK, resultIntent);
            finish();
        });
        setContentView(binding.getRoot());
    }
}
