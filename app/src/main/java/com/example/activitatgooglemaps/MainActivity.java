package com.example.activitatgooglemaps;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnMapa = findViewById(R.id.btnMapa);
        Button btnLlista = findViewById(R.id.btnLlista);
        btnMapa.setOnClickListener(v->ObrirMapa());
        btnLlista.setOnClickListener(v->ObrirLlista());
    }

    public void ObrirMapa()
    {
        startActivity(new Intent(MainActivity.this, MapsActivity.class));
    }

    public void ObrirLlista()
    {
        startActivity(new Intent(MainActivity.this, LlistatGira.class));
    }
}