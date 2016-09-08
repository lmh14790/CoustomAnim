package com.example.ok.coustomanim;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class MainActivity extends AppCompatActivity {

    @InjectView(R.id.re_test)
    RelativeLayout mReTest;
    @InjectView(R.id.im_james)
    ImageView mImJames;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);
        Animation animation = new ShakeAnimation();
        animation.setDuration(3000);
        animation.setRepeatCount(10000);
        mReTest.startAnimation(animation);
        OpeanDoorAnimation animation1=new OpeanDoorAnimation();
        animation1.setInterpolator(new CustomInterpolator());
        //animation1.setInterpolator(new BounceInterpolator());
        animation1.setRotateY(360);
        mImJames.startAnimation(animation1);


    }
}
