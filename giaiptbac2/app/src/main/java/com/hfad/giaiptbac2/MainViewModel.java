package com.hfad.giaiptbac2;

import static java.lang.Math.sqrt;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MainViewModel extends ViewModel {

    public String a="";
    public String b="";
    public String c="";
    public MutableLiveData<String> kq = new MutableLiveData<>("");

    public void giai(){
        float a = Float.parseFloat(this.a);
        float b = Float.parseFloat(this.b);
        float c = Float.parseFloat(this.c);

        if(a==0){
            if(b==0){
                if(c==0){
                    kq.setValue("Phương trình vô số nghiệm");
                }else{
                    kq.setValue("Phương trình vô nghiệm");
                }
            }else {
                kq.setValue("Phương trình có nghiệm duy nhất: x = "+ (-c/b));
            }
        }
        else {
            float delta = b * b - 4 * a * c;
            if (delta < 0) {
                kq.setValue("Phương trình vô nghiệm");
            }else if (delta == 0) {
                kq.setValue("Phương trình có nghiệm kép x1 = x2 = " + (-b / (2 * a)));
            }else {
                float x1 = (float) ((-b + sqrt(delta)) / (2 * a));
                float x2 = (float) ((-b - sqrt(delta)) / (2 * a));
                kq.setValue("Phương trình có 2 nghiệm phân biệt x1 = " + x1 + " và x2 = " + x2);
            }
        }
    }
}
