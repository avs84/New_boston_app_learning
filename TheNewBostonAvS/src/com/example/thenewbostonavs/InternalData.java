package com.example.thenewbostonavs;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by aschuijlenborgh on 24-1-15.
 */
public class InternalData extends Activity implements View.OnClickListener {

    EditText sharedData;
    TextView dataResults;
    Button save, load;
    public static String filename = "MySharedString";
    SharedPreferences someData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.sharedpreferences);
        initialise();
    }

    private void initialise() {
        sharedData = (EditText) findViewById(R.id.etData);
        dataResults = (TextView) findViewById(R.id.tvData);
        save = (Button) findViewById(R.id.bSave);
        load = (Button) findViewById(R.id.bLoad);

        save.setOnClickListener(this);
        load.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bSave:

                break;

            case R.id.bLoad:


                break;

        }
    }
}
