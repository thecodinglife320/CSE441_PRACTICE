package com.hfad.giaiptbac2;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import com.hfad.giaiptbac2.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //set layout
        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        //set viewmodel
        MainViewModel viewModel = new ViewModelProvider(this).get(MainViewModel.class);
        binding.setViewmodel(viewModel);

        //set lifecycle owner
        binding.setLifecycleOwner(this);

        //set event
        binding.button.setOnClickListener(v -> {
            binding.inputA.setText("");
            binding.inputB.setText("");
            binding.inputC.setText("");
            viewModel.kq.setValue("");
            binding.inputA.requestFocus();
        });

        binding.button3.setOnClickListener(v -> finish());
    }
}
