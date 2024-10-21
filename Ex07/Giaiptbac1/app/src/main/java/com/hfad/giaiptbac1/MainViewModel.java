package com.hfad.giaiptbac1;

import androidx.lifecycle.ViewModel;

public class MainViewModel extends ViewModel {

    public String a = "";
    public String b = "";

    public String giai_pt_bac1() {
        String kq;
        float a = Float.parseFloat(this.a);
        float b = Float.parseFloat(this.b);
        if(a==0){
            if(b==0) kq = "Vô số nghiệm";
            else kq = "Vô nghiệm";
        }else kq = "x = " + (-b / a);
        return kq;
    }

}
