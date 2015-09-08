package com.example.david.mywebviewapp;

import android.app.Activity;
import android.graphics.Color;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebView;
import android.webkit.WebSettings;
import android.webkit.WebViewClient;
import android.widget.LinearLayout;
import android.widget.SeekBar;


public class MainActivity extends Activity {
private WebView mWebView;
  private  WebSettings webSettings;
   private  MyAppViewClient mAppViewClient;
   private String Url;
    private String URLTest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mWebView = (WebView) findViewById(R.id.webview);
        webSettings = mWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setUseWideViewPort(true);
        webSettings.setLoadWithOverviewMode(true);//zooms content to fit on screen width
        webSettings.setBuiltInZoomControls(true);
        webSettings.setSupportZoom(true);
        webSettings.setDisplayZoomControls(true);
        mWebView.setScrollBarStyle(mWebView.SCROLLBARS_INSIDE_OVERLAY);
        mAppViewClient=new MyAppViewClient();
        mWebView.setWebViewClient(mAppViewClient);
        if(savedInstanceState==null)
        {
            OpenUrl();
        }



    }
@Override
    protected  void  onSaveInstanceState (Bundle out)
    {
        super.onSaveInstanceState(out);

        // Save the state of the WebView
        mWebView.saveState(out);
    }
   @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState)
    {
        super.onRestoreInstanceState(savedInstanceState);

        // Restore the state of the WebView
        mWebView.restoreState(savedInstanceState);
    }


    private void OpenUrl()
    {


            Url = "https://watersprintsystem.se/app";
            mWebView.loadUrl(Url);
            mWebView.requestFocus();



    }
    @Override
    public void onBackPressed()
    {
        if (mWebView.canGoBack()) {
            mWebView.goBack();
        } else {
            super.onBackPressed();
        }
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


}
