package com.imooc.transitionanimation.activity;


import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.transition.Explode;
import android.transition.Fade;
import android.transition.Slide;
import android.transition.Transition;
import android.view.View;

import android.util.Pair;

import androidx.appcompat.app.AppCompatActivity;

import com.imooc.transitionanimation.R;

public class FirstActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        //从别的Activity进场动画
        getWindow().setEnterTransition(new Explode());
    }
    /**
     *     点击事件获取图片的id并将其IPC给下一个activity
     */
    public void onClick(View theView) {
        int resId = -1;
        switch (theView.getId()) {
            case R.id.image1:
                resId = R.drawable.pic1;
                break;
            case R.id.image2:
                resId = R.drawable.pic2;
                break;
            case R.id.image3:
                resId = R.drawable.pic3;
                break;
            case R.id.image4:
                resId = R.drawable.pic4;
                break;
            default :
                break;
        }

        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra("resId", resId);
        Transition fade = new Fade();
        Transition slide = new Slide();
        Transition explode = new Explode();
        //排除状态栏的动画
        explode.excludeTarget(android.R.id.statusBarBackground, true);
        getWindow().setExitTransition(explode);
        //设置再次切换回此页面的动画
        getWindow().setReenterTransition(explode);
        //为共享元素指定转场效果
        getWindow().setSharedElementEnterTransition(explode);
        /**
         * 自此,本场景的场景动画可以完成, 但是点击图片会直接进入下一个activity, 相当于挡住了动画
         * 所以我们需要把下一个activity显示的view和当前这个共享, 实现无缝切换
         * 这就用到了ActivityOptions的内容
         * */

        //用来处理无缝切换 把选中的view绑对
        Pair<View, String> shareElement = Pair.create(theView, "img");
        //设置两个场景共享资源图片
        ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(this, shareElement);

        startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(this, theView, "img").toBundle());

        //也可以直接在makeSceneTransitionAnimation中写共享资源和名字
        ActivityOptions op = ActivityOptions.makeSceneTransitionAnimation(this, theView, "img");
    }
}
