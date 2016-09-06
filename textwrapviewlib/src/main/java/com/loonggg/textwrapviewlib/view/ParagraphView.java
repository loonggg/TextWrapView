package com.loonggg.textwrapviewlib.view;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.widget.TextView;

import com.loonggg.textwrapviewlib.util.Utils;

import org.jsoup.nodes.Element;


public class ParagraphView extends ElementView {
    private Context context;

    public ParagraphView(Context context, Element element) {
        super(context, element);
        this.context = context;
    }

    protected ParagraphView(Context context, AttributeSet attrs, Element element) {
        super(context, attrs, element);
        this.context = context;
    }


    @Override
    public void render() {
        setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
        setOrientation(VERTICAL);

        if (getElement() != null) {
            if (getElement().children().size() > 0) {
                Utils.appendView(this, getElement().children());
            }
            if (!getElement().text().isEmpty()) {
                setText(getElement().text());
            }
        }

    }

    public void setText(String text) {
        TextView textView = new TextView(getContext());
        textView.setLayoutParams(new LayoutParams(
                LayoutParams.MATCH_PARENT,
                LayoutParams.WRAP_CONTENT));
        textView.setText(text);
        textView.setPadding(Utils.dpToPx(getContext(), 16), 0, Utils.dpToPx(getContext(), 16), 0);
        textView.setTextSize(14f);
        textView.setTextColor(Color.BLACK);
        addView(textView);
    }

}
