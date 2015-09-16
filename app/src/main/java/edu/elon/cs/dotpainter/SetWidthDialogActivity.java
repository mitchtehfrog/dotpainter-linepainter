package edu.elon.cs.dotpainter;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.SeekBar;
/**
 * Created by Mitch on 9/3/2015.
 */
public class SetWidthDialogActivity extends Activity {

    private SeekBar redSeekBar;
    private SeekBar greenSeekBar;
    private SeekBar blueSeekBar;
    private SeekBar alphaSeekBar;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_width_dialog);

        Intent data = getIntent();
        int red = data.getIntExtra("red", DoodleView.DEFAULT_COLOR_VALUE);
        int green = data.getIntExtra("green", DoodleView.DEFAULT_COLOR_VALUE);
        int blue = data.getIntExtra("blue", DoodleView.DEFAULT_COLOR_VALUE);
        int alpha = data.getIntExtra("alpha", DoodleView.DEFAULT_ALPHA_VALUE);

        redSeekBar = (SeekBar) findViewById(R.id.red_seekbar);
        greenSeekBar = (SeekBar) findViewById(R.id.green_seekbar);
        blueSeekBar = (SeekBar) findViewById(R.id.blue_seekbar);
        alphaSeekBar = (SeekBar) findViewById(R.id.alpha_seekbar);
        redSeekBar.setProgress(DoodleView.DEFAULT_COLOR_VALUE);
        greenSeekBar.setProgress(DoodleView.DEFAULT_COLOR_VALUE);
        blueSeekBar.setProgress(DoodleView.DEFAULT_COLOR_VALUE);
        alphaSeekBar.setProgress(DoodleView.DEFAULT_ALPHA_VALUE);

        redSeekBar = (SeekBar) findViewById(R.id.red_seekbar);
        greenSeekBar = (SeekBar) findViewById(R.id.green_seekbar);
        blueSeekBar = (SeekBar) findViewById(R.id.blue_seekbar);
        alphaSeekBar = (SeekBar) findViewById(R.id.alpha_seekbar);
        redSeekBar.setProgress(red);
        greenSeekBar.setProgress(green);
        blueSeekBar.setProgress(blue);
        alphaSeekBar.setProgress(alpha);
        redSeekBar.setOnSeekBarChangeListener(seekBarListener);
        blueSeekBar.setOnSeekBarChangeListener(seekBarListener);
        greenSeekBar.setOnSeekBarChangeListener(seekBarListener);
        alphaSeekBar.setOnSeekBarChangeListener(seekBarListener);
        imageView = (ImageView) findViewById(R.id.imageview);
        updateImageView();
    }


    public void onOKClick(View view) {
        // send back the new width size and color
        Intent data = new Intent();
        data.putExtra("red", redSeekBar.getProgress());
        data.putExtra("green", greenSeekBar.getProgress());
        data.putExtra("blue", blueSeekBar.getProgress());
        data.putExtra("alpha", alphaSeekBar.getProgress());
        setResult(RESULT_OK, data);
        finish();
    }
    void updateImageView() {
        Paint p = new Paint();
        p.setARGB(255, redSeekBar.getProgress(), greenSeekBar.getProgress(), blueSeekBar.getProgress());
        p.setStrokeWidth(alphaSeekBar.getProgress());
        Bitmap bitmap = Bitmap.createBitmap(250, 250, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        canvas.drawRect(200, 200, 100, 100, p);
        imageView.setImageBitmap(bitmap);
    }

    SeekBar.OnSeekBarChangeListener seekBarListener =
            new SeekBar.OnSeekBarChangeListener() {
                @Override
                public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                    updateImageView();
                }

                @Override
                public void onStartTrackingTouch(SeekBar seekBar) {

                }

                @Override
                public void onStopTrackingTouch(SeekBar seekBar) {

                }
            };

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_set_width_dialog, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
