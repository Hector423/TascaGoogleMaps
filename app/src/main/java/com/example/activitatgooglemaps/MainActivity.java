package com.example.activitatgooglemaps;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener
{
//    private static final int 120 = 120;
//    private static final int 250 = 250;
//    private static final int 200 = 200;
    public Button btnPause;
    public Button btnResume;
    private GestureDetector gestureDetector;
    View.OnTouchListener gestureListener;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Create instance of gesture listener class
        MyGestureListener gestureListener = new MyGestureListener(this);

        // Create instance of gesture detector class
//        gestureDetector = new GestureDetector(this, gestureListener);
        // Gesture detection
        gestureDetector = new GestureDetector(new MyGestureDetector(this));
        gestureListener = new MyGestureListener(this)
        {
            public boolean onTouch(View v, MotionEvent event)
            {
                return gestureDetector.onTouchEvent(event);
            }
        };

//        gestureDetector.setListener(new MyGestureDetector.Listener()
//        {
//            @Override
//            public void onInterestingEvent()
//            {
//                UpdateButtonState();
//            }
//        });

        MusicHolder.UpdateContext(MainActivity.this);

        Button btnMapa   = findViewById(R.id.btnMapa);
        Button btnLlista = findViewById(R.id.btnLlista);
        btnPause  = findViewById(R.id.btnPause);
        btnResume = findViewById(R.id.btnResume);

        btnPause .setVisibility(View.VISIBLE);
        btnResume.setVisibility(View.GONE);

        btnMapa  .setOnClickListener(v -> startActivity(new Intent(MainActivity.this, MapsActivity.class)));
        btnLlista.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, LlistatGira.class)));
        btnPause .setOnClickListener(v -> { if(MusicHolder.isInitialized()) { btnPause.setVisibility(View.GONE); btnResume.setVisibility(View.VISIBLE); MusicHolder.Pause(); }});
        btnResume.setOnClickListener(v -> { if(MusicHolder.isInitialized()) { btnPause.setVisibility(View.VISIBLE); btnResume.setVisibility(View.GONE); MusicHolder.Start(); }});
    }

    @Override
    public boolean onTouchEvent(MotionEvent event)
    {
        // Pass touch event to gesture detector
        return gestureDetector.onTouchEvent(event);
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

    public void UpdateButtonState()
    {
        if(MusicHolder.musicRunning)
        {
            if(MusicHolder.isInitialized())
            {
                    btnPause.setVisibility(View.VISIBLE);
                    btnResume.setVisibility(View.GONE);
//                MusicHolder.Pause();
            }
        }
        else
        {
            if(MusicHolder.isInitialized())
            {
                    btnPause.setVisibility(View.GONE);
                    btnResume.setVisibility(View.VISIBLE);
//                MusicHolder.Start();
            }
        }
    }
}

class MyGestureDetector extends GestureDetector.SimpleOnGestureListener
{
    Context context;
    Listener listener;

    public interface Listener
    {
        public void onInterestingEvent();
    }

    public void setListener(Listener listener)
    {
        this.listener = listener;
    }

    public MyGestureDetector(Context mainActivity)
    {
        context = mainActivity;
    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY)
    {
        try
        {
            if(Math.abs(e1.getY() - e2.getY()) > 250 && Math.abs(velocityY) > 200)
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
            else if(Math.abs(e2.getY()-e1.getY())>250 && Math.abs(velocityY)>200)
            {
                System.out.println("Up");
            }
            else if(e1.getX()-e2.getX()>120 && Math.abs(velocityX)>200)
            {
                System.out.println("Left");
                if(MusicHolder.isInitialized()) MusicHolder.Pause();
            }
            else if(e2.getX()-e1.getX()>120 && Math.abs(velocityX)>200)
            {
                System.out.println("Right");
                if(MusicHolder.isInitialized()) MusicHolder.Start();
            }
        }
        catch(Exception ignored) { }
        return false;
    }
}