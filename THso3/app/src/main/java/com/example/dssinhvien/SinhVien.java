package com.example.dssinhvien;

public class SinhVien {
    String id;
    String full_name;
    String gender;
    String birthDate;
    String email;
    String address;
    String major;
    Float gqa;
    int year;

    //constructor

    public SinhVien(String id, String full_name, String gender, String birthDate, String email, String address, String major, Float gqa, int year) {
        this.id = id;
        this.full_name = full_name;
        this.gender = gender;
        this.birthDate = birthDate;
        this.email = email;
        this.address = address;
        this.major = major;
        this.gqa = gqa;
        this.year = year;
    }
}
