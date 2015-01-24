package com.example.thenewbostonavs;

import android.app.Activity;
import android.os.Bundle;

/**
 * Created by aschuijlenborgh on 7-12-14.
 */
public class GFX extends Activity {

    MyBringBack ourView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ourView = new MyBringBack(this);

        setContentView(ourView);

    }
}
