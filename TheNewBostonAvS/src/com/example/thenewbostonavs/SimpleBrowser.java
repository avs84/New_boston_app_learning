package com.example.thenewbostonavs;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by aschuijlenborgh on 24-1-15.
 */
public class SimpleBrowser extends Activity implements View.OnClickListener {

    WebView ourBrowser;
    Button go,forward,back,refresh, history;
    EditText url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.simplebrowser);

        ourBrowser = (WebView) findViewById(R.id.wvBrowser);
        go = (Button) findViewById(R.id.bGo);
        forward = (Button) findViewById(R.id.bForward);
        back = (Button) findViewById(R.id.bBack);
        refresh = (Button) findViewById(R.id.bRefresh);
        history = (Button) findViewById(R.id.bHistory);
        url = (EditText) findViewById(R.id.etURL);

        go.setOnClickListener(this);
        back.setOnClickListener(this);
        forward.setOnClickListener(this);
        refresh.setOnClickListener(this);
        history.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.bGo:

                break;

            case R.id.bForward:

                break;

            case R.id.bBack:

                break;

            case R.id.bRefresh:

                break;

            case R.id.bHistory:

                break;

        }

    }
}

