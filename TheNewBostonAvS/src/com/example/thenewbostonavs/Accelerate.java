package com.example.thenewbostonavs;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

/**
 * Created by AvanSchuijlenborgh on 29-1-2015.
 */
public class Accelerate extends Activity implements SensorEventListener {


    MyBringBackSurface ourSurfaceView;
    float x, y, senX, senY;
    Bitmap ball, plus;
    SensorManager sm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initialize();


    }

    private void initialize() {
        ourSurfaceView = new MyBringBackSurface(this);
        ourSurfaceView.resume();
        setContentView(new MyBringBackSurface(this));

        sm = (SensorManager) getSystemService(Context.SENSOR_SERVICE);

        if (sm.getSensorList(Sensor.TYPE_ACCELEROMETER).size() !=0){

            Sensor s = sm.getSensorList(Sensor.TYPE_ACCELEROMETER).get(0);

            sm.registerListener(this, s, SensorManager.SENSOR_DELAY_NORMAL);
        }

        x = y = senX = senY = 0;
        ball = BitmapFactory.decodeResource(getResources(), R.drawable.greenball);
        plus = BitmapFactory.decodeResource(getResources(), R.drawable.plus);


    }

    @Override
    public void onSensorChanged(SensorEvent e) {

        // delay it a bit
        try {
            Thread.sleep(16);
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }

        senX = e.values[0];
        senY = e.values[1];

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }


    public class MyBringBackSurface extends SurfaceView implements Runnable {

        SurfaceHolder ourHolder;
        Thread ourThread = null;
        boolean isRunning = false;

        public MyBringBackSurface(Context context) {
            super(context);

            ourHolder = getHolder();

        }



        public void pause() {

            isRunning = false;
            while (true){
                try {
                    ourThread.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                break;
            }
            ourThread = null;

        }

        public void resume(){

            isRunning = true;
            ourThread = new Thread(this);
            ourThread.start();

        }

        @Override
        public void run() {

            while (isRunning) {
                if (!ourHolder.getSurface().isValid()) {
                    continue;
                }

                Canvas canvas = ourHolder.lockCanvas();

                canvas.drawRGB(02, 02, 150);
                float centerX = canvas.getHeight()/2;
                float centerY = canvas.getWidth()/2;
                canvas.drawBitmap(ball, centerX + senX*20, centerY+ senY*20, null);


                ourHolder.unlockCanvasAndPost(canvas);

            }


        }
    }

    @Override
    protected void onPause() {
        super.onPause();

        sm.unregisterListener(this);
    }
}
