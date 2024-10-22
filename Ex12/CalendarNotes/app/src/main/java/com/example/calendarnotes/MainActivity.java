package com.example.calendarnotes;

import android.app.TimePickerDialog;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.calendarnotes.databinding.ActivityMainBinding;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    private @NonNull ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Date currentDate = Calendar.getInstance().getTime();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        binding.today.setText(simpleDateFormat.format(currentDate));

        binding.remindBtn.setOnClickListener(v -> showTimePickerDialog());

        ArrayList<String> listSang = new ArrayList<>();
        ArrayList<String> listChieu = new ArrayList<>();
        WorkListChieuAd adapterChieu = new WorkListChieuAd(listChieu);
        WorkListSangAd adapterSang = new WorkListSangAd(listSang);
        binding.workListSang.setAdapter(adapterSang);
        binding.workListChieu.setAdapter(adapterChieu);
        binding.workListSang.setLayoutManager(new LinearLayoutManager(this));
        binding.workListChieu.setLayoutManager(new LinearLayoutManager(this));

        binding.addBtn.setOnClickListener(v -> {
            String work = binding.workEdt.getText().toString();
            if (!work.isEmpty()) {
                if(binding.textClock2.getText().toString().contains("sang")){
                    adapterSang.addWork(work+" - "+binding.textClock2.getText().toString());
                }else{
                    adapterChieu.addWork(work+" - "+binding.textClock2.getText().toString());
                }
                binding.workEdt.setText("");
            }else {
                binding.workEdt.setError("Please enter a work");
            }
        });
    }

    private void showTimePickerDialog() {
        Calendar calendar = Calendar.getInstance();
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);

        TimePickerDialog timePickerDialog = new TimePickerDialog(
                this,
                (view, hourOfDay, minute1) -> {
                    String selectedTime = "";
                    if (hourOfDay>=12){
                        hourOfDay-=12;
                        selectedTime = hourOfDay + ":" + String.format("%02d", minute1)+" chieu";
                    }else{
                        selectedTime = hourOfDay + ":" + String.format("%02d", minute1)+" sang";
                    }
                    binding.textClock2.setText(selectedTime);
                    Log.d("TAG", "showTimePickerDialog: "+hourOfDay+":"+minute1);
                },
                hour,
                minute,
                true // Use 24-hour format
        );
        timePickerDialog.show();
    }

}