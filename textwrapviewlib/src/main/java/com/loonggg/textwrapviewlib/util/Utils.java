package com.loonggg.textwrapviewlib.util;

import android.content.Context;
import android.graphics.Typeface;
import android.util.DisplayMetrics;
import android.widget.TextView;

import com.loonggg.textwrapviewlib.view.BlockquoteView;
import com.loonggg.textwrapviewlib.view.DivView;
import com.loonggg.textwrapviewlib.view.ElementView;
import com.loonggg.textwrapviewlib.view.HeaderView;
import com.loonggg.textwrapviewlib.view.IFrameView;
import com.loonggg.textwrapviewlib.view.ImageView;
import com.loonggg.textwrapviewlib.view.ParagraphView;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


public class Utils {

    public static void appendView(ElementView elementView, Elements elements, int color, int size) {
        for (Element e : elements) {
            if (JsoupUtils.isBlockquote(e)) {
                elementView.addView(new BlockquoteView(elementView.getContext(), e, color, size));
            } else if (JsoupUtils.isHeader(e)) {
                elementView.addView(new HeaderView(elementView.getContext(), e, color, size));
            } else if (JsoupUtils.isIFrame(e)) {
                elementView.addView(new IFrameView(elementView.getContext(), e, color, size));
            } else if (JsoupUtils.isParagraph(e)) {
                elementView.addView(new ParagraphView(elementView.getContext(), e, color, size));
            } else if (JsoupUtils.isImage(e)) {
                elementView.addView(new ImageView(elementView.getContext(), e, color, size));
            } else if (JsoupUtils.isDiv(e)) {
                elementView.addView(new DivView(elementView.getContext(), e, color, size));
            } else {

            }
        }
    }

    public static int dpToPx(Context context, int dp) {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        int px = Math.round(dp * (displayMetrics.xdpi / DisplayMetrics.DENSITY_DEFAULT));
        return px;
    }

    public static void setTypeface(TextView textView, String fontName) {
        Typeface myTypeface = Typeface.createFromAsset(textView.getContext().getAssets(), "fonts/" + fontName);
        textView.setTypeface(myTypeface);
    }
}
