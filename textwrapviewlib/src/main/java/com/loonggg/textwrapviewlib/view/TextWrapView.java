package com.loonggg.textwrapviewlib.view;

import android.content.Context;
import android.util.AttributeSet;

import com.loonggg.textwrapviewlib.util.Utils;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;


public class TextWrapView extends ElementView {

    public TextWrapView(Context context,int color,int size) {
        super(context, null,color,size);
    }

    public TextWrapView(Context context, AttributeSet attrs) {
        super(context, attrs, null);
    }

    @Override
    public void render(int color, int size) {
        setOrientation(VERTICAL);
    }

    public void setText(String html,int color,int size) {
        Document document = Jsoup.parse(html);
        Element element = document.body();
        setElement(element);
        Utils.appendView(this, getElement().children(),color,size);
        invalidate();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);
    }
}
