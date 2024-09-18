package com.hfad.personalinfo;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.hfad.personalinfo.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //set layout
        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        //set databinding variable
        MainViewModel viewModel = new MainViewModel();
        binding.setViewmodel(viewModel);
    }
}
