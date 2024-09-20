package com.hfad.giaiptbac1;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import com.hfad.giaiptbac1.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //set layout
        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        //set data variable
        MainViewModel viewModel = new ViewModelProvider(this).get(MainViewModel.class);
        binding.setViewmodel(viewModel);

        //set lifecycle
        binding.setLifecycleOwner(this);

        //event
        binding.button.setOnClickListener(v -> {
            String kq = viewModel.giai_pt_bac1();

            //intent
            Intent intent = new Intent(this, ResultActivity.class);
            intent.putExtra("ketqua", kq);
            startActivity(intent);
        });
    }
}
