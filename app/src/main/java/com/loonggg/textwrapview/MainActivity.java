package com.loonggg.textwrapview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.loonggg.textwrapviewlib.view.TextWrapView;

public class MainActivity extends AppCompatActivity {
    private TextWrapView twv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        twv = (TextWrapView)findViewById(R.id.medium_text_view);
        Content content = Content.deserialize(this);
        try {
            twv.setText("<p>"+content.getContent().replace("\n","</P><p>")+"</p>");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
