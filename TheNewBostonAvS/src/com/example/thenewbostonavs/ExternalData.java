package com.example.thenewbostonavs;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.TextView;

/**
 * Created by aschuijlenborgh on 24-1-15.
 */
public class ExternalData extends Activity implements View.OnClickListener {

    private TextView canWrite, canRead;
    private String state;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.externaldata);

        canWrite = (TextView) findViewById(R.id.tvCanWrite);
        canRead = (TextView) findViewById(R.id.tvCanRead);

        state = Environment.getExternalStorageState();

        //Check state of external state
        if (state.equals(Environment.MEDIA_MOUNTED)){
                //Read and Write
            canWrite.setText("True");
            canRead.setText("True");
        }else if (state.equals(Environment.MEDIA_MOUNTED_READ_ONLY)) {
            // Read only
            canWrite.setText("false");
            canRead.setText("True");
        }else {
            // no Read or write access
            canWrite.setText("false");
            canRead.setText("false");
        }
    }



    @Override
    public void onClick(View v) {

    }
}
