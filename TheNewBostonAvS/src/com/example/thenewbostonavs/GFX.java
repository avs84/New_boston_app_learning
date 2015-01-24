package com.example.thenewbostonavs;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.PowerManager;

/**
 * Created by aschuijlenborgh on 7-12-14.
 */
public class GFX extends Activity {

    MyBringBack ourView;
    PowerManager.WakeLock wL;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //wakelock
        PowerManager pM = (PowerManager)getSystemService(Context.POWER_SERVICE);
               wL = pM.newWakeLock(PowerManager.FULL_WAKE_LOCK, " whatever");

        super.onCreate(savedInstanceState);

        ourView = new MyBringBack(this);

        setContentView(ourView);

    }

    @Override
    protected void onPause() {
        super.onPause();

        wL.release();
    }
}
