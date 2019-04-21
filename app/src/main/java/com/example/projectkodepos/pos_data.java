package com.example.projectkodepos;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

public class pos_data {
    Context context;
    List<model_prov_kab> model_prov = new ArrayList<>();
    List<model_prov_kab> model_kab = new ArrayList<>();
    MainView view;
    public pos_data(MainView view, Context context){
        this.view=view;
        this.context=context;
    }

    public void setData_prov(){
        model_prov_kab prov;
        prov= new model_prov_kab(1,"Aceh", R.drawable.ic_place_black_24dp);
        model_prov.add(prov);
        prov= new model_prov_kab(2,"Sumatera Utara", R.drawable.ic_place_black_24dp);
        model_prov.add(prov);
        prov= new model_prov_kab(3,"Sumatera Barat", R.drawable.ic_place_black_24dp);
        model_prov.add(prov);
        prov= new model_prov_kab(4,"Riau", R.drawable.ic_place_black_24dp);
        model_prov.add(prov);
        prov= new model_prov_kab(5,"Kepulauan Riau", R.drawable.ic_place_black_24dp);
        model_prov.add(prov);
        prov= new model_prov_kab(6,"Jambi", R.drawable.ic_place_black_24dp);
        model_prov.add(prov);
        prov= new model_prov_kab(7,"Sumatera Selatan", R.drawable.ic_place_black_24dp);
        model_prov.add(prov);
        prov= new model_prov_kab(8,"Bangka Belitung", R.drawable.ic_place_black_24dp);
        model_prov.add(prov);
        prov= new model_prov_kab(9,"Bengkulu", R.drawable.ic_place_black_24dp);
        model_prov.add(prov);
        prov= new model_prov_kab(10,"Lampung", R.drawable.ic_place_black_24dp);
        model_prov.add(prov);
        prov= new model_prov_kab(11,"DKI Jakarta", R.drawable.ic_place_black_24dp);
        model_prov.add(prov);
        prov= new model_prov_kab(12,"Jawa Barat", R.drawable.ic_place_black_24dp);
        model_prov.add(prov);
        prov= new model_prov_kab(13,"Banten", R.drawable.ic_place_black_24dp);
        model_prov.add(prov);
        prov= new model_prov_kab(14,"Jawa Tengah", R.drawable.ic_place_black_24dp);
        model_prov.add(prov);
        prov= new model_prov_kab(15,"Daerah Istimewa Yogyakarta", R.drawable.ic_place_black_24dp);
        model_prov.add(prov);
        prov= new model_prov_kab(16,"Jawa Timur", R.drawable.ic_place_black_24dp);
        model_prov.add(prov);
        prov= new model_prov_kab(17,"Bali", R.drawable.ic_place_black_24dp);
        model_prov.add(prov);

        view.onSuccess(model_prov);
    }

    public void setData_kab(){
        model_prov_kab kab;
        kab= new model_prov_kab(1,"Kab. Aceh Barat", R.drawable.ic_place_black_24dp);
        model_kab.add(kab);
        kab= new model_prov_kab(1,"Kab. Aceh Barat Daya", R.drawable.ic_place_black_24dp);
        model_kab.add(kab);
        kab= new model_prov_kab(1,"Kab. Aceh Besar", R.drawable.ic_place_black_24dp);
        model_kab.add(kab);
        kab= new model_prov_kab(1,"Kab. Aceh Jaya", R.drawable.ic_place_black_24dp);
        model_kab.add(kab);


        view.onSuccess(model_kab);
    }
}
