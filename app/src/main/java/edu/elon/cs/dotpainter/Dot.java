package edu.elon.cs.dotpainter;

import android.graphics.Canvas;
import android.graphics.Paint;

/**
 * Created by Mitch on 9/3/2015.
 */
public class Dot {


    private int theWidth;
    private float x, y;
    private Paint paint;

    public Dot(float x, float y, int theWidth){
        this.x = x;
        this.y = y;
        this.theWidth = theWidth;

        //random paint color!
        paint = new Paint();
        int red = (int) (Math.random() * 256);
        int green = (int) (Math.random() * 256);
        int blue = (int) (Math.random() * 256);
        int alpha = (int) (Math.random() * 256);
        paint.setARGB(alpha, red, green, blue);
    }

    public void draw(Canvas canvas){
        canvas.drawCircle(x, y, theWidth, paint);
    }

}
