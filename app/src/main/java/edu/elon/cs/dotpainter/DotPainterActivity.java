package edu.elon.cs.dotpainter;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
/**
 * Created by Mitch on 9/3/2015.
 */
public class DotPainterActivity extends Activity {

    public final static int WIDTH_DIALOG = 1;

    private DoodleView doodleView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dot_painter);

        doodleView = (DoodleView) findViewById(R.id.doodleview);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_dot_painter, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_setwidth) {
            Intent intent = new Intent(this, SetWidthDialogActivity.class);
            intent.putExtra("red", doodleView.getTheRed());
            intent.putExtra("blue", doodleView.getTheBlue());
            intent.putExtra("green", doodleView.getTheBlue());
            intent.putExtra("alpha", doodleView.getTheAlpha());
            startActivityForResult(intent, WIDTH_DIALOG);

        }

        return super.onOptionsItemSelected(item);
    }

    public void clearScreen(View view){
         doodleView.clearView();

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == WIDTH_DIALOG) {
            if (resultCode == RESULT_OK) {
                // get the new pen width/color and tell the DoodleView
                int red = data.getIntExtra("red", doodleView.getTheRed());
                int green = data.getIntExtra("green", doodleView.getTheGreen());
                int blue = data.getIntExtra("blue", doodleView.getTheBlue());
                int alpha = data.getIntExtra("alpha", doodleView.getTheAlpha());
                doodleView.setPenColor(red, green, blue, alpha);
            }
        }
    }
    }