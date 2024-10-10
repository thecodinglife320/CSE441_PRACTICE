package com.example.dssinhvien;

import android.content.res.AssetManager;
import android.media.RouteListingPreference;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AssetManager assetManager = getAssets();
        String jsonString;
        try {
            InputStream is = assetManager.open("sinhvien.json");
            StringBuilder jsonStringBuilder = new StringBuilder();
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            String line;
            while ((line = reader.readLine()) != null) {
                jsonStringBuilder.append(line);
            }
            jsonString = jsonStringBuilder.toString();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Gson gson = new Gson();
        // Assuming your JSON represents an array of "Item" objects
        Type type = new TypeToken<List<SinhVien>>() {
        }.getType();
        List<SinhVien> items = gson.fromJson(jsonString, type);
        items.forEach(item -> Log.d("item", item.toString()));
    }
}