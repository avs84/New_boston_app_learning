package com.example.thenewbostonavs;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.ViewFlipper;

/**
 * Created by aschuijlenborgh on 24-1-15.
 */
public class Flipper extends Activity implements View.OnClickListener {

    TextView flipper1, flipper2, flipper3;
    Button button;
    ViewFlipper flippy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.flipper);

        initialise();



    }

    private void initialise() {

        flipper1 = (TextView) findViewById(R.id.tvFlipper1);
        flipper2 = (TextView) findViewById(R.id.tvFlipper2);
        flipper3 = (TextView) findViewById(R.id.tvFlipper3);
        button = (Button) findViewById(R.id.bFlipper);
        flippy = (ViewFlipper) findViewById(R.id.viewFlipper);

        button.setOnClickListener(this);
        flippy.setOnClickListener(this);
        flippy.setFlipInterval(500);
        flippy.startFlipping();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bFlipper:

                break;

            case R.id.viewFlipper:
                flippy.showNext();
                break;

        }


    }
}
