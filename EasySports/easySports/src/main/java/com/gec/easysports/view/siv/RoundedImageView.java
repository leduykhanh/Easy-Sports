package com.gec.easysports.view.siv;

import android.content.Context;
import android.util.AttributeSet;

import com.gec.easysports.view.siv.shader.RoundedShader;
import com.gec.easysports.view.siv.shader.ShaderHelper;

public class RoundedImageView extends ShaderImageView {

    public RoundedImageView(Context context) {
        super(context);
    }

    public RoundedImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public RoundedImageView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    public ShaderHelper createImageViewHelper() {
        return new RoundedShader();
    }
}
