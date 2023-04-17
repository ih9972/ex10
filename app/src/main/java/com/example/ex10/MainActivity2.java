package com.example.ex10;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity2 extends AppCompatActivity {
    WebView wv;
    Intent gi;
    int a,b,c;
    String papmath ="https://www.mathpapa.com/quadratic-formula/?q=";
    double s1,s2,disc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        wv = (WebView) findViewById(R.id.wv);
        wv.getSettings().setJavaScriptEnabled(true);
        wv.setWebViewClient(new MyWebViewClient());
        gi = getIntent();
        a = Integer.parseInt(gi.getStringExtra("a"));
        b = Integer.parseInt(gi.getStringExtra("b"));
        c = Integer.parseInt(gi.getStringExtra("c"));
        wv.loadUrl(papmath+a+"x^2+"+b+"x+"+c+"%3D0");
    }

    public void goback(View view) {
        s1 = 0;
        s2 = 0;
        disc = b * b - (4 * a * c);
        if(disc < 0) {
            gi.putExtra("how_many_solution", 0);
        }
        else if(disc == 0){
            gi.putExtra("how_many_solution", 1);
            s1 = (-b + Math.sqrt(disc)) / (2 * a);
        }
        else{
            gi.putExtra("how_many_solution", 2);
            s1 = (-b + Math.sqrt(disc)) / (2 * a);
            s2 = (-b - Math.sqrt(disc)) / (2 * a);
        }
        gi.putExtra("x1", s1);
        gi.putExtra("x2", s2);
        setResult(RESULT_OK, gi);
       finish();
    }

    private class MyWebViewClient extends WebViewClient {
        public boolean shouldOverrideUrlLoading(WebView view, String url){
            view.loadUrl(url);
            return true;
        }
    }
}