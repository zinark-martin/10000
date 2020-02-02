package com.imooc.transitionanimation;

import android.content.Intent;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.imooc.transitionanimation.activity.FirstActivity;
import com.imooc.transitionanimation.reveal.RevealActivity;
import com.imooc.transitionanimation.scene.SceneActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnReveal:
                startActivity(new Intent(this, RevealActivity.class));
                break;
            case R.id.btnScene:
                startActivity(new Intent(this, SceneActivity.class));
                break;
            case R.id.btnActivity:
                startActivity(new Intent(this, FirstActivity.class));
                break;
        }
    }

}
