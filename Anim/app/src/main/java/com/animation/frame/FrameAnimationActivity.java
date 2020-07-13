package com.animation.frame;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;

import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.content.res.AppCompatResources;

import com.animation.R;

/**
 * @author ZINARK
 */
public class FrameAnimationActivity extends AppCompatActivity {

    private AnimationDrawable animationDrawable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frame_animation);
        //创建绘制动画对象, 从view的background的写好的drawable中
        animationDrawable = (AnimationDrawable) findViewById(R.id.view).getBackground();
        //这里也可以写drawable中的属性, 优先级高于xml那边
        // animationDrawable.setOneShot(true);
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnStart:
                animationDrawable.start();
                break;
            case R.id.btnStop:
                animationDrawable.stop();
                break;
                default :
        }
    }
}
