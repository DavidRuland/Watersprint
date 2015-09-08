package com.example.david.mywebviewapp;


/**
 * Created by David on 2015-06-14.
 */

import android.content.Intent;
import android.net.Uri;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MyAppViewClient extends WebViewClient
{
   @Override
    public boolean shouldOverrideUrlLoading(WebView view, String url) {
       view.loadUrl(url);
       return true;

   }
    }

