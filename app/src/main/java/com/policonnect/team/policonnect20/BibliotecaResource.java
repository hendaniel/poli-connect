package com.policonnect.team.policonnect20;

import android.app.Activity;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageButton;
import android.widget.TextView;

public class BibliotecaResource extends Activity {

    private ImageButton mBackButton;
    private TextView mTitle;
    private WebView mWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_biblioteca_web_resources);

        mBackButton = findViewById(R.id.backButtonLibrary);
        mTitle = findViewById(R.id.titleService);
        mWebView = findViewById(R.id.webFrame);

        mTitle.setText(getString(R.string.recursos));
        mWebView.setWebViewClient(new WebViewClient());

        mWebView.loadUrl("http://catalogo.poligran.edu.co");
        // mWebView.loadUrl("https://www.google.com/");

        WebSettings webSettings = mWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);

        mBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    public void onBackPressed() {
        if (mWebView.canGoBack())
            mWebView.goBack();
        else
            super.onBackPressed();
    }
}
