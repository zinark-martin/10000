package com.imooc.transitionanimation.reveal;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.widget.CheckBox;

import androidx.appcompat.app.AppCompatActivity;

import com.imooc.transitionanimation.R;

public class RevealActivity extends AppCompatActivity {

    private static final String TAG = "RevealActivity";

    private View mView;
    private CheckBox mPlayAnimationCheckBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reveal);
        mView = findViewById(R.id.view);
        mPlayAnimationCheckBox = (CheckBox) findViewById(R.id.checkBox);
    }

    public void onClick(View view) {
        final boolean playAnimation = mPlayAnimationCheckBox.isChecked();
        switch (view.getId()) {
            case R.id.buttonChangeVisibility:
                handleChangeVisibility(playAnimation);
                break;
        }
    }

    private void handleChangeVisibility(boolean playAnimation) {
        Log.d(TAG, "handleChangeVisibility() called with: playAnimation = [" + playAnimation + "]");
        Log.d(TAG, "handleChangeVisibility: " + mView.isShown());
        if (playAnimation) {
            if (mView.isShown()) {
                revealExit();
            } else {
                revealEnter();
            }
        } else {
           if (mView.isShown()) {
               mView.setVisibility(View.INVISIBLE);
           } else {
               mView.setVisibility(View.VISIBLE);
           }
        }
    }

    private void revealEnter() {
        int w = mView.getWidth();
        int h = mView.getHeight();
        //终点半径
        int r = (int) Math.hypot(w, h);

        mView.setVisibility(View.VISIBLE);
        Animator animator = ViewAnimationUtils.createCircularReveal(mView, w/2, h/2, 0, r);
        animator.setDuration(3000);
        //animator.start();

    }

    private void revealExit() {
        int w = mView.getWidth();
        int h = mView.getHeight();

        int cx = w;
        int cy = h;

        int r = (int) Math.hypot(w, h);

        Animator animator = ViewAnimationUtils.createCircularReveal(mView, cx, cy, r, 0);
        animator.setDuration(2000);

        /*animator.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                mView.setVisibility(View.INVISIBLE);
            }
        });*/
        animator.start();
        //mView.setVisibility(View.INVISIBLE);
    }

}
