package com.example.kavya.webview;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.TextView;

import static com.example.kavya.webview.R.id.webView;


public class MainActivity extends Activity {
//WebView webView;
final Context context = this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       WebView webView=(WebView)findViewById(R.id.webView);
       // webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl("http://www.cyanogen.space/index.php?r=user%2Fauth%2Flogin");

        final Dialog dialog = new Dialog(context);
        dialog.setContentView(R.layout.custom);
        dialog.setTitle("Wifi Alert!");

        // set the custom dialog components - text, image and button
        TextView text = (TextView) dialog.findViewById(R.id.text);
        text.setText("If WIFI is enabled then skip, if not Enable!!");

        Button dialogButtonEnable = (Button) dialog.findViewById(R.id.dialogButtonEnable);
        // if button is clicked, close the custom dialog
        dialogButtonEnable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                WifiManager wifi = (WifiManager) getApplicationContext().getSystemService(Context.WIFI_SERVICE);
                wifi.setWifiEnabled(true);
                dialog.dismiss();
                WebView webView=(WebView)findViewById(R.id.webView);
                // webView.getSettings().setJavaScriptEnabled(true);
                webView.loadUrl("http://www.cyanogen.space/index.php?r=user%2Fauth%2Flogin");
            }
        });

        Button dialogButtonSkip = (Button) dialog.findViewById(R.id.dialogButtonSkip);
        // if button is clicked, close the custom dialog
        dialogButtonSkip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        dialog.show();
    }
}

