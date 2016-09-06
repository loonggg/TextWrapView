package com.loonggg.textwrapviewlib.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;

import com.loonggg.textwrapviewlib.util.Utils;

import org.jsoup.nodes.Element;


public class ParagraphView extends ElementView {


    public ParagraphView(Context context, Element element,int color,int size) {
        super(context, element,color,size);
    }

    protected ParagraphView(Context context, AttributeSet attrs, Element element) {
        super(context, attrs, element);
    }


    @Override
    public void render(int color,int size) {
        setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
        setOrientation(VERTICAL);

        if (getElement() != null) {
            if (getElement().children().size() > 0) {
                Utils.appendView(this, getElement().children(),color,size);
            }
            if (!getElement().text().isEmpty()) {
                setText(getElement().text(),color,size);
            }
        }

    }

    public void setText(String text,int color,int size) {
        TextView textView = new TextView(getContext());
        textView.setLayoutParams(new LayoutParams(
                LayoutParams.MATCH_PARENT,
                LayoutParams.WRAP_CONTENT));
        textView.setText(text);
        textView.setPadding(Utils.dpToPx(getContext(), 16), 0, Utils.dpToPx(getContext(), 16), 0);
        textView.setTextSize(size);
        textView.setLineSpacing(0, 1.5f);
        textView.setTextColor(color);
        addView(textView);

        //段落换行的作用
        TextView enterTv = new TextView(getContext());
        enterTv.setLayoutParams(new LayoutParams(
                LayoutParams.MATCH_PARENT,
                LayoutParams.WRAP_CONTENT));
        enterTv.setText(" ");
        enterTv.setPadding(Utils.dpToPx(getContext(), 16), 0, Utils.dpToPx(getContext(), 16), 0);
        enterTv.setTextSize(size);
        enterTv.setLineSpacing(0, 1.5f);
        enterTv.setTextColor(color);
        addView(enterTv);
    }

}
