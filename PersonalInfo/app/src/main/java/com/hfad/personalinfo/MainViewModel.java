package com.hfad.personalinfo;

import androidx.lifecycle.ViewModel;

public class MainViewModel extends ViewModel {

    public boolean trungCap = false;
    public boolean daiHoc = true;
    public boolean caoDang = false;
    public boolean docSach = false;
    public boolean ngheNhac = false;
    public boolean xemPhim = false;
    public String extra = "";
    public String ten="";
    public String cmnd="";

    public String submit(){

        String info;
        String bangCap="";
        StringBuilder soThich = new StringBuilder();

        if(trungCap) bangCap = "Trung cap";
        else if (daiHoc) bangCap = "Dai hoc";
        else if (caoDang) bangCap = "Cao dang";

        if(docSach) soThich.append("Doc sach");
        if (ngheNhac) soThich.append("Nghe nhac");
        if(xemPhim) soThich.append("Xem phim");

        info = ten+'\n'
                +cmnd+'\n'
                +bangCap+'\n'
                +soThich+'\n'
                +extra+'\n';

        return info;
    }

}
