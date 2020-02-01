package com.animation.property;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.animation.R;

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
                Animator alphaAnimator = AnimatorInflater.loadAnimator(this, R.animator.alpha);
                alphaAnimator.setTarget(view);
                alphaAnimator.start();
                break;
            case R.id.viewScaleAnimation:
                ofFloat(view, "scaleX", 1.0f, 3.0f).start();
                break;
            case R.id.viewTranslateAnimation:
                view.animate().translationX(500f).setDuration(1000).start();
                break;
            case R.id.viewRotateAnimation:
                view.animate().rotation(720).start();
                break;
            case R.id.viewSetAnimation:
//                Animator rotateAnimator = ObjectAnimator.ofFloat(view, "rotation", 0, 720);
//                rotateAnimator.setDuration(1000);
//
//                Animator moveAnimator = ObjectAnimator.ofFloat(view, "x", 0, 500);
//                moveAnimator.setDuration(1000);
//
//                AnimatorSet set = new AnimatorSet();
////                set.playTogether(rotateAnimator, moveAnimator);
//                set.playSequentially(rotateAnimator, moveAnimator);
//                set.start();

                view.animate().rotation(720).setDuration(1000).start();
                view.animate().translationX(500).setDuration(1000).setStartDelay(1000).start();

                break;
            default:
                break;

        }
    }

}
