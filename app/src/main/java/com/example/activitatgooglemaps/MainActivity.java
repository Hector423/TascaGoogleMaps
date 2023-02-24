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

        MusicHolder.UpdateContext(MainActivity.this);

        Button btnMapa = findViewById(R.id.btnMapa);
        Button btnLlista = findViewById(R.id.btnLlista);
        Button btnPause = findViewById(R.id.btnPause);
        btnMapa  .setOnClickListener(v -> startActivity(new Intent(MainActivity.this, MapsActivity.class)));
        btnLlista.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, LlistatGira.class)));
        btnPause .setOnClickListener(v -> MusicHolder.Pause());
    }
}