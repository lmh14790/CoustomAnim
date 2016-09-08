package com.example.ok.coustomanim;

import android.graphics.Camera;
import android.graphics.Matrix;
import android.view.animation.Animation;
import android.view.animation.Transformation;

/**
 * Created by Ok on 2016/9/8.
 */
public class OpeanDoorAnimation extends Animation {

    private int mCenterWidth, mCenterHeight;
    //android.graphics.Camera可以对图像执行一些比较复杂的操作，诸如旋转与绽放，与Matrix可实现图像的倾\\\\


    private Camera mCamera = new Camera();
    private float mRotateY = 0.0f;

    @Override
    public void initialize(int width, int height, int parentWidth, int parentHeight) {
        super.initialize(width, height, parentWidth, parentHeight);
        // 设置默认时长
        setDuration(4000);
        // 保持动画的结束状态
        setFillAfter(true);
        // 设置默认插值器
        //setInterpolator(new BounceInterpolator());// 回弹效果的插值器
        mCenterWidth = width / 2;
        mCenterHeight = height / 2;
    }

    // 暴露接口设置旋转角度
    public void setRotateY(float rotateY) {
        mRotateY = rotateY;
    }

    // 自定义动画的核心，在动画的执行过程中会不断回调此方法，并且每次回调interpolatedTime值都在不断变化(0----1)
    @Override
    protected void applyTransformation(float interpolatedTime, Transformation t) {
        super.applyTransformation(interpolatedTime, t);
        final Matrix matrix = t.getMatrix();
        mCamera.save();
        //使用Camera设置Y轴方向的旋转角度

        mCamera.rotateY(mRotateY * interpolatedTime);
        //将旋转变化作用到matrix上
        mCamera.getMatrix(matrix);
        //
        matrix.preTranslate(-mCenterWidth, -mCenterWidth);
        //可以发现定义和使用都比较简单，这里简单说下animation里面的preTranslate和postTranslate方法，preTranslate是指在rotateY
        // 前平移,postTranslate是指在rotateY后平移，注意他们参数是平移的距离,而不是平移目的地的坐标!

        //由于旋转是以(0,0)为中心的,所以为了把界面的中心与(0,0)对齐,就要preTranslate(-centerX, -centerY), rotateY完成后,
        // 调用postTranslate(centerX, centerY),再把图片移回来,这样看到的动画效果就是activity的界面图片从中心不停的旋转了。
        matrix.postTranslate(mCenterWidth, mCenterWidth);
        mCamera.restore();

    }
}
