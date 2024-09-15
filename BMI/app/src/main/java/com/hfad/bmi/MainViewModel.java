package com.hfad.bmi;

import android.content.Context;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.Locale;

public class MainViewModel extends ViewModel {

    Context context;
    public String name = "";
    public String canNang = "";
    public String chieuCao = "";
    public MutableLiveData<String> kqChuanDoan = new MutableLiveData<>("");

    public MainViewModel(Context context){
        this.context = context;
    }

    public void chuanDoan(){

        float bmi = Float.parseFloat(canNang)/(Float.parseFloat(chieuCao)*Float.parseFloat(chieuCao));
        String chuanDoan;
        String advice;

        if (bmi<18){
            chuanDoan = "Ban gay";
            advice = context.getString(R.string.advice1);
        }
        else if (bmi<=24.9){
            chuanDoan = "Ban binh thuong";
            advice = context.getString(R.string.advice2);
        }
        else if (bmi<=29.9){
            chuanDoan = "Ban beo phi cap do 1";
            advice = context.getString(R.string.advice3);
        }
        else if (bmi<=34.9){
            chuanDoan = "Ban beo phi cap do 2";
            advice = context.getString(R.string.advice4);
        }
        else{
            chuanDoan = "Ban beo phi cap do 3";
            advice = context.getString(R.string.advice4);
        }

        String builder = "Ten: " + name + '\n' +
                "Can nang: " + canNang + " kg" + '\n' +
                "Chieu cao: " + chieuCao + " m" + '\n' +
                "Chi so BMI: " + String.format(Locale.getDefault(), "%.1f", bmi) + '\n' +
                "Chuan doan: " + chuanDoan+'\n'+
                "Loi khuyen: " + advice;
        kqChuanDoan.setValue(builder);
    }
}
