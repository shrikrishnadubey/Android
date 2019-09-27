package com.ebookfrenzy.mycustomdrwaing;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class ViewClass  extends SurfaceView {
    Context ct;
    Canvas c;
    SurfaceHolder sh;
    public ViewClass(Context context) {
        super(context);
        ct= context;

        sh = getHolder();
        sh.addCallback(new SurfaceHolder.Callback() {
            @SuppressLint("WrongCall")
            @Override
            public void surfaceCreated(SurfaceHolder surfaceHolder) {

                c = sh.lockCanvas();
                onDraw(c);

                sh.unlockCanvasAndPost(c);

            }

            @Override
            public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i1, int i2) {

            }

            @Override
            public void surfaceDestroyed(SurfaceHolder surfaceHolder) {

            }
        });


    }

    @Override
    protected void onDraw(Canvas canvas) {

        Paint p = new Paint();
        p.setColor(Color.RED);
        p.setTextSize(100f);
        canvas.drawText("Hello",100,100,p);
        p.setColor(Color.YELLOW);

        canvas.drawCircle(450,500,100,p);
        p.setColor(Color.CYAN);

       // float [] f = {0,0,200,0,200,0,100,100,100,100,0,0};
        //canvas.drawLines(f,p);
        //RectF r=new RectF(540,100,200,200);

        //canvas.drawOval(r,p);
        Rect rr=new Rect(0,0,100,100);
canvas.drawRect(rr,p);

p.setColor(Color.GREEN);


        Rect rrrr=new Rect(0,50,100,250);
        canvas.drawRect(rrrr,p);
        p.setColor(Color.CYAN);
        Rect rrrrr=new Rect(200,150,250,150);
        canvas.drawRect(rrrrr,p);


    }
}
