package com.example.activitatgooglemaps;

import android.content.Context;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.Toast;

import androidx.annotation.NonNull;

public class MyGestureListener extends GestureDetector.SimpleOnGestureListener
{
    private Context context;
    private int fingersDown = 0;

    public MyGestureListener(Context context)
    {
        this.context = context;
    }

    /**
     * @param e The down motion event
     */
    @Override
    public void onShowPress(@NonNull MotionEvent e)
    {
//        super.onShowPress(e);
        if(fingersDown==3)
        {
            // Trigger the three-fingers-down gesture
            Toast.makeText(context/*getApplicationContext()*/, "Three fingers down", Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * @param e The down motion event.
     * @return
     */
    @Override
    public boolean onDown(@NonNull MotionEvent e)
    {
//        return super.onDown(e);
        fingersDown = e.getPointerCount();
        return true;
    }
}