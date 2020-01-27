package com.example.dialog;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void myClick(View view) {
        switch (view.getId()) {
            case R.id.nornal:
                //常用方法: 实例化builder, 在show()之前调用修饰方法
                //AlertDialog的构造器是protected 需要通过Builder
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle("提示").setMessage("确定退出吗?");
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                });
                builder.setNegativeButton("算了", null);
                //稍后提示按按钮
                builder.setNeutralButton("过会儿说", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
        });
                builder.show();
                break;
            case R.id.customize:

                break;
            default:
                Toast.makeText(this, "唷吼", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
