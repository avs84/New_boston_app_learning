package com.example.thenewbostonavs;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
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

        initialise();

        ourBrowser.getSettings().setJavaScriptEnabled(true);
        ourBrowser.getSettings().setLoadWithOverviewMode(true);
        ourBrowser.getSettings().setUseWideViewPort(true);

        ourBrowser.setWebViewClient(new OurViewClient());

        try {
            ourBrowser.loadUrl("https://www.google.com");
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    private void initialise() {

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
                String website = url.getText().toString();

                ourBrowser.loadUrl(website);
                //hidding keyboard after using edittext
                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(url.getWindowToken() ,0);

                break;

            case R.id.bForward:
                if (ourBrowser.canGoForward()) {
                    ourBrowser.goForward();
                }
                break;

            case R.id.bBack:
                if (ourBrowser.canGoBack()) {
                    ourBrowser.goBack();
                }
                break;

            case R.id.bRefresh:
                ourBrowser.reload();
                break;

            case R.id.bHistory:
                ourBrowser.clearHistory();
                break;

        }

    }
}

