package com.policonnect.team.policonnect20.UserScreens;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageButton;
import android.widget.TextView;

import com.policonnect.team.policonnect20.R;

/**
 * Esta clase maneja la pantalla que muestra los cubiculos de estudio disponibles y no disponibles
 * de la biblioteca
 *
 * @version 2
 * @author: PoliConnect Team
 */
public class UserSolicitud extends Activity {
    private ImageButton mBackButton;
    private TextView mTitle;
    private WebView mWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_page);

        mBackButton = findViewById(R.id.backButton);
        mTitle = findViewById(R.id.title);
        mWebView = findViewById(R.id.webFrame);

        mTitle.setText(getString(R.string.solicitud));
        mWebView.setWebViewClient(new WebViewClient());

        mWebView.loadUrl("http://smartcampus.poligran.edu.co");
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
