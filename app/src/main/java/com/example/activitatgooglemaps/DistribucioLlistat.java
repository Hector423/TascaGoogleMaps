package com.example.activitatgooglemaps;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Collections;
import java.util.List;

public class DistribucioLlistat extends RecyclerView.Adapter<Adaptador>
{
    List<String> paisos;
    List<String> localitat;
    List<String> escenari;
    List<String> data;
    List<String> link;
    Context context;

    public DistribucioLlistat(Context context, List<String> paisos, List<String> localitat, List<String> escenari, List<String> data, List<String> link)
    {
        this.context = context;
        this.paisos = paisos;
        this.localitat = localitat;
        this.escenari = escenari;
        this.data = data;
        this.link = link;
    }

    @NonNull
    @Override
    public Adaptador onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_distribucio_llistat, parent, false);
        return new Adaptador(view).adaptador(this);
    }

    @Override
    public void onBindViewHolder(@NonNull Adaptador holder, int position)
    {
        holder.textPais.setText(paisos.get(position));
        holder.textLocalitat.setText(localitat.get(position));
        holder.textEstadi.setText(escenari.get(position));
        holder.textViewData.setText(data.get(position));
        holder.botoLinkEntrades.setOnClickListener(view -> {
                Uri url = Uri.parse(link.get(position));
                Intent intent = new Intent(Intent.ACTION_VIEW, url);
                context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount()
    {
        return paisos.size();
    }
}

class Adaptador extends RecyclerView.ViewHolder
{
    TextView textPais, textLocalitat, textEstadi, textViewData, textViewComprar, textViewCiutat, textViewLloc, textViewDataText;
    ImageView imageViewLogo;
    ImageButton botoLinkEntrades;
    private DistribucioLlistat distribucioLlistat;

    public Adaptador(@NonNull View itemView)
    {
        super(itemView);
        textViewCiutat   = itemView.findViewById(R.id.textViewTextCiutat);
        textViewLloc     = itemView.findViewById(R.id.textViewTextLloc);
        textViewDataText = itemView.findViewById(R.id.textViewTextData);
        textPais         = itemView.findViewById(R.id.textViewPais);
        textLocalitat    = itemView.findViewById(R.id.textViewLocalitat);
        textEstadi       = itemView.findViewById(R.id.textViewNomEstadi);
        textViewData     = itemView.findViewById(R.id.textViewData);
        textViewComprar  = itemView.findViewById(R.id.textViewComprar);
        imageViewLogo    = itemView.findViewById(R.id.imageViewLogo);
        botoLinkEntrades = itemView.findViewById(R.id.botoLinkEntrades);
    }
    public Adaptador adaptador(DistribucioLlistat distribucioLlistat)
    {
        this.distribucioLlistat = distribucioLlistat;
        return this;
    }
}