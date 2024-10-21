package com.hfad.calculator;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class CalculatorViewModel extends ViewModel {

    public String a="";
    public String b="";
    public MutableLiveData<String> kq = new MutableLiveData<>("");
    //public String kq="";

    public void cong(){
        kq.setValue(String.valueOf(Float.parseFloat(a) + Float.parseFloat(b)));
    }

    public void tru(){
        kq.setValue(String.valueOf(Float.parseFloat(a) - Float.parseFloat(b)));
    }

    public void nhan(){
        kq.setValue(String.valueOf(Float.parseFloat(a) * Float.parseFloat(b)));
    }

    public void chia(){
        if (b.equals("0")) kq.setValue("Khong chia duoc cho 0");
        else kq.setValue(String.valueOf(Float.parseFloat(a) / Float.parseFloat(b)));
    }

}
