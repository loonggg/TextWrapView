package com.loonggg.textwrapviewlib.view;

import android.content.Context;
import android.util.AttributeSet;

import org.jsoup.nodes.Element;


public class BlockquoteView extends ElementView {


    public BlockquoteView(Context context, Element element,int color,int size) {
        super(context, element,color,size);
    }

    public BlockquoteView(Context context, AttributeSet attrs, Element element) {
        super(context, attrs, element);
    }

    @Override
    public void render(int color, int size) {

    }
}
