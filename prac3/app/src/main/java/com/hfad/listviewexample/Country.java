package com.hfad.listviewexample;

public class Country {
    private String name;
    private int flag;    //duong dan anh
    private String thuDo;

    public Country(String name, int flag, String thuDo) {
        this.name = name;
        this.flag = flag;
        this.thuDo = thuDo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    public String getThuDo() {
        return thuDo;
    }

    public void setThuDo(String thuDo) {
        this.thuDo = thuDo;
    }
}
