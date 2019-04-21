package com.example.projectkodepos;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class f_provinsi extends Fragment implements MainView {
    List<model_prov_kab> model_prov_kabs = new ArrayList<>();
    adapter_prov adapter;

    public f_provinsi() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_f_provinsi, container, false);
    }

    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.rv1);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));
        adapter = new adapter_prov(getContext(), model_prov_kabs);
        recyclerView.setAdapter(adapter);
        pos_data data = new pos_data(this,getContext());
        data.setData_prov();
    }

    public void onSuccess(List<model_prov_kab> kampusModels){
        this.model_prov_kabs.clear();
        this.model_prov_kabs.addAll(kampusModels);
        this.adapter.notifyDataSetChanged();
    }

}
