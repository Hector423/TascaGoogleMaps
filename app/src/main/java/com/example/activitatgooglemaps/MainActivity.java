package com.example.activitatgooglemaps;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.widget.Button;

public class MainActivity extends AppCompatActivity
{

    boolean isMusicPlaying;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        MusicHolder.UpdateContext(MainActivity.this);
        isMusicPlaying = MusicHolder.isPlaying();
        cargarPreferencies();
        Button btnMapa = findViewById(R.id.btnMapa);
        Button btnLlista = findViewById(R.id.btnLlista);
        Button btnPause = findViewById(R.id.btnPause);
        Button btnPreferencies = findViewById(R.id.botoPreferencies);
        btnMapa  .setOnClickListener(v -> startActivity(new Intent(MainActivity.this, MapsActivity.class)));
        btnLlista.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, LlistatGira.class)));
        btnPause .setOnClickListener(v -> MusicHolder.Pause());
        btnPreferencies.setOnClickListener(v-> startActivity(new Intent(MainActivity.this, Preferencies.class)));

    }

    public void cargarPreferencies(){
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        MusicHolder.PausePreferences(sharedPreferences.getBoolean("Musica habilitada: ", false));
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putBoolean("isMusicPlaying", isMusicPlaying);
    }
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        isMusicPlaying = savedInstanceState.getBoolean("isMusicPlaying");
    }
    protected void onPause() {
        super.onPause();
        MusicHolder.Pause();
    }


}