package com.example.thenewbostonavs;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.preference.PreferenceManager;

/**
 * Created by AvanSchuijlenborgh on 24-11-2014.
 */


public class Splash extends Activity {


    MediaPlayer ourSong;

    @Override
    protected void onCreate(Bundle AvsLovesBacon) {
        super.onCreate(AvsLovesBacon);
        setContentView(R.layout.splash);

        ourSong = MediaPlayer.create(Splash.this, R.raw.leanback);

        SharedPreferences getPrefs = PreferenceManager.getDefaultSharedPreferences(getBaseContext());

        boolean music = getPrefs.getBoolean("checkbox", true);

        if (music == false) {
            ourSong.start();

        }

        Thread timer = new Thread(){
           public void run (){
            try{
                sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally{
                Intent openMainActivity = new Intent("com.example.thenewbostonavs.MENU" );
                startActivity(openMainActivity);
            }
           }
        };
        timer.start();
    }

    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }
}
