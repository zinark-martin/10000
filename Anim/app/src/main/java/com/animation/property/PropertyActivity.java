package com.animation.property;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import com.animation.R;
import com.animation.frame.FrameAnimationActivity;

import static android.animation.AnimatorInflater.loadAnimator;
import static android.animation.ObjectAnimator.ofFloat;

public class PropertyActivity extends AppCompatActivity {

    private static final String TAG = "PropertyActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_property);
    }

    public void onClick(View view) {
        switch (view.getId()) {
//            case R.id.btnValueAnimator:
//                ValueAnimator valueAnimator = ValueAnimator.ofFloat(0f, 1.0f);
//                valueAnimator.setInterpolator(new LinearInterpolator());
//                valueAnimator.setDuration(100);
//                valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
//                    @Override
//                    public void onAnimationUpdate(ValueAnimator animation) {
//                        float animatedFraction = animation.getAnimatedFraction();
//                        float animatedValue = (float) animation.getAnimatedValue();
//                        Log.d(TAG, "onAnimationUpdate: " + String.format("%.3f  %.3f", animatedFraction, animatedValue));
//                    }
//                });
//                valueAnimator.start();
//                break;
            case R.id.viewAlphaAnimation:
                Animator alphaAnimator = loadAnimator(this, R.animator.alpha);
                alphaAnimator.setTarget(view);
                alphaAnimator.start();
                break;
            case R.id.viewScaleAnimation:
                ofFloat(view, "scaleX", 1.0f, 3.0f).start();
                startActivity(new Intent(this,FrameAnimationActivity.class));
                break;
            case R.id.viewTranslateAnimation:
                view.animate().translationX(500f).setDuration(1000).start();
                break;
            case R.id.viewRotateAnimation:
                view.animate().rotation(720).start();
                break;
            case R.id.viewSetAnimation:
                Animator rotateAnimator = ofFloat(view, "rotation", 0, 720).setDuration(1000);
                Animator moveAnimator = ofFloat(view, "x", 0, 500).setDuration(1000);
                AnimatorSet set = new AnimatorSet();
                //两种组合模式
                set.playTogether(rotateAnimator, moveAnimator);
                //set.playSequentially(rotateAnimator, moveAnimator);
                set.start();

                //也可以通过设置startDelay来实现顺序
                view.animate().rotation(720).setDuration(1000).start();
                view.animate().translationX(500).setDuration(1000).setStartDelay(1000).start();
                break;
            default:
                break;
        }
    }
}
