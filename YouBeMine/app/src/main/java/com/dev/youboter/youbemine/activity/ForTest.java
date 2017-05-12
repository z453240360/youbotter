package com.dev.youboter.youbemine.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.dev.youboter.youbemine.R;

public class ForTest extends AppCompatActivity {

    private WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_for_test);
        webView= (WebView) findViewById(R.id.mywebview);

        webView.getSettings().setJavaScriptEnabled(true);

        webView.loadUrl("http://kcbj.openspeech.cn/service/iss?wuuid=2eb903edf6d74b0913691228101837a7&ver=2.0&method=webPage&uuid=f8fc54b118097eed3492554fdeb86fafquery");
        webView.setWebViewClient(new HelloWeb());
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode==KeyEvent.KEYCODE_BACK)&&webView.canGoBack())
        {
            webView.goBack();
            return true;
        }
        return false;
    }

    class HelloWeb extends WebViewClient{
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
    }
}
