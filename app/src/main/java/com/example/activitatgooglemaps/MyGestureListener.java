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
        // Trigger the three-fingers-down gesture
        if(fingersDown==3) Toast.makeText(context, "Three fingers down", Toast.LENGTH_SHORT).show();
    }

    /**
     * @return
     */
    @Override
    public boolean onDown(MotionEvent event)
    {
        fingersDown = event.getPointerCount();
        return true;
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY)
    {
        // Trigger three-fingers-down scrolling gesture
        if(fingersDown==3 && distanceY<0) Toast.makeText(context, "SCROLL DOWN!", Toast.LENGTH_SHORT).show();
        return super.onScroll(e1, e2, distanceX, distanceY);
    }
}