package com.example.retrofitrxjavademo;






import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;


import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.List;

public class SecondActivity extends AppCompatActivity {
    private DrawerLayout drawerLayout;
    private NavigationView nav;
    private Toolbar toolbar;
    private RecyclerView recyclerView;
    private int x = 3;
    private List<Photo> mPhotoList = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        nav = (NavigationView)findViewById(R.id.navigation_view);
        toolbar = (Toolbar) findViewById(R.id.toolbar2);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            //设置导航按钮(如果actionBar成功转化获取)
            actionBar.setDisplayHomeAsUpEnabled(true);
            //toolbar.setNavigationIcon(R.drawable.menu_open);
            //这两个都可以, 但是setDisplayHomeAsUpEnabled只有actionbar可以
            actionBar.setHomeAsUpIndicator(R.drawable.menu_open);
        } else {
            Toast.makeText(this, "注意! 获取actionBar失败", Toast.LENGTH_SHORT).show();
        }
        nav.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                //只要点击任何一个item都会关闭抽屉
                drawerLayout.closeDrawers();
                return true;
            }
        });
        initPhotos();
        recyclerView = (RecyclerView)findViewById(R.id.recycler);
        recyclerView.setAdapter(new PicAdapter(mPhotoList));
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.HORIZONTAL);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,RecyclerView.VERTICAL,false);
        recyclerView.setLayoutManager(staggeredGridLayoutManager);
    }

    private void initPhotos() {
        do {
            Photo photo = new Photo(R.drawable.p);
            mPhotoList.add(photo);
            Photo photo1 = new Photo(R.drawable.p1);
            mPhotoList.add(photo1);
            Photo photo2 = new Photo(R.drawable.p2);
            mPhotoList.add(photo2);
            Photo photo3 = new Photo(R.drawable.p3);
            mPhotoList.add(photo3);
            Photo photo4 = new Photo(R.drawable.p4);
            mPhotoList.add(photo4);
            Photo photo5 = new Photo(R.drawable.p5);
            mPhotoList.add(photo5);
            Photo photo6 = new Photo(R.drawable.p6);
            mPhotoList.add(photo6);
            Photo photo7 = new Photo(R.drawable.p7);
            mPhotoList.add(photo7);
            Photo photo8 = new Photo(R.drawable.p8);
            mPhotoList.add(photo8);
            x -= 1;
        }while (x != 0);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.birthday:
                Toast.makeText(this, "祝你生日快乐", Toast.LENGTH_SHORT).show();
                break;
                //这个home是系统指定的 要加android!!
            case android.R.id.home:
                drawerLayout.openDrawer(GravityCompat.START);
                break;
            case R.id.start:
                drawerLayout.openDrawer(GravityCompat.START);
                break;
            default :
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
