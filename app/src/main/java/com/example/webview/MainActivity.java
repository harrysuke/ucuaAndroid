package com.example.webview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //requestWindowFeature(Window.FEATURE_NO_TITLE);
        //this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);

        WebView mywebview = findViewById(R.id.webview);
        mywebview.addJavascriptInterface(new WebAppInterface(this), "Android");

        WebSettings webSettings = mywebview.getSettings();
        // Enable JavaScript
        webSettings.setJavaScriptEnabled(true);

        //disabled opening browser
        mywebview.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return false; // Let WebView handle the URL
            }
        });

        mywebview.loadUrl("http://apps.johorport.com.my/opinv2/login.php");
        //force the website to stay in the webview.
        //mywebview.setWebViewClient(new WebViewClient());
        //load the website
        //mywebview.loadUrl("https://jodc.johorport.com.my/jw/web/login");
        //mywebview.loadUrl("https://www.johorport.com.my");
    }
}