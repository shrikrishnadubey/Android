package com.example.akashsingh.customdrawing;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

/**
 * Created by AKASH SINGH on 01-Feb-18.
 */

public class ViewClass extends SurfaceView {
    Context ct;
    Canvas c;
    SurfaceHolder sh;

    public ViewClass(Context context) {
        super(context);
        ct=context;
        sh=getHolder();
        sh.addCallback(new SurfaceHolder.Callback() {
            @SuppressLint("WrongCall")
            @Override
            public void surfaceCreated(SurfaceHolder holder) {
                c=sh.lockCanvas();
                onDraw(c);
                sh.unlockCanvasAndPost(c);
            }

            @Override
            public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
            }

            @Override
            public void surfaceDestroyed(SurfaceHolder holder) {

            }
        });
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Paint p=new Paint();
//        p.setColor(Color.RED);
//        p.setTextSize(100f);
//        canvas.drawText("Hello",100,100,p);
//        p.setColor(Color.YELLOW);
//        canvas.drawCircle(450,500,100,p);
//        p.setColor(Color.CYAN);
//        float f[]={0,0,200,0,200,0,100,100,100,100,0,0};
//        canvas.drawLines(f,p);
//        RectF r=new RectF(0,100,200,200);
//        canvas.drawOval(r,p);
//        Rect rr=new Rect(0,0,100,100);
//        canvas.drawRect(rr,p);
        p.setColor(Color.RED);
        Rect r=new Rect(50,50,150,800);
        canvas.drawRect(r,p);
        Rect r1=new Rect(50,650,450,800);
        canvas.drawRect(r1,p);
        Rect r2=new Rect(500,50,600,800);
        canvas.drawRect(r2,p);
        RectF r3=new RectF(500,50,750,400);
        canvas.drawOval(r3,p);
        Rect r4=new Rect(800,50,850,800);
        canvas.drawRect(r4,p);
        Rect r5=new Rect(800,650,980,800);
        canvas.drawRect(r5,p);
        Rect r6=new Rect(980,50,1020,800);
        canvas.drawRect(r6,p);
//        Rect rr=new Rect(200,600,100,800);
//        canvas.drawRect(rr,p);
//
//        Rect rr1=new Rect(800,800,50,0);
//        canvas.drawRect(rr1,p);
}
}
