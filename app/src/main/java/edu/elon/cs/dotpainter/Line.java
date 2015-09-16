package edu.elon.cs.dotpainter;

import android.graphics.Canvas;
import android.graphics.Paint;

/**
 * Created by Mitch on 9/16/2015.
 */
public class Line {
    private float x, y, x1, y1;
    private int red, green, blue, alpha;
    private Paint paint;


    //I screwed up and made alpha instead of width, but didn't want to change the wording. therefore,
    //paint.setARGB uses 255 as alpha value but the "alpha" is treated as width.
    public Line(float x, float y, float x1, float y1, int red, int green, int blue, int alpha){
        this.x = x;
        this.y = y;
        this.x1 = x1;
        this.y1 = y1;
        this.red = red;
        this.green = green;
        this.blue = blue;
        this.alpha = alpha;
        paint = new Paint();
        paint.setARGB(255, red, green, blue);
        paint.setStrokeWidth((float) alpha);
        paint.setStrokeCap(Paint.Cap.ROUND);
    }

    public void draw(Canvas canvas){
        canvas.drawLine(x, y, x1, y1, paint);
    }


}
