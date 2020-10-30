package com.example.rocket;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;

public class Rocket {
    public float x, y;
    public float vx, vy;
    Paint paint;
    Bitmap image;
    public Rocket(float x, float y, float vx, float vy,
                  Paint paint, int imageID, Resources resources) {
        this.x = x;
        this.y = y;
        this.vx = vx;
        this.vy = vy;
        this.paint = paint;
        this.image = BitmapFactory.decodeResource(resources, imageID);
    }

    public void update(Canvas canvas) {
        x += vx;
        y += vy;
        draw(canvas);
    }


    public void draw(Canvas canvas)
    {
        Matrix matrix = new Matrix();
        matrix.setScale(0.2f, 0.2f);
        matrix.postRotate((float)Math.toDegrees(Math.atan2(vy, vx)) + 45);
        matrix.postTranslate(x, y);
        paint.setAlpha(255);
        canvas.drawBitmap(image, matrix, paint);
    }
}
