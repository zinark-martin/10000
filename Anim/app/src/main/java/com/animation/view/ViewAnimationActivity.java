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
            default :
        }
        return super.onOptionsItemSelected(item);
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.viewAlphaAnimation:
                view.startAnimation(AnimationUtils.loadAnimation(this, R.anim.alpha));
                break;
            case R.id.viewScaleAnimation:
                view.startAnimation(AnimationUtils.loadAnimation(this, R.anim.scale));
                break;
            case R.id.viewTranslateAnimation:
                view.startAnimation(AnimationUtils.loadAnimation(this, R.anim.translate));
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
            default :
        }
    }
}
