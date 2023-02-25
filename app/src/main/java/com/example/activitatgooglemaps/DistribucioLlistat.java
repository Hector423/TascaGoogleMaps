package com.example.activitatgooglemaps;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Collections;
import java.util.List;

public class DistribucioLlistat extends RecyclerView.Adapter<Adaptador> {

    List<String> paisos;
    List<String> localitat;
    List<String> escenari;


    public DistribucioLlistat(List<String> paisos, List<String> localitat, List<String> escenari){
        this.paisos = paisos;
        this.localitat = localitat;
        this.escenari = escenari;
    }

    @NonNull
    @Override
    public Adaptador onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_distribucio_llistat, parent, false);
        return new Adaptador(view).adaptador(this);
    }

    @Override
    public void onBindViewHolder(@NonNull Adaptador holder, int position) {
        holder.textPais.setText(paisos.get(position));
        holder.textLocalitat.setText(localitat.get(position));
        holder.textEstadi.setText(escenari.get(position));
        holder.textViewData.setText(paisos.get(position));
        holder.textViewComprar.setText(paisos.get(position));
        holder.textViewBuscar.setText(paisos.get(position));
    }

    @Override
    public int getItemCount() {
        return paisos.size();
    }
}

class Adaptador extends RecyclerView.ViewHolder {

    TextView textPais, textLocalitat, textEstadi, textViewData, textViewComprar, textViewBuscar;
    ImageView imageViewLogo;
    ImageButton botoLinkEntrades, botoMapaLloc;
    private DistribucioLlistat distribucioLlistat;

    public Adaptador(@NonNull View itemView) {
        super(itemView);

        textPais = itemView.findViewById(R.id.textViewPais);
        textLocalitat = itemView.findViewById(R.id.textViewLocalitat);
        textEstadi = itemView.findViewById(R.id.textViewNomEstadi);
        textViewData = itemView.findViewById(R.id.textViewData);
        textViewComprar = itemView.findViewById(R.id.textViewComprar);
        textViewBuscar = itemView.findViewById(R.id.textViewBuscar);
        imageViewLogo = itemView.findViewById(R.id.imageViewLogo);
//        botoLinkEntrades.findViewById(R.id.botoLinkEntrades).setOnClickListener(view -> {
//
//        });
//        botoMapaLloc.findViewById(R.id.botoMapaLloc).setOnClickListener(view -> {
//
//        });
    }
    public Adaptador adaptador(DistribucioLlistat distribucioLlistat){
        this.distribucioLlistat = distribucioLlistat;
        return this;
    }
    
}