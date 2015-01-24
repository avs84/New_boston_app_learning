package com.example.thenewbostonavs;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.SlidingDrawer;

/**
 * Created by aschuijlenborgh on 24-1-15.
 */

public class Slider extends Activity implements View.OnClickListener,
                                                CompoundButton.OnCheckedChangeListener,
                                                SlidingDrawer.OnDrawerOpenListener,
                                                SlidingDrawer.OnDrawerCloseListener {

    SlidingDrawer sd;
    MediaPlayer mp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sliding);


        Button handle1 = (Button) findViewById(R.id.handle1);
        Button handle2 = (Button) findViewById(R.id.handle2);
        Button handle3 = (Button) findViewById(R.id.handle3);
        Button handle4 = (Button) findViewById(R.id.handle4);
        CheckBox checkbox = (CheckBox) findViewById(R.id.cbSlidable);

        checkbox.setOnCheckedChangeListener(this);
        handle1.setOnClickListener(this);
        handle2.setOnClickListener(this);
        handle3.setOnClickListener(this);
        handle4.setOnClickListener(this);

        // SlidingDrawer
        sd = (SlidingDrawer) findViewById(R.id.slidingD);
        sd.setOnDrawerOpenListener(this);
        sd.setOnDrawerCloseListener(this);
        //end SlidingDrawer


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.handle1:
                sd.open();

                break;

            case R.id.handle2:

                break;

            case R.id.handle3:
                sd.toggle();
                break;

            case R.id.handle4:
                sd.close();
                break;


            }

        }

    @Override
    public void onCheckedChanged(CompoundButton arg0, boolean arg1) {

        if (arg0.isChecked()){
            sd.lock();

        }else {
            sd.unlock();

        }
    }

    @Override
    public void onDrawerOpened() {
        mp = MediaPlayer.create(this, R.raw.leanback);
        mp.start();
    }

    @Override
    public void onDrawerClosed() {
        mp.release();

    }
}

