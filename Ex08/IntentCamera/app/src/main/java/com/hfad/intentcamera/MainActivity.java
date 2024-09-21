package com.hfad.intentcamera;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import static android.provider.MediaStore.ACTION_IMAGE_CAPTURE;
import com.hfad.intentcamera.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //inflate layout
        binding = ActivityMainBinding.inflate(getLayoutInflater());

        //event handel
        binding.button.setOnClickListener(view -> {
            //request permission
            if (checkSelfPermission(android.Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
                requestPermissions(new String[]{android.Manifest.permission.CAMERA}, 100);
            } else {
                //open camera
                Intent intent = new Intent(ACTION_IMAGE_CAPTURE);
                startActivity(intent);

                //get image
                startActivityForResult(intent, 99);
            }
        });

        //set layout
        setContentView(binding.getRoot());
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 99 && resultCode == Activity.RESULT_OK) {
            Bitmap photo = (Bitmap) data.getExtras().get("data");
            binding.imageView.setImageBitmap(photo);
        }
    }
}
