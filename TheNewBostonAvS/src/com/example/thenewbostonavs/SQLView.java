package com.example.thenewbostonavs;

import android.app.Activity;
import android.os.Bundle;

/**
 * Created by AvanSchuijlenborgh on 27-1-2015.
 */
public class SQLView extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initialise();
    }

    private void initialise() {
        setContentView(R.layout.sqlview);



    }
}
