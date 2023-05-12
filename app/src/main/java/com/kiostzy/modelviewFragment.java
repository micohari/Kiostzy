package com.kiostzy;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageButton;


public class modelviewFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_modelview, container, false);
        ImageButton alumunium = (ImageButton) v.findViewById(R.id.view_alumunium);
        ImageButton kayu = (ImageButton) v.findViewById(R.id.view_kayu);
        ImageButton galvalum = (ImageButton) v.findViewById(R.id.view_galvalum);
        ImageButton vcontainer = (ImageButton) v.findViewById(R.id.view_container);



        kayu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                WebView webView = (WebView) v.findViewById(R.id.webview);
                webView.getSettings().setJavaScriptEnabled(true);
                webView.getSettings().setLoadWithOverviewMode(true);
                webView.setWebViewClient(new WebViewClient());
                webView.loadUrl("file:///android_asset/kayu.html");
            }
        });
        alumunium.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                WebView webView = (WebView) v.findViewById(R.id.webview);
                webView.getSettings().setJavaScriptEnabled(true);
                webView.getSettings().setLoadWithOverviewMode(true);
                webView.setWebViewClient(new WebViewClient());
                webView.loadUrl("file:///android_asset/alumunium.html");
            }
        });

        galvalum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                WebView webView = (WebView) v.findViewById(R.id.webview);
                webView.getSettings().setJavaScriptEnabled(true);
                webView.getSettings().setLoadWithOverviewMode(true);
                webView.setWebViewClient(new WebViewClient());
                webView.loadUrl("file:///android_asset/galvalum.html");
            }
        });

        vcontainer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                WebView webView = (WebView) v.findViewById(R.id.webview);
                webView.getSettings().setJavaScriptEnabled(true);
                webView.getSettings().setLoadWithOverviewMode(true);
                webView.setWebViewClient(new WebViewClient());
                webView.loadUrl("file:///android_asset/container.html");
            }
        });

        return v;
    }
}