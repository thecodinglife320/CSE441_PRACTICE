package com.hfad.f2cc2f;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MainViewModel extends ViewModel {

    public String doC = "";
    public String doF = "";
    public MutableLiveData<String> C2F= new MutableLiveData<>("");
    public MutableLiveData<String>  F2C = new MutableLiveData<>("");

    public void f2c(){

        String formatStr = String.format("%.1f", (Float.parseFloat(doF) - 32) * ((float) 5 / 9));
        F2C.setValue(formatStr);

    }

    public void c2f(){

        String formatStr = String.format("%.1f", Float.parseFloat(doC) * 1.8f + 32);
        C2F.setValue(formatStr);

    }
}
