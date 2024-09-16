package com.hfad.solar2lunal;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import com.hfad.solar2lunal.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //set layout
        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        //set databinding variable
        MainViewModel viewModel = new ViewModelProvider(this).get(MainViewModel.class);
        binding.setViewmodel(viewModel);
        binding.setLifecycleOwner(this);

        viewModel.namAmLich.observe(this, s -> {
            if (s.equals("a")) {
                binding.namDuongLich.setError("Vui lòng nhập năm dương lịch");
                viewModel.namAmLich.setValue("");
            }
        });

    }
}
