package com.imooc.transitionanimation.scene;

import android.os.Bundle;
import android.transition.Fade;
import android.transition.Scene;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.transition.TransitionManager;
import android.view.View;
import android.view.ViewGroup;

import androidx.appcompat.app.AppCompatActivity;

import com.imooc.transitionanimation.R;

public class SceneActivity extends AppCompatActivity {

    private Scene mOverViewScene;
    private Scene mInfoScene;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scene);

        ViewGroup sceneRoot = (ViewGroup) findViewById(R.id.scene_root);
        mOverViewScene = Scene.getSceneForLayout(sceneRoot, R.layout.scene_overview, getBaseContext());
        mInfoScene = Scene.getSceneForLayout(sceneRoot, R.layout.scene_info,getBaseContext());

        TransitionManager.go(mOverViewScene);
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnInfo:
                Transition transition = TransitionInflater.from(getBaseContext())
                        .inflateTransition(R.transition.transition);
                //如果使用次数比较少且目标单一也可以这样写
                Transition transition1 = new Fade();
                TransitionManager.go(mInfoScene, transition);
                break;
            case R.id.btnClose:
                TransitionManager.go(mOverViewScene);
                break;
            default :
        }
    }

}
