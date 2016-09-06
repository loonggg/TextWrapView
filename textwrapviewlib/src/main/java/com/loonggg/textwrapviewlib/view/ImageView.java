package com.loonggg.textwrapviewlib.view;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.LinearLayout;

import com.loonggg.textwrapviewlib.R;
import com.loonggg.textwrapviewlib.util.Utils;
import com.squareup.picasso.Picasso;

import org.jsoup.nodes.Element;


public class ImageView extends ElementView {

    private static final String TAG = ImageView.class.getSimpleName();


    public ImageView(Context context, Element element,int color,int size) {
        super(context, element,color,size);
    }

    protected ImageView(Context context, AttributeSet attrs, Element element) {
        super(context, attrs, element);
    }

    @Override
    public void render(int color, int size) {
        Log.d(TAG, "I am image view");
        setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
        android.widget.ImageView imageView = new android.widget.ImageView(getContext());
        imageView.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
        imageView.setPadding(Utils.dpToPx(getContext(), 8), Utils.dpToPx(getContext(), 16), Utils.dpToPx(getContext(), 8), Utils.dpToPx(getContext(), 16));
        final String url = getLink();
        Picasso.with(getContext()).load(url).error(R.drawable.image_placeholder_error).into(imageView);
        imageView.setAdjustViewBounds(true);
        addView(imageView);
    }

    public String getLink() {
        if (getElement() == null)
            return null;
        return getElement().attr("abs:src");
    }
}
