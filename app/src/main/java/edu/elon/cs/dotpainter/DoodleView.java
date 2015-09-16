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


    public static final int DEFAULT_COLOR_VALUE = 0;
    public static final int DEFAULT_ALPHA_VALUE = 20;

    private int theRed = DEFAULT_COLOR_VALUE;
    private int theGreen = DEFAULT_COLOR_VALUE;
    private int theBlue = DEFAULT_COLOR_VALUE;
    private int theAlpha = DEFAULT_ALPHA_VALUE;

    private ArrayList<Line> theLines;


    public DoodleView(Context context, AttributeSet attrs) {
        super(context, attrs);

        theLines = new ArrayList<Line>();
    }

    public int getTheRed(){
        return theRed;
    }
    public int getTheBlue(){
        return theBlue;
    }
    public int getTheGreen(){
        return theGreen;
    }
    public int getTheAlpha(){
        return theAlpha;
    }

    public void setPenColor(int theRed, int theBlue, int theGreen, int theAlpha){
        this.theRed = theRed;
        this.theBlue = theBlue;
        this.theGreen = theGreen;
        this.theAlpha = theAlpha;
    }

    public void clearView(){
        theLines = new ArrayList<Line>();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event){
        int historySize = event.getHistorySize();
        if(historySize > 0) {
            int lastX = (int) event.getHistoricalX(historySize - 1);
            int lastY = (int) event.getHistoricalY(historySize- 1);
            Line line = new Line(lastX, lastY, event.getX(), event.getY(), theRed, theBlue, theGreen, theAlpha);
            theLines.add(line);
        }
        else if (event.getAction() == MotionEvent.ACTION_UP){
            Line line = new Line(event.getX(), event.getY() - 1, event.getX(), event.getY(), theRed, theBlue, theGreen, theAlpha);
        }
        else if(event.getAction() == MotionEvent.ACTION_DOWN){
            Line line = new Line(event.getX(), event.getY() + 1, event.getX(), event.getY(), theRed, theBlue, theGreen, theAlpha);
        }
        else if(event.getAction() == MotionEvent.ACTION_MOVE){
            Line line = new Line(event.getX() - 1, event.getY() - 1, event.getX(), event.getY(), theRed, theBlue, theGreen, theAlpha);
        }


        return true;
    }

    @Override
    protected void onDraw(Canvas canvas){

        for (Line line : theLines){
            line.draw(canvas);
        }
        invalidate();
    }
}
