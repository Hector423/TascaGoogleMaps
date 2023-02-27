package com.example.activitatgooglemaps;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.preference.PreferenceManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener
{
    public Button btnPause;
    public Button btnResume;
    private GestureDetector gestureDetector;
    View.OnTouchListener gestureListener;
    boolean isMusicPlaying;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MyGestureListener gestureListener = new MyGestureListener(this);

        gestureDetector = new GestureDetector(new MyGestureDetector(this));
        gestureListener = new MyGestureListener(this)
        {
            public boolean onTouch(View v, MotionEvent event)
            {
                return gestureDetector.onTouchEvent(event);
            }
        };

        cargarPreferencies();
        MusicHolder.UpdateContext(MainActivity.this);

        Button btnMapa   = findViewById(R.id.btnMapa);
        Button btnLlista = findViewById(R.id.btnLlista);
        btnPause  = findViewById(R.id.btnPause);
        btnResume = findViewById(R.id.btnResume);
        btnPause .setVisibility(View.GONE);
        btnResume.setVisibility(View.GONE);

        ImageButton btnImgPref   = findViewById(R.id.btnImgPref);
        ImageButton btnImgMusica = findViewById(R.id.btnImgMusica);
        ImageButton btnImgTancar = findViewById(R.id.btnImgTancar);

        btnMapa     .setOnClickListener(v -> startActivity(new Intent(MainActivity.this, MapsActivity.class)));
        btnLlista   .setOnClickListener(v -> startActivity(new Intent(MainActivity.this, LlistatGira.class)));
        btnImgPref  .setOnClickListener(v -> startActivity(new Intent(MainActivity.this, Preferencies.class)));
        btnImgMusica.setOnClickListener(v -> FlipMusic());
        btnImgTancar.setOnClickListener(v -> FinishApp());
    }

    private void FlipMusic()
    {
        if(MusicHolder.musicRunning)
        {
            if(MusicHolder.isInitialized()) MusicHolder.Pause();
        }
        else
        {
            if(MusicHolder.isInitialized()) MusicHolder.Start();
        }
    }

    private void FinishApp()
    {
        MusicHolder.ForceStop();
        MusicHolder.Terminate();
        finishAffinity();
    }

    public void ObrirMapa()
    {
        startActivity(new Intent(MainActivity.this, MapsActivity.class));
    }

    public void ObrirLlista()
    {
        startActivity(new Intent(MainActivity.this, LlistatGira.class));
    }

    @Override
    public boolean onTouchEvent(MotionEvent event)
    {
        return gestureDetector.onTouchEvent(event);
    }

    public void UpdateButtonState()
    {
        if(MusicHolder.musicRunning)
        {
            if(MusicHolder.isInitialized())
            {
                btnPause.setVisibility(View.VISIBLE);
                btnResume.setVisibility(View.GONE);
            }
        }
        else
        {
            if(MusicHolder.isInitialized())
            {
                btnPause.setVisibility(View.GONE);
                btnResume.setVisibility(View.VISIBLE);
            }
        }
    }
    public void cargarPreferencies()
    {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        MusicHolder.PausePreferences(sharedPreferences.getBoolean("Musica habilitada: ", false));
    }
    @Override
    protected void onSaveInstanceState(Bundle outState)
    {
        super.onSaveInstanceState(outState);
        outState.putBoolean("isMusicPlaying", isMusicPlaying);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState)
    {
        super.onRestoreInstanceState(savedInstanceState);
        isMusicPlaying = savedInstanceState.getBoolean("isMusicPlaying");
    }

    protected void onPause()
    {
        super.onPause();
        MusicHolder.Pause();
    }

    /**
     * Called when a view has been clicked.
     *
     * @param v The view that was clicked.
     */
    @Override
    public void onClick(View v)
    {

    }

    /**
     * Called when pointer capture is enabled or disabled for the current window.
     *
     * @param hasCapture True if the window has pointer capture.
     */
    @Override
    public void onPointerCaptureChanged(boolean hasCapture)
    {
        super.onPointerCaptureChanged(hasCapture);
    }

    private class MyGestureDetector extends GestureDetector.SimpleOnGestureListener
    {
        Context context;

        public MyGestureDetector(Context mainActivity)
        {
            context = mainActivity;
        }

        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY)
        {
            try
            {
                if(Math.abs(e1.getY()-e2.getY())>250 && Math.abs(velocityY)>200)
                {
                    System.out.println("Down");
                    if(MusicHolder.musicRunning)
                    {
                        if(MusicHolder.isInitialized()) MusicHolder.Pause();
                    }
                    else
                    {
                        if(MusicHolder.isInitialized()) MusicHolder.Start();
                    }
                }
                else if(Math.abs(e2.getY()-e1.getY())>250 && Math.abs(velocityY)>200) System.out.println("Up");
                else if(e1.getX()-e2.getX()>120 && Math.abs(velocityX)>200)
                {
                    System.out.println("Left");
                    ObrirMapa();
                }
                else if(e2.getX()-e1.getX()>120 && Math.abs(velocityX)>200)
                {
                    System.out.println("Right");
                    ObrirLlista();
                }
            }
            catch(Exception ignored) { }
            return false;
        }
    }
}