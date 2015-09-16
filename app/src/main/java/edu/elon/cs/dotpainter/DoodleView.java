package edu.elon.cs.dotpainter;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;

/**
 * Created by Mitch on 9/3/2015.
 */
public class DoodleView extends View {

    public final static int DEFAULT_WIDTH = 50;

    private ArrayList<Dot> theDots;
    private int theWidth = DEFAULT_WIDTH;

    public DoodleView(Context context, AttributeSet attrs) {
        super(context, attrs);

        theDots = new ArrayList<Dot>();
    }

    public int getTheWidth(){
        return theWidth;
    }

    public void setPenWidth(){
        this.theWidth = theWidth;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event){
        Dot dot = new Dot(event.getX(), event.getY(), theWidth);
        theDots.add(dot);

        return true;
    }

    @Override
    protected void onDraw(Canvas canvas){

        for (Dot dot : theDots){
            dot.draw(canvas);
        }
        invalidate();
    }
}
