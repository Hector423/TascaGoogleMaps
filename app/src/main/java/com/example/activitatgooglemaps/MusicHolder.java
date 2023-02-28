package com.example.activitatgooglemaps;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.media.SoundPool;
import androidx.fragment.app.FragmentActivity;

import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.example.activitatgooglemaps.databinding.ActivityMapsBinding;

public class MusicHolder
{
    public static MediaPlayer mediaPlayer;

    @SuppressLint("StaticFieldLeak")
    private static Context currentContext;

    private static boolean preferences = false;

    public static boolean musicRunning = false;

    public static void ForceStart()
    {
        musicRunning = false;
        Terminate();
        mediaPlayer = null;
        Start();
    }

    public static void ForceStop()
    {
        musicRunning = false;
        Terminate();
        mediaPlayer = null;
    }

    public static void Prepare()
    {
        ForceStop();
        musicRunning = false;
        mediaPlayer = MediaPlayer.create(currentContext, R.raw.musica_mapa);
    }

    public static void Start()
    {
        if(!musicRunning)
        {
            musicRunning = true;
            if(mediaPlayer==null) mediaPlayer = MediaPlayer.create(currentContext, R.raw.musica_mapa);
            mediaPlayer.start();
        }
    }

    public static boolean isPlaying()
    {
        return mediaPlayer != null && mediaPlayer.isPlaying();
    }

    public static void Pause()
    {
        musicRunning = false;
        if(mediaPlayer!=null) mediaPlayer.pause();
    }

    public static void PausePreferences(boolean sharedPreferences)
    {
    }

    public static void Terminate()
    {
        mediaPlayer.release();
    }

    public static void UpdateContext(Context newContext)
    {
        currentContext = newContext;
    }

    public static boolean isInitialized()
    {
        return mediaPlayer != null;
    }
}