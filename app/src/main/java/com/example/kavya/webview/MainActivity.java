package com.example.kavya.webview;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;


public class MainActivity extends Activity {
//WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        WebView webView=(WebView)findViewById(R.id.webView);
        // webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl("http://www.cyanogen.space/index.php?r=user%2Fauth%2Flogin");
    }
}

