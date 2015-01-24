package com.example.thenewbostonavs;

import android.webkit.WebView;
import android.webkit.WebViewClient;

/**
 * Created by aschuijlenborgh on 24-1-15.
 */
public class OurViewClient extends WebViewClient {


    @Override
    public boolean shouldOverrideUrlLoading(WebView v, String url){
        v.loadUrl(url);
        return true;
    }

}
