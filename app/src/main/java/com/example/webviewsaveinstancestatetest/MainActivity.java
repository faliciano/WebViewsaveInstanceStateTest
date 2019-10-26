package com.example.webviewsaveinstancestatetest;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    String weburl = "https://www.baidu.com/";
    WebView webv;

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        webv = findViewById(R.id.webv);
        webv.getSettings().setJavaScriptEnabled(true);
        webv.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                return false;
            }
        });
        if (savedInstanceState == null) {
            webv.loadUrl(weburl);
        }
    }

    @Override
    public void onSaveInstanceState(Bundle saveInstanceState) {
        super.onSaveInstanceState(saveInstanceState);
        webv.saveState(saveInstanceState);
    }

    @Override
    public void onRestoreInstanceState(Bundle saveInstanceState) {
        super.onRestoreInstanceState(saveInstanceState);
        webv.restoreState(saveInstanceState);
    }
}