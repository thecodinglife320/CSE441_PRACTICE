package com.hfad.personalinfo;

import android.os.Bundle;

import androidx.activity.OnBackPressedCallback;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
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
        binding.setLifecycleOwner(this);

        //set event
        binding.submit.setOnClickListener(v->{
            String info = viewModel.submit();
            AlertDialog.Builder builder=new AlertDialog.Builder(this);
            builder.setTitle("Thông tin cá nhân");
            builder.setPositiveButton("Đóng", (dialog, which) -> dialog.cancel());
            builder.setMessage(info);
            builder.create().show();
        });

        //custom back navigation
        OnBackPressedCallback callback = new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
//                Log.d("back", "back");
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Thông báo");
                builder.setIcon(R.drawable.baseline_warning_24);
                builder.setMessage("Bạn có muốn thoát ứng dụng?");
                builder.setPositiveButton("Co", (dialog, which)-> finish());
                builder.setNegativeButton("Khong", (dialog, which)->dialog.cancel());
                builder.create().show();
                }
        };
        getOnBackPressedDispatcher().addCallback(this, callback);
    }
}
