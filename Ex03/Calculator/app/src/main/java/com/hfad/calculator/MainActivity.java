package com.hfad.calculator;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //set layout
        com.hfad.calculator.databinding.ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        //set viewmodel databinding variable
        CalculatorViewModel viewModel = new ViewModelProvider(this).get(CalculatorViewModel.class);
        binding.setViewModel(viewModel);
        binding.setLifecycleOwner(this);

    }
}
