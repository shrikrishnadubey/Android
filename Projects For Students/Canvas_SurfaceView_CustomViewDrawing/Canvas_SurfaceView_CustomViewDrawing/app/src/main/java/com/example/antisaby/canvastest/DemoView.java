package com.example.antisaby.canvastest;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

public class DemoView extends View
{
    public DemoView(Context context)
    {
        super(context);
    }

    @Override protected void onDraw(Canvas canvas)
    {
        super.onDraw(canvas);

        // custom drawing code here
        Paint paint = new Paint();
        paint.setStyle(Paint.Style.FILL);

        // make the entire canvas white
        paint.setColor(Color.WHITE);
        canvas.drawPaint(paint);

        // draw blue circle
        paint.setColor(Color.BLUE);
        canvas.drawCircle(20, 20, 15, paint);

        // draw green circle
        paint.setColor(Color.GREEN);
        canvas.drawCircle(60, 20, 15, paint);

        // draw red rectangle
        paint.setColor(Color.RED);
        canvas.drawRect(100, 5, 200, 30, paint);
        canvas.drawText("Graphics Rotation", 40, 180, paint);
    }
}