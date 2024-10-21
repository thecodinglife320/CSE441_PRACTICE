package com.hfad.callandsms;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.hfad.callandsms.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //set layout
        ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        //event handle
        binding.phone.setOnClickListener(v -> {
            String phoneNumber = binding.phoneNumber.getText().toString();
            if (phoneNumber.isEmpty()){
                Toast.makeText(this, "Please enter a phone number", Toast.LENGTH_SHORT).show();
                return;
            }
            if(ContextCompat.checkSelfPermission(this, android.Manifest.permission.CALL_PHONE)
            !=PackageManager.PERMISSION_GRANTED){
                ActivityCompat.requestPermissions(
                        this,new String[]{android.Manifest.permission.CALL_PHONE},1
                );
            }else{
                Intent intent = new Intent(Intent.ACTION_CALL);
                intent.setData(Uri.parse("tel:" + phoneNumber));
                startActivity(intent);
            }
        });

        binding.sms.setOnClickListener(v -> {
            //call intent
            String phoneNumber = binding.phoneNumber.getText().toString();
            if (phoneNumber.isEmpty())
                Toast.makeText(this, "Please enter a phone number", Toast.LENGTH_SHORT).show();
            else{
                Intent intent = new Intent(Intent.ACTION_SENDTO);
                intent.setData(Uri.parse("smsto:" + phoneNumber));
                startActivity(intent);
            }
        });
    }
}
