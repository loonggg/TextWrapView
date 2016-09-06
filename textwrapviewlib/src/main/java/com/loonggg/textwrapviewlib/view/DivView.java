package com.loonggg.textwrapviewlib.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;

import com.loonggg.textwrapviewlib.util.Utils;

import org.jsoup.nodes.Element;


public class DivView extends ElementView {

    public DivView(Context context, Element element) {
        super(context, element);
    }

    public DivView(Context context, AttributeSet attrs, Element element) {
        super(context, attrs, element);
    }

    @Override
    public void render() {
        setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
        setOrientation(LinearLayout.VERTICAL);

        if (getElement() != null) {
            if (getElement().children().size() > 0) {
                Utils.appendView(this, getElement().children());
            }
        }
    }
}
