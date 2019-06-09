package com.ebookfrenzy.mycustomdrwaing;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

/**
 * Created by subhita.menon on 02/02/2018.
 */

public class pict extends SurfaceView {
    SurfaceHolder sh;
    Bitmap bp, bg2, cr1;


    public pict(Context context) {
        super(context);
        sh = getHolder();

        sh.addCallback(new SurfaceHolder.Callback() {
            @SuppressLint("WrongCall")
            @Override
            public void surfaceCreated(SurfaceHolder surfaceHolder) {
                Canvas c = sh.lockCanvas();
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

         bp = BitmapFactory.decodeResource(getResources(), R.drawable.mario);
        bg2 = BitmapFactory.decodeResource(getResources(), R.drawable.backgroung2);
        cr1 = BitmapFactory.decodeResource(getResources(), R.drawable.crow1);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Rect r1 = new Rect(0, 0, bg2.getWidth(), bg2.getHeight());
        Rect r2 = new Rect(0, 0, canvas.getWidth(), canvas.getHeight());

        canvas.drawBitmap(bg2, r1, r2, null);




        canvas.drawBitmap(bp, 0, canvas.getHeight()-bp.getHeight(), null);




    }

}
