package com.example.listview;

import android.os.Bundle;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.listview.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        @NonNull ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        //create a list of phone model
        String[] phoneModels = getResources().getStringArray(R.array.phone_models);

        //put list into array adapter
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, phoneModels);
        binding.listView.setAdapter(adapter);
        binding.listView.setOnItemClickListener((parent, view, position, id) -> {
            String selectedModel = phoneModels[position];
            binding.textView.setText(id+". "+selectedModel);
        });
    }
}