package com.example.ok.coustomanim;

import android.annotation.TargetApi;
import android.os.Build;
import android.view.animation.BaseInterpolator;

/**
 * Created by Ok on 2016/9/8.
 * 自定义先加速后减速插值器
 */
@TargetApi(Build.VERSION_CODES.LOLLIPOP_MR1)
public class CustomInterpolator extends BaseInterpolator{
    @Override
    public float getInterpolation(float input) {
        return ((4*input-2)*(4*input-2)*(4*input-2))/16f + 0.5f;
    }
}
