package com.example.antisaby.canvastest;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class CustomSurfaceView extends SurfaceView implements Runnable
{
    private SurfaceHolder mSurfaceHolder;
    private Paint mPaint;
    private boolean mRunning;
    private Thread mThread;
    private Bitmap mBitmap;
    private Canvas mCanvas;
    private float mX, mY;

    public CustomSurfaceView(Context context)
    {
        super(context);
        mSurfaceHolder = getHolder();
        mPaint = new Paint();
        mPaint.setColor(Color.DKGRAY);
        mBitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.android);

        mX = 100;
        mY = 100;
    }

    @Override
    public void run()
    {
        while (mRunning)
        {
            if (mSurfaceHolder.getSurface().isValid())
            {
                {
                    mCanvas = mSurfaceHolder.lockCanvas();
                    mCanvas.save();
                    mCanvas.drawColor(Color.WHITE);
                    mCanvas.drawBitmap(mBitmap, mX, mY, mPaint);
                    mCanvas.restore();
                    mSurfaceHolder.unlockCanvasAndPost(mCanvas);
                }
            }
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event)
    {
        switch (event.getAction())
        {
            case MotionEvent.ACTION_DOWN:
                mX = event.getX();
                mY = event.getY();
                invalidate();
                break;
            case MotionEvent.ACTION_MOVE:
                mX = event.getX();
                mY = event.getY();
                invalidate();
                break;
        }
        return true;
    }

    public void pause()
    {
        mRunning = false;
        try
        {
            mThread.join();
        }
        catch (InterruptedException e)
        {
        }
    }

    public void resume()
    {
        mRunning = true;
        mThread = new Thread(this);
        mThread.start();
    }
}
