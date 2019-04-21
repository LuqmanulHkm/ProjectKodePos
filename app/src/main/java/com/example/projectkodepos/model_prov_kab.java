package com.example.projectkodepos;

public class model_prov_kab {
    String nama_provkab;
    int pic_provkab,id;

    public model_prov_kab(int id, String nama_provkab, int pic_provkab){
        this.id = id;
        this.nama_provkab = nama_provkab;
        this.pic_provkab = pic_provkab;
    }
    public int getId() {
        return id;
    }

    public String getNama_provkab() {
        return nama_provkab;
    }

    public int getPic_provkab() {
        return pic_provkab;
    }
}
