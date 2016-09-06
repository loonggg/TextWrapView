package com.loonggg.textwrapviewlib.view;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.LinearLayout;

import com.loonggg.textwrapviewlib.util.Utils;

import org.jsoup.nodes.Element;


public class IFrameView extends ElementView {

    private static final String TAG = IFrameView.class.getSimpleName();

    public IFrameView(Context context, Element element) {
        super(context, element);
    }

    public IFrameView(Context context, AttributeSet attrs, Element element) {
        super(context, attrs, element);
    }

    @Override
    public void render() {
        Log.d(TAG, "I am IFrameView " + getLink());
        setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
        setPadding(0, 0, 0, Utils.dpToPx(this.getContext(), 16));
        WebView webView = new WebView(getContext());
        webView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {


                return false;
            }
        });
        webView.getSettings().setPluginState(WebSettings.PluginState.ON);
        webView.getSettings().setJavaScriptEnabled(true);
        getElement().attr("width", "100%");
        webView.loadData(getElement().toString(), "text/html", null);
        webView.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
        addView(webView);

    }

    public String getLink() {
        if (getElement() == null)
            return null;
        return getElement().attr("abs:src");
    }
}
