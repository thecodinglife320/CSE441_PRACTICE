package com.hfad.giaiptbac1;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.hfad.giaiptbac1.databinding.ActivityResultBinding;

public class ResultActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //set layout
        ActivityResultBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_result);

        //get data
        String kq = getIntent().getStringExtra("ketqua");
        binding.textView2.setText(kq);

        //event
        binding.button2.setOnClickListener(v -> finish());
    }
}
