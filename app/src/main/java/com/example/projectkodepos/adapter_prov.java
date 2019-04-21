package com.example.projectkodepos;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class adapter_prov extends RecyclerView.Adapter<adapter_prov.ViewHolder> {
    Context context;
    List<model_prov_kab> model_prov_kabs = new ArrayList<>();

    public adapter_prov(Context context, List<model_prov_kab> model_prov_kabs) {
        this.context = context;
        this.model_prov_kabs = model_prov_kabs;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.provinsi_view, viewGroup, false); // menghubungkan ke layout
        ViewHolder holder = new ViewHolder(view); // deklarasi class ViewHolder di baris 46
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int i) {
        viewHolder.tvNama.setText(model_prov_kabs.get(i).getNama_provkab());
        viewHolder.ivFoto.setImageResource(model_prov_kabs.get(i).getPic_provkab());
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Toast.makeText(context, model_prov_kabs.get(i).getNama_provkab(), Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return model_prov_kabs.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView ivFoto;
        TextView tvNama;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ivFoto = itemView.findViewById(R.id.pic);
            tvNama = itemView.findViewById(R.id.tv1);
        }
    }
}
