package com.imooc.transitionanimation.activity;


import android.app.Activity;
import android.os.Bundle;
import android.transition.Explode;
import android.transition.Transition;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.imooc.transitionanimation.R;

public class SecondActivity extends AppCompatActivity {

    @Override
    public void onBackPressed() {
        supportFinishAfterTransition();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Transition explode = new Explode();
        getWindow().setEnterTransition(explode);
        getWindow().setExitTransition(explode);
        int resId = getIntent().getExtras().getInt("resId");
        ImageView iv = (ImageView) findViewById(R.id.iv);
        //在动画中识别view的, 保证要唯一名字
        iv.setImageResource(resId);
        iv.setTransitionName("img");


        //因为这个页面只有一个图片, 就不设置进出场动画了
    }
}
