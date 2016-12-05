package com.example.ibrahim.sndabd;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        // l web view l mfrod no by3ml search 3n 7aga w y3rdha fl app w kda
        WebView webView=(WebView)findViewById(R.id.webView);
        // hna b2a getIntent(); b2olo ro7 3la l activity l na gay mno w hat l data l hwa hykon MainActivity
        Intent data=getIntent();
        // hna hygeb l data bl key l asmo "page"
        int page=data.getExtras().getInt("page");
        page++;
        // b2olo a3ml loaaaaaaaad :D
        webView.loadUrl("https://www.google.com.eg/#q="+page);
    }

  }
