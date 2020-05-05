package com.example.retrofitrxjavademo;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.Toast;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    WebView mweb;
    Button pics;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        mweb = (WebView)findViewById(R.id.web);
        pics = (Button)findViewById(R.id.pics);

        pics.setOnClickListener(this);

        mweb.getSettings().setJavaScriptEnabled(true);
        mweb.setWebViewClient(new WebViewClient());
        mweb.loadUrl(Constants.bing);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "正在拨打110报警", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }
//    public void onAction(View view) {
//        //创建Retrofit对象 (在你最后.build()之前, 如果使用;结束语句会显示你的类型是Builder()而部匹配哦)
//        Retrofit retrofit = new Retrofit.Builder().baseUrl(Constants.BASE_URL)
//                .addConverterFactory(GsonConverterFactory.create()).build();
//        //获取UserMgrService
//        UserMgrService userMgrService = retrofit.create(UserMgrService.class);
//        //调用登录方法
//        final Call<UserInfoModel> call = userMgrService.login("king", "21");
//        //包装好后, 发送请求
//
////        new Thread(new Runnable() {
////            @Override
////            public void run() {
////                //execute同步方法, 返回一个响应体
////                //这里call是从一个内部类被访问的, 所以要声明final
////                Response<UserInfoModel> response = null;
////                try {
////                    response = call.execute();
////                } catch (IOException e) {
////                    e.printStackTrace();
////                }
////                System.out.println("code:" + response.body().code);
////            }
////        }).start();
//
//        call.enqueue(new Callback<UserInfoModel>() {
//            @Override
//            public void onResponse(Call<UserInfoModel> call, Response<UserInfoModel> response) {
//
//            }
//
//            @Override
//            public void onFailure(Call<UserInfoModel> call, Throwable t) {
//
//            }
//        });
//    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.toolbar, menu);
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.birthday:
                Toast.makeText(this, "Happy birthday to you", Toast.LENGTH_SHORT).show();
                break;
            case R.id.greetings:
                Toast.makeText(this, "Yo bitch", Toast.LENGTH_SHORT).show();
                break;
            default: break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.pics:
                Intent intent = new Intent(this,SecondActivity.class);
                startActivity(intent);
                break;
            default:
                break;
        }
    }
}
