package com.animation.view;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;

import androidx.appcompat.app.AppCompatActivity;

import com.animation.R;

public class ViewAnimationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_animation);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.renew, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.renew:
                recreate();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.viewAlphaAnimation:
                Animation alphaAnimation = AnimationUtils.loadAnimation(this, R.anim.alpha);
                view.startAnimation(alphaAnimation);
                break;
            case R.id.viewScaleAnimation:
                Animation scaleAnimation = AnimationUtils.loadAnimation(this, R.anim.scale);
                view.startAnimation(scaleAnimation);
                break;
            case R.id.viewTranslateAnimation:
                Animation translateAnimation = AnimationUtils.loadAnimation(this, R.anim.translate);
                view.startAnimation(translateAnimation);
                break;
            case R.id.viewRotateAnimation:
                Animation rotateAnimation = AnimationUtils.loadAnimation(this, R.anim.rotate);
                view.startAnimation(rotateAnimation);
                break;
            case R.id.viewSetAnimation:
                Animation setAnimation = AnimationUtils.loadAnimation(this, R.anim.set);
                view.startAnimation(setAnimation);
                break;
            case R.id.viewLinear:
            case R.id.viewAccelerate:
                View viewLinear = findViewById(R.id.viewLinear);
                View viewAccelerate = findViewById(R.id.viewAccelerate);

                Animation animationLinear = AnimationUtils.loadAnimation(this, R.anim.translate);
                Animation animationAccelerate = AnimationUtils.loadAnimation(this, R.anim.translate);
                animationLinear.setInterpolator(new LinearInterpolator());
                animationAccelerate.setInterpolator(new AccelerateInterpolator());

                viewLinear.startAnimation(animationLinear);
                viewAccelerate.startAnimation(animationAccelerate);

                break;
        }
    }
}
