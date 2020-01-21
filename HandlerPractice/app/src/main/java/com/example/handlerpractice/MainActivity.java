package com.example.handlerpractice;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.nfc.Tag;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.util.Log;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Handler handler = new Handler() {
            @Override
            public void handleMessage(@NonNull Message msg) {
                super.handleMessage(msg);
                Log.d(TAG, "hi" + msg.what);
                if (msg.what == 1024) {
                    //更改UI
                }
            }
        };

        handler.sendEmptyMessage(1024);
        //空消息, 只发送地址

        Message message = Message.obtain();
        //不使用new, 使用obtain()方法, 因为其中包含一个消息池缓存
        message.what = 1024;
        //标志是谁,用于接受时区分
        message.arg1 = 1025;
        //两个arg(int), 为了方便用??
        message.arg2 = 1026;
        message.obj = MainActivity.this;
        //存放Object
        //上下作用一致
        message.sendToTarget();
        handler.sendMessage(message);
        //打包发送msg
        handler.sendMessageAtTime(message, SystemClock.uptimeMillis() + 3000);
        handler.sendMessageDelayed(message,2000);

        Runnable runnable = ()->{
            //更改UI的线程
        };
        handler.post(runnable);
        //专门传Runnable对象
        //看源码 就是即时发送
        handler.sendMessageAtTime(message,SystemClock.uptimeMillis()+2000);

        //也可以使用runOnUiThread
        runOnUiThread(()->{
            //更改UI操作
        });
    }
}
