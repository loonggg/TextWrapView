package com.loonggg.textwrapviewlib.view;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.widget.LinearLayout;

import org.jsoup.nodes.Element;


public abstract class ElementView extends LinearLayout {

    private Element element;

    protected ElementView(Context context, Element element, int color, int size) {
        super(context);
        this.element = element;
        render(color, size);
    }

    protected ElementView(Context context, AttributeSet attrs,Element element) {
        super(context, attrs);
        this.element = element;
        render(Color.BLACK, 14);
    }


    public Element getElement() {
        return element;
    }

    public void setElement(Element element) {
        this.element = element;
    }

    public abstract void render(int color, int size);
}
