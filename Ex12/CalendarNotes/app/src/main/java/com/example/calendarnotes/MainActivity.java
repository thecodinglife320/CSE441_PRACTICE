package com.example.calendarnotes;

import android.app.TimePickerDialog;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.TimePicker;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

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

        binding.remindBtn.setOnClickListener(v -> {
            showTimePickerDialog();
        });

        ArrayList<String> works = new ArrayList<>();
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, works);
        binding.workList.setAdapter(adapter);

        binding.addBtn.setOnClickListener(v -> {
            String work = binding.workEdt.getText().toString();
            if (!work.isEmpty()) {
                adapter.add(work+" - "+binding.textClock2.getText().toString());
                adapter.notifyDataSetChanged();
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
                    String selectedTime = hourOfDay + ":" + minute1;
                    binding.textClock2.setText(selectedTime);
                },
                hour,
                minute,
                false // Use 24-hour format
        );
        timePickerDialog.show();
    }

}