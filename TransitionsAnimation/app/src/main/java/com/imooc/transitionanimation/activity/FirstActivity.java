package com.imooc.transitionanimation.activity;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.transition.Explode;
import android.transition.Transition;
import android.util.Pair;
import android.view.View;

import com.imooc.transitionanimation.R;

public class FirstActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
    }

    public void onClick(View view) {
        int resId = -1;
        switch (view.getId()) {
            case R.id.iv1:
                resId = R.drawable.pic1;
                break;
            case R.id.iv2:
                resId = R.drawable.pic2;
                break;
            case R.id.iv3:
                resId = R.drawable.pic3;
                break;
            case R.id.iv4:
                resId = R.drawable.pic4;
                break;
        }
        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra("resId", resId);
        Transition transition = new Explode();
        transition.excludeTarget(android.R.id.statusBarBackground, true);

        getWindow().setEnterTransition(transition);
        getWindow().setExitTransition(transition);
        getWindow().setReenterTransition(transition);
        getWindow().setSharedElementEnterTransition(transition);

        Pair<View, String> shareElement = Pair.create(view, "img");
        ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(this, shareElement);
        startActivity(intent, options.toBundle());
    }
}
