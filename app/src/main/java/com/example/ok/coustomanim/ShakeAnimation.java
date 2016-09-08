package com.example.ok.coustomanim;

import android.view.animation.Animation;
import android.view.animation.Transformation;

/**
 * Created by Ok on 2016/9/8.
 *自定义抖动动画 qq抖动窗口
 */
public class ShakeAnimation extends Animation {

    @Override
    public void initialize(int width, int height, int parentWidth, int parentHeight) {
        super.initialize(width, height, parentWidth, parentHeight);
    }

    /**
     * 使用矩阵做处理
     * @param interpolatedTime
     * @param t
     */
    @Override
    protected void applyTransformation(float interpolatedTime, Transformation t) {
        super.applyTransformation(interpolatedTime, t);
        t.getMatrix().setTranslate(
                (float) Math.sin(interpolatedTime * 50) * 8,
                (float) Math.sin(interpolatedTime * 50) * 8
        );// 50越大频率越高，8越小振幅越小
    }
}
