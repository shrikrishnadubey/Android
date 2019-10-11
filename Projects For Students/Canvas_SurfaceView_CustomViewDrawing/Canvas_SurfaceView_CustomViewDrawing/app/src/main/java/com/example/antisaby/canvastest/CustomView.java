package com.example.antisaby.canvastest;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

/**
 * Created by USER on 05-Sep-18.
 */

public class CustomView extends View
{
    Paint p;
    Path mpath;

    public CustomView(Context context)
    {
        super(context);
        init();
    }

    public CustomView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init()
    {
        p = new Paint(Paint.ANTI_ALIAS_FLAG);
        mpath = new Path();
        p.setColor(Color.GREEN);
        p.setStyle(Style.STROKE);
        p.setStrokeWidth(10f);

    }

    @Override
    protected void onDraw(Canvas canvas) {

        canvas.drawColor(Color.YELLOW);

        canvas.drawPath(mpath,p);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        switch (event.getAction())
        {
            case MotionEvent.ACTION_DOWN:
                mpath.moveTo(event.getX(), event.getY());
                break;
            case MotionEvent.ACTION_MOVE:
                mpath.lineTo(event.getX(), event.getY());
                break;
        }
        invalidate();
        return true;
    }
}
