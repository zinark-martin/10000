package com.example.okhttpdemo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Headers;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
/*主要是注意call对象入队，创建一个newCall，用来区分成功和失败的两个方法
* 同步和异步都可以:
* 同步方法是call的execute
* 异步方法是Call的enqueue和线程池
* 注意post的使用：
* 在url方法后调用的是RequestBody的create静态方法，两个参数，mediaType类型和post类型都是去网站找*/


public class MainActivity extends AppCompatActivity {

    OkHttpClient mclient;

    private TextView mContentTextView;

    private static final String TAG = "MainActivity";

    private static final MediaType MEDIA_TYPE_MARKDOWN = MediaType.parse("text/x-markdown; charset=utf-8");

    private static final String POST_URL = "https://api.github.com/markdown/raw";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContentTextView = (TextView)findViewById(R.id.tvContent);

        mclient = new OkHttpClient();
        /*源于“请求”*/
/*      Request.Builder builder = new Request.Builder();
        builder.url("url");
        Request request = builder.build(); //request对象构建完毕
        *//*下面是写在一起的（类第一行代码那种）
        * 上下两种是一样的 *//*
        Request re = new Request.Builder().url("url").build();*/

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.action, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menuGet:
                get();//自定义
                break;
            case R.id.menuResponse:
                response();
                break;
            case R.id.menuPost:
                post();
        }
        return super.onOptionsItemSelected(item);
    }

    private void post() {
        Request request = new Request.Builder()
                .url(POST_URL).post(RequestBody.create(MEDIA_TYPE_MARKDOWN,"测试文字")).build();
        Call call = mclient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {

            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                if (response.isSuccessful()) {
                    final String string = response.body().string();
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            mContentTextView.setText(string);
                        }
                    });
                }
            }
        });
    }

    private void get() {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        executor.submit(new Runnable() {
            @Override
            public void run() {
                Request request = new Request.Builder()
                        .url("https://raw.githubusercontent.com/square/okhttp/master/README.md").build();
          try {
                    Response response = mclient.newCall(request).execute();
                    if (response.isSuccessful()) {
                        final String string = response.body().string();//body叫响应体
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() { mContentTextView.setText(string); }
                        });
                    } else {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                mContentTextView.setText("failed!");
                            }
                        });
                    }
            } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        executor.shutdown();
    }

    private void response() {
        Request request = new Request.Builder().url("https://raw.githubusercontent.com/square/okhttp/master/README.md").build();
        Call call = mclient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {
                Toast.makeText(MainActivity.this, "无反应", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                int code = response.code(); //响应码 应该还是标志回传信息是否成功
                Headers headers = response.headers();//headers 就是键值对
                String Type = headers.get("content-Type");
                String content = response.body().string();
                final StringBuilder sb = new StringBuilder();
                sb.append("code" + code).append(content).append(headers).append("Type: " + Type);
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        mContentTextView.setText(sb.toString());
                    }
                });
            }
        });
    }
}
