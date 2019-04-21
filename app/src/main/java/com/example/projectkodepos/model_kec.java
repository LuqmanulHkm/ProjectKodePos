package com.example.projectkodepos;

public class model_kec {
    String nama_kecamatan;
    int pickecamatan;

    public model_kec(String nama_kecamatan, int pickecamatan){
        this.nama_kecamatan = nama_kecamatan;
        this.pickecamatan = pickecamatan;
    }

    public String getNama_kecamatan() {
        return nama_kecamatan;
    }

    public int getPickecamatan() {
        return pickecamatan;
    }
}
