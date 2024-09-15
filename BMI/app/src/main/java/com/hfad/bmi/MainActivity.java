package com.hfad.bmi;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import com.hfad.bmi.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //set layout
        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        //set databinding variable
        MainViewModelFactory factory = new MainViewModelFactory(this);
        MainViewModel viewModel = new ViewModelProvider(this,factory).get(MainViewModel.class);
        binding.setViewmodel(viewModel);
        binding.setLifecycleOwner(this);
    }
}
