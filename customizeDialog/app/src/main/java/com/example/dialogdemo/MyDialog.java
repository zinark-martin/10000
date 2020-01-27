package com.example.dialogdemo;

import android.app.Dialog;
import android.content.Context;
import android.view.View;

import androidx.annotation.NonNull;
//1.设计自定义对话框样式xml
//2.设计Style(去除标题栏和背景)
//3.所以实例化对话框的时候传两个参数: 上下文和R.style.xxx)

public class MyDialog extends Dialog {

    public MyDialog(@NonNull final Context context, int themeResId) {
        //三个构造器, 选中的是参数为上下文和主题(styles.xml)的
        //带主题的对话框就不会有白背景了, 边角就会变成空白
        super(context,themeResId);
        //为对话框设置布局
        setContentView(R.layout.dialog_layout);

        findViewById(R.id.yes_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.exit(0);
            }
        });

        findViewById(R.id.no_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });
    }
}
