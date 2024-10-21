package com.hfad.solar2lunal;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MainViewModel extends ViewModel {

    public String namDuongLich = "";
    public MutableLiveData<String> namAmLich = new MutableLiveData<>("");
    private final String[] can = {"Canh", "Tân", "Nhâm", "Quý", "Giáp", "Ất", "Bính", "Đinh", "Mậu", "Kỷ"};
    private final String[] chi = {"Thân", "Dậu", "Tuất", "Hợi", "Tý", "Sửu", "Dần", "Mão", "Thìn", "Tỵ", "Ngọ", "Mùi"};

    public void chuyenDoi(){
        if (namDuongLich.contains(".") || namDuongLich.isEmpty()){
            namAmLich.setValue("a");
        }else {
            int nam = Integer.parseInt(namDuongLich);
            namAmLich.setValue(can[nam % 10] + " "+chi[nam % 12]);
        }
    }
}



